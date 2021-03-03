package jesuscadev.dpf;

import jesuscadev.dpf.core.DataProcessingFrameworkMain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
//	public static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static Logger logger;

	private static String dpfConfigFile = "";
	private static DataProcessingFrameworkMain dpfMain;

	static {
		InputStream stream = Main.class.getClassLoader().
			getResourceAsStream("logging.properties");
		try {
			LogManager.getLogManager().readConfiguration(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger = Logger.getLogger(Main.class.getName());

		System.setProperty("java.util.logging.config.file", "src/main/resources/logging.properties");
		logger = Logger.getLogger("jkdev.dpf");
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

	private static void getProperties() {
		logger.info("Started reading Properties.");
		try {
			String dpfRootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			String dpfPropertiesPath = dpfRootPath + "dpfProperties.xml";
			logger.config("dpfPropertiesPath: [" + dpfPropertiesPath + "]");
			Properties dpfProps = new Properties();
			dpfProps.loadFromXML(new FileInputStream(dpfPropertiesPath));
			dpfConfigFile = dpfProps.getProperty("dpfConfigFile");
			logger.config("dpfConfigFile: [" + dpfConfigFile + "]");
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
		logger.info("Finished reading Properties.");
		return;
	}
}
