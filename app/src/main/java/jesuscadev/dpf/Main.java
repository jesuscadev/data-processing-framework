package jesuscadev.dpf;

import jesuscadev.dpf.core.DataProcessingFrameworkMain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
	public static Logger logger;

	private static String dpfConfigFile = "";
	private static DataProcessingFrameworkMain dpfMain;

	static {
		String loginPropertiesFile = "config/logging.properties";
		ClassLoader classLoader = Main.class.getClassLoader();
		try (InputStream inputStream = classLoader.getResourceAsStream(loginPropertiesFile)) {
			LogManager.getLogManager().readConfiguration(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.setProperty("java.util.logging.config.file", "src/main/resources/logging.properties");
		logger = Logger.getLogger("jesuscadev.dpf");
	}

	public static void main(String[] dpfArgs) {
		int numArgs = dpfArgs.length;

		logger.setLevel(Level.ALL);
		if (numArgs > 0) {
			logger.info("Processing command line arguments.");
		}
		logger.info("Started Data Processing Framework process.");
		try {
			getProperties();
			if (dpfConfigFile != "") {
				DataProcessingFrameworkMain dpfMain = new DataProcessingFrameworkMain();
				dpfMain.process(dpfConfigFile);
			} else {
				logger.severe("dpfConfigFile property not defined.");
			}
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
		logger.info("Finished Data Processing Framework process.");
	}

	private static void getProperties() throws IOException {
		logger.info("Started reading Properties.");
		String dpfPropertiesFile = "config/dpfProperties.xml";
		ClassLoader classLoader = Main.class.getClassLoader();
		try (InputStream inputStream = classLoader.getResourceAsStream(dpfPropertiesFile)) {
			logger.config("dpfPropertiesFile: [" + dpfPropertiesFile + "]");
			Properties dpfProps = new Properties();
			dpfProps.loadFromXML(inputStream);
			dpfConfigFile = dpfProps.getProperty("dpfConfigFile");
			logger.config("dpfConfigFile: [" + dpfConfigFile + "]");
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Finished reading Properties.");
		return;
	}
}
