package com.jesuscadev.dpf.processors;

import com.jesuscadev.dpf.core.Processor;
import com.jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jesuscadev.dpf.Main.logger;

@XmlRootElement
public class DivideProcessor implements Processor {
	private String name;
	private String inputTable;
	private String firstOutputTable;
	private String secondOutputTable;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<String> firstColumns;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<String> secondColumns;

	public DivideProcessor() {
		firstColumns = new ArrayList<>();
		secondColumns = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getInputTable() {
		return inputTable;
	}

	public String getFirstOutputTable() {
		return firstOutputTable;
	}

	public String getSecondOutputTable() {
		return secondOutputTable;
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
	public void setFirstOutputTable(String firstOutputTable) {
		this.firstOutputTable = firstOutputTable;
	}

	@XmlElement
	public void setSecondOutputTable(String secondOutputTable) {
		this.secondOutputTable = secondOutputTable;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
	}
}
