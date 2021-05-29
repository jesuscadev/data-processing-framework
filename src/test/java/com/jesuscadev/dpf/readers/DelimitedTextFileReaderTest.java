package com.jesuscadev.dpf.readers;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.jesuscadev.dpf.data.DataColumn;
import com.jesuscadev.dpf.data.DataSet;

public class DelimitedTextFileReaderTest {
	@Test
	public void shouldReadFile() throws IOException {
		DataSet dataSet = new DataSet();
		DelimitedTextFileReader delimitedTextFileReader = new DelimitedTextFileReader();

		delimitedTextFileReader.setName("transactions_txt");
		delimitedTextFileReader.setFilePath("test-input/transactions.txt");
		delimitedTextFileReader.setHeaderLines(3);

		DataColumn dataColumns[] = new DataColumn[4];

		dataColumns[0] = new DataColumn();
		dataColumns[0].setName("ID");
		dataColumns[0].setPosition(0);
		dataColumns[0].setLength(8);
		dataColumns[0].setDataType("String");
		
		dataColumns[1] = new DataColumn();
		dataColumns[1].setName("TransactionDate");
		dataColumns[1].setPosition(8);
		dataColumns[1].setLength(10);
		dataColumns[1].setDataType("Date");
		dataColumns[1].setFormat("MM/dd/yyyy");
		
		dataColumns[2] = new DataColumn();
		dataColumns[2].setName("Concept");
		dataColumns[2].setPosition(18);
		dataColumns[2].setLength(32);
		dataColumns[2].setDataType("String");
		
		dataColumns[3] = new DataColumn();
		dataColumns[3].setName("Amount");
		dataColumns[3].setPosition(50);
		dataColumns[3].setLength(10);
		dataColumns[3].setDataType("double");
		dataColumns[3].setDecimals(2);
		
		for(DataColumn dataColumn : dataColumns) {
			delimitedTextFileReader.dataColumns.add(dataColumn);
		}
		delimitedTextFileReader.readData(dataSet);
		int readRows = dataSet.getTable(delimitedTextFileReader.getName()).dataRows.size();
		assertEquals(readRows, 10);
	}
}
