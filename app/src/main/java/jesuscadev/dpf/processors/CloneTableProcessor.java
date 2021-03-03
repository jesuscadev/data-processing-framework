package jesuscadev.dpf.processors;

import jesuscadev.dpf.core.Processor;
import jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

import static jesuscadev.dpf.Main.logger;

@XmlRootElement
public class CloneTableProcessor implements Processor {
	private String name;
	private String inputTable;
	private String outputTable;
	private boolean replaceTable;

	public CloneTableProcessor() {
	}

	public String getName() {
		return name;
	}

	public String getInputTable() {
		return inputTable;
	}

	public String getOutputTable() {
		return outputTable;
	}

	public boolean getReplaceTable() {
		return replaceTable;
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
	public void setOutputTable(String outputTable) {
		this.outputTable = outputTable;
	}

	@XmlElement
	public void setReplaceTable(boolean replaceTable) {
		this.replaceTable = replaceTable;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
	}
}
