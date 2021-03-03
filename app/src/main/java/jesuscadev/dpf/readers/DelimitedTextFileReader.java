package jesuscadev.dpf.readers;

import jesuscadev.dpf.core.Reader;
import jesuscadev.dpf.data.DataColumn;
import jesuscadev.dpf.data.DataRow;
import jesuscadev.dpf.data.DataSet;
import jesuscadev.dpf.data.DataTable;

import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static jesuscadev.dpf.Main.logger;

@XmlSeeAlso({DataColumn.class})
@XmlRootElement
public class DelimitedTextFileReader implements Reader {
	private String name;
	private String filePath;
	private String delimiter;
	private int headerLines;

	private File file;
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<DataColumn> dataColumns;

	public DelimitedTextFileReader() {
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

	public String getDelimiter() {
		return delimiter;
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
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
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
		}
		catch (IOException e) {
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
					String[] tokens = nextLine.split(delimiter);
					int columnIndex = 0;
					for (DataColumn column : dataColumns) {
						dataRow.addValue(columnIndex++, tokens[column.getPosition()]);
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
