package com.jesuscadev.dpf.data;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
	private List<DataTable> dataTables;

	public DataSet() {
		dataTables = new ArrayList<>();
	}

	public void addTable(DataTable dataTable) {
		dataTables.add(dataTable);
	}

	public DataTable getTable(String tableName) {
		for (DataTable dataTable : dataTables) {
			if (dataTable.getName().equals(tableName)) {
				return dataTable;
			}
		}
		return null;
	}
}
