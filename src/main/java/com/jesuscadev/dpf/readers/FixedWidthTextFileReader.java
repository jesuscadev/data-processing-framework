package com.jesuscadev.dpf.readers;

import com.jesuscadev.dpf.core.Reader;
import com.jesuscadev.dpf.data.DataColumn;
import com.jesuscadev.dpf.data.DataRow;
import com.jesuscadev.dpf.data.DataSet;
import com.jesuscadev.dpf.data.DataTable;

import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.jesuscadev.dpf.Main.logger;

@XmlSeeAlso({DataColumn.class})
@XmlRootElement
public class FixedWidthTextFileReader implements Reader {
	private String name;
	private String filePath;
	private int headerLines;

	private File file;
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<DataColumn> dataColumns;

	public FixedWidthTextFileReader() {
		file = null;
		fileReader = null;
		bufferedReader = null;
		dataColumns = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getFilePath() {
		return filePath;
	}

	public int getHeaderLines() {
		return headerLines;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@XmlElement
	public void setHeaderLines(int headerLines) {
		this.headerLines = headerLines;
	}

	@Override
	public void readData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "readData");
		logger.info(name);
		try {
			open();
			readAll(dataSet);
		} catch (IOException e) {
			logger.severe(e.toString());
			throw e;
		} finally {
			close();
		}
		logger.exiting(this.getName(), "readData");
	}

	private void readAll(DataSet dataSet) throws IOException {
		String nextLine;
		DataTable dataTable;
		logger.info(name);
		try {
			dataTable = new DataTable(name);
			dataTable.dataColumns = this.dataColumns;
			int line = 0;
			while ((nextLine = bufferedReader.readLine()) != null) {
				line++;
				if (line <= this.headerLines) {
					logger.info("Discarded header line: [" + nextLine + "]");
				} else {
					DataRow dataRow = new DataRow(dataColumns.size());
					int columnIndex = 0;
					for (DataColumn dataColumn : dataColumns) {
						String columnValue;
						if (nextLine.length() <= dataColumn.getPosition() + dataColumn.getLength()) {
							columnValue = nextLine.substring(dataColumn.getPosition());
						} else {
							columnValue = nextLine.substring(dataColumn.getPosition(), dataColumn.getPosition() + dataColumn.getLength());
						}
						dataRow.addValue(columnIndex++, columnValue);
					}
					dataTable.addRow(dataRow);
				}
			}
			logger.info("Finished reading [" + line + "] lines.");
			dataSet.addTable(dataTable);
		} catch (IOException e) {
			logger.severe(e.toString());
			throw e;
		}
	}

	private void open() throws FileNotFoundException {
		file = new File(filePath);
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
	}

	private void close() throws IOException {
		bufferedReader.close();
	}
}
