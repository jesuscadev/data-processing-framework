package jesuscadev.dpf.processors;

import jesuscadev.dpf.core.Processor;
import jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jesuscadev.dpf.Main.logger;

@XmlRootElement
public class ConciliateProcessor implements Processor {
	private String name;
	private String firstInputTable;
	private String secondInputTable;
	private String matchedTable;
	private String unmatchedTable;
	private String firstPrefix;
	private String secondPrefix;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<String> keyColumns;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<String> valueColumns;

	public ConciliateProcessor() {
		keyColumns = new ArrayList<>();
		valueColumns = new ArrayList<>();
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

	public String getMatchedTable() {
		return matchedTable;
	}

	public String getUnmatchedTable() {
		return unmatchedTable;
	}

	public String getFirstPrefix() {
		return firstPrefix;
	}

	public String getSecondPrefix() {
		return secondPrefix;
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
	public void setMatchedTable(String matchedTable) {
		this.matchedTable = matchedTable;
	}

	@XmlElement
	public void setUnmatchedTable(String unmatchedTable) {
		this.unmatchedTable = unmatchedTable;
	}

	@XmlElement
	public void setFirstPrefix(String firstPrefix) {
		this.firstPrefix = firstPrefix;
	}

	@XmlElement
	public void setSecondPrefix(String secondPrefix) {
		this.secondPrefix = secondPrefix;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
	}
}
