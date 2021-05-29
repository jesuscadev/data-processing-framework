package com.jesuscadev.dpf.processors;

import com.jesuscadev.dpf.core.Processor;
import com.jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.util.ArrayList;

import static com.jesuscadev.dpf.Main.logger;

@XmlRootElement
public class SortProcessor implements Processor {
	private String name;
	private String inputTable;

	@XmlElementWrapper(name = "sortColumns")
	@XmlElement(name = "sortColumn")
	public ArrayList<String> sortColumns;

	public SortProcessor() {
//		sortColumns = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getInputTable() {
		return inputTable;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setInputTable(String inputTable) {
		this.inputTable = inputTable;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
		/*
		Table table = TablesUtils.getTableByName(tables, inputTable);
		List<String[]> rows = new ArrayList<>();
		List<String> columns = new ArrayList<>();
		String[] tableColumns = table.columnsRow();
		logger.info(name);
		for (String sortColumn : sortColumns) {
			if (table.columnExists(sortColumn)) {
				columns.add(sortColumn);
			}
		}
		for (String tableColumn : tableColumns) {
			boolean columnExists = false;
			for (String sortColumn : sortColumns) {
				if (tableColumn.equals(sortColumn)) {
					columnExists = true;
					break;
				}
			}
			if (columnExists == false)
				columns.add(tableColumn);
		}
		for (String[] row : table.rows) {

		}
		Collections.sort(table.rows, new Comparator<String[]>() {
			public int compare(String[] strings, String[] otherStrings) {
				return strings[1].compareTo(otherStrings[1]);
			}
		});
//		tables.add(table);
		*/
	}
}
