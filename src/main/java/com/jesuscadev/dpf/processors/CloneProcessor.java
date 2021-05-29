package com.jesuscadev.dpf.processors;

import com.jesuscadev.dpf.core.Processor;
import com.jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

import static com.jesuscadev.dpf.Main.logger;

@XmlRootElement
public class CloneProcessor implements Processor {
	private String name;
	private String inputTable;
	private String inputColumn;
	private String outputColumn;
	private boolean replaceColumn;

	public CloneProcessor() {
	}

	public String getName() {
		return name;
	}

	public String getInputTable() {
		return inputTable;
	}

	public String getInputColumn() {
		return inputColumn;
	}

	public String getOutputColumn() {
		return outputColumn;
	}

	public boolean getReplaceColumn() {
		return replaceColumn;
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
	public void setInputColumn(String inputColumn) {
		this.inputColumn = inputColumn;
	}

	@XmlElement
	public void setOutputColumn(String outputColumn) {
		this.outputColumn = outputColumn;
	}

	@XmlElement
	public void setReplaceColumn(boolean replaceColumn) {
		this.replaceColumn = replaceColumn;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
	}
}
