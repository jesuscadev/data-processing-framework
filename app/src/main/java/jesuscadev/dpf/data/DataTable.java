package jesuscadev.dpf.data;

import java.util.ArrayList;
import java.util.List;

public class DataTable {
	private String name;

	public List<DataColumn> dataColumns;

	public List<DataRow> dataRows;

	public DataTable(String name) {
		this.name = name;
		this.dataColumns = new ArrayList<>();
		this.dataRows = new ArrayList<>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addColumn(DataColumn dataColumn) {
		this.dataColumns.add(dataColumn);
	}

	public void addRow(DataRow dataRow) {
		this.dataRows.add(dataRow);
	}

	public boolean columnExists(String columnName) {
		for (DataColumn dataColumn : dataColumns) {
			if (columnName.equals(dataColumn.getName())) {
				return true;
			}
		}
		return false;
	}

	public DataRow getColumnsRow() {
		DataRow dataRow = new DataRow(dataColumns.size());
		int i = 0;
		for (DataColumn dataColumn : dataColumns) {
			dataRow.addValue(i++, dataColumn.getName());
		}
		return dataRow;
	}

	public String getColumnDataType(int columnIndex) {
		return dataColumns.get(columnIndex).getDataType();
	}

	public int getColumnLength(int columnIndex) {
		return dataColumns.get(columnIndex).getLength();
	}

	public boolean isColumnString(int columnIndex) {
		return getColumnDataType(columnIndex).equals("String");
	}
}
