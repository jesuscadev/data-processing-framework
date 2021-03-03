package jesuscadev.dpf.processors;

import jesuscadev.dpf.core.Processor;
import jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

import static jesuscadev.dpf.Main.logger;

@XmlRootElement
public class TransformProcessor implements Processor {
	private String name;
	private String inputTable;
	private String inputColumn;
	private String dataType;
	private String transformFormula;

	public TransformProcessor() {
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

	public String getDataType() {
		return dataType;
	}

	public String getTransformFormula() {
		return transformFormula;
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
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@XmlElement
	public void setTransformFormula(String transformFormula) {
		this.transformFormula = transformFormula;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
	}
}
