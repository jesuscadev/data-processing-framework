package com.jesuscadev.dpf.processors;

import com.jesuscadev.dpf.core.Processor;
import com.jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

import static com.jesuscadev.dpf.Main.logger;

@XmlRootElement
public class MapProcessor implements Processor {
	private String name;
	private String inputTable;
	private String mappingTable;
	private String keyColumn;
	private String valueColumn;

	public MapProcessor() {
	}

	public String getName() {
		return name;
	}

	public String getInputTable() {
		return inputTable;
	}

	public String getMappingTable() {
		return mappingTable;
	}

	public String getKeyColumn() {
		return keyColumn;
	}

	public String getValueColumn() {
		return valueColumn;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setInputTable(String inputTable) {
		this.inputTable = inputTable;
	}

	@XmlElement
	public void setMappingTable(String mappingTable) {
		this.mappingTable = mappingTable;
	}

	@XmlElement
	public void setKeyColumn(String keyColumn) {
		this.keyColumn = keyColumn;
	}

	@XmlElement
	public void setValueColumn(String valueColumn) {
		this.valueColumn = valueColumn;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
	}
}
