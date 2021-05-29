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

		delimitedTextFileReader.setName("transactions_csv");
		delimitedTextFileReader.setFilePath("test-input/transactions.csv");
		delimitedTextFileReader.setDelimiter(",");
		delimitedTextFileReader.setHeaderLines(1);

		DataColumn dataColumns[] = new DataColumn[4];

		dataColumns[0] = new DataColumn();
		dataColumns[0].setName("ID");
		dataColumns[0].setPosition(0);
		dataColumns[0].setDataType("String");
		
		dataColumns[1] = new DataColumn();
		dataColumns[1].setName("TransactionDate");
		dataColumns[1].setPosition(1);
		dataColumns[1].setDataType("Date");
		dataColumns[1].setFormat("MM/dd/yyyy");
		
		dataColumns[2] = new DataColumn();
		dataColumns[2].setName("Concept");
		dataColumns[2].setPosition(2);
		dataColumns[2].setDataType("String");
		
		dataColumns[3] = new DataColumn();
		dataColumns[3].setName("Amount");
		dataColumns[3].setPosition(3);
		dataColumns[3].setDataType("double");
		dataColumns[3].setDecimals(2);
		
		for(DataColumn dataColumn : dataColumns) {
			delimitedTextFileReader.dataColumns.add(dataColumn);
		}
		delimitedTextFileReader.readData(dataSet);
		int readRows = dataSet.getTable("transactions_csv").dataRows.size();
		assertEquals(readRows, 10);
	}
}
