package com.jesuscadev.dpf.data;

public class DataRow {
	private int length;
	private String[] values;

	public DataRow(int columns) {
		length = columns;
		values = new String[length];
	}

	public int getLength() {
		return length;
	}

	public String[] getValues() {
		return values;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public void addValue(int columnIndex, String value) {
		values[columnIndex] = value;
	}

	public String getValue(int columnIndex) {
		return values[columnIndex];
	}
}
