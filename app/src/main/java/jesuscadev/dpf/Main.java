package jesuscadev.dpf;

import jesuscadev.dpf.core.DataProcessingFrameworkMain;
import jesuscadev.dpf.util.DpfProperties;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
	public static Logger logger;
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

	public static void main(String[] dpfArgs) throws IOException {
		int numArgs = dpfArgs.length;

        DpfProperties.getProperties();
		logger.setLevel(Level.ALL);
		if (numArgs > 0) {
			logger.info("Processing command line arguments.");
            int argNum = 0;
            while (argNum < dpfArgs.length) {
                String dpfArg = dpfArgs[argNum];
                switch (dpfArg) {
                    case "-c":
                    case "-config": {
                        if (argNum < dpfArgs.length - 1) {
                            DpfProperties.setDpfConfigFile(dpfArgs[++argNum]);
                            logger.config("dpfConfigFile: [" + DpfProperties.getDpfConfigFile() + "]");
                        }
                    }
                    argNum++;
                }
            }
		}
		logger.info("Started Data Processing Framework process.");
		try {
			if (!DpfProperties.getDpfConfigFile().equals("")) {
				DataProcessingFrameworkMain dpfMain = new DataProcessingFrameworkMain();
				dpfMain.process(DpfProperties.getDpfConfigFile());
			} else {
				logger.severe("dpfConfigFile property not defined.");
			}
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
		logger.info("Finished Data Processing Framework process.");
	}
}
