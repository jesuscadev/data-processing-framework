package com.jesuscadev.dpf.processors;

import com.jesuscadev.dpf.core.Processor;
import com.jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jesuscadev.dpf.Main.logger;

@XmlRootElement
public class JoinProcessor implements Processor {
	private String name;
	private String firstInputTable;
	private String secondInputTable;
	private String outputTable;
	private String firstKeyColumn;
	private String secondKeyColumn;
	private String outputKeyColumn;
	private boolean externalJoin;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<String> firstColumns;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<String> secondColumns;

	public JoinProcessor() {
		firstColumns = new ArrayList<>();
		secondColumns = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getFirstInputTable() {
		return firstInputTable;
	}

	public String getSecondInputTable() {
		return secondInputTable;
	}

	public String getOutputTable() {
		return outputTable;
	}

	public String getFirstKeyColumn() {
		return firstKeyColumn;
	}

	public String getSecondKeyColumn() {
		return secondKeyColumn;
	}

	public String getOutputKeyColumn() {
		return outputKeyColumn;
	}

	public boolean getExternalJoin() {
		return externalJoin;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setFirstInputTable(String firstInputTable) {
		this.firstInputTable = firstInputTable;
	}

	@XmlElement
	public void setSecondInputTable(String secondInputTable) {
		this.secondInputTable = secondInputTable;
	}

	@XmlElement
	public void setOutputTable(String outputTable) {
		this.outputTable = outputTable;
	}

	@XmlElement
	public void setFirstKeyColumn(String firstKeyColumn) {
		this.firstKeyColumn = firstKeyColumn;
	}

	@XmlElement
	public void setSecondKeyColumn(String secondKeyColumn) {
		this.secondKeyColumn = secondKeyColumn;
	}

	@XmlElement
	public void setOutputKeyColumn(String outputKeyColumn) {
		this.outputKeyColumn = outputKeyColumn;
	}

	@XmlElement
	public void setExternalJoin(boolean externalJoin) {
		this.externalJoin = externalJoin;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
	}
}
