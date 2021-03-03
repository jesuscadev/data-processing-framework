package jesuscadev.dpf.core;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static jesuscadev.dpf.Main.logger;

public class DataProcessingFrameworkMain {
	public DataProcessingFrameworkMain() {}

	public void process(String configFile) {
		logger.info("Process started.");
		try {
			File file = new File(configFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(DataProcessingFramework.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			DataProcessingFramework dataProcessingFramework = (DataProcessingFramework) unmarshaller.unmarshal(file);
			dataProcessingFramework.process();
		} catch (JAXBException e) {
			logger.severe(e.getMessage());
		}
		logger.info("Process finished.");
	}
}
