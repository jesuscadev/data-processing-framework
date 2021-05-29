package com.jesuscadev.dpf.core;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import static com.jesuscadev.dpf.Main.logger;

@XmlSeeAlso({Parameter.class, Solution.class})
@XmlRootElement
public class DataProcessingFramework {
	private String name;

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<Parameter> parameters;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<Solution> solutions;

	public DataProcessingFramework() {
		parameters = new ArrayList<>();
		solutions = new ArrayList<>();
	}

	public void process() {
		logger.info(name);
		logger.info("Processing Parameters.");
		for (Parameter parameter : parameters) {
			logger.info("- " + parameter.getName() + ": <" + parameter.getValue() + ">");
		}
		logger.info("Processing Solutions.");
		for (Solution solution : solutions) {
			logger.info(solution.getName());
			solution.process();
		}
		logger.info("Process Finished Successfully.");
	}
}
