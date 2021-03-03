package jesuscadev.dpf.processors;

import jesuscadev.dpf.core.Processor;
import jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jesuscadev.dpf.Main.logger;

@XmlRootElement
public class RemoveProcessor implements Processor {
	private String name;
	private String inputTable;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<String> removeColumns;

	public RemoveProcessor() {
		removeColumns = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getInputTable() {
		return inputTable;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setInputTable(String inputTable) {
		this.inputTable = inputTable;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
	}
}
