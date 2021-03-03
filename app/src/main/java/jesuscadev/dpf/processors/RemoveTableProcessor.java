package jesuscadev.dpf.processors;

import jesuscadev.dpf.core.Processor;
import jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jesuscadev.dpf.Main.logger;

@XmlRootElement
public class RemoveTableProcessor implements Processor {
	private String name;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<String> removeTables;

	public RemoveTableProcessor() {
		removeTables = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
	}
}
