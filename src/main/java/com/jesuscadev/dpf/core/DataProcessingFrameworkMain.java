package com.jesuscadev.dpf.core;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static com.jesuscadev.dpf.Main.logger;

public class DataProcessingFrameworkMain {
	private JAXBContext jaxbContext;
	private Unmarshaller unmarshaller;
	private DataProcessingFramework dataProcessingFramework;

	public DataProcessingFrameworkMain() {
		logger.entering("Process started.", "DataProcessingFrameworkMain()");
		try {
			jaxbContext = JAXBContext.newInstance(DataProcessingFramework.class);
			unmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			logger.severe(e.getMessage());
		} finally {
			logger.entering("Process finished.", "DataProcessingFrameworkMain()");
		}
	}

	public void process(String configFile) {
		logger.entering("Process started.", "process");
		if (configFile.equals("")) {
			logger.severe("Empty value for configFile");
			return;
		}
		try {
			File file = new File(configFile);
			dataProcessingFramework = (DataProcessingFramework) unmarshaller.unmarshal(file);
			dataProcessingFramework.process();
		} catch (JAXBException e) {
			logger.severe(e.getMessage());
		} finally {
			logger.entering("Process finished.", "process");
		}
	}
}
