package jesuscadev.dpf.util;

import static jesuscadev.dpf.Main.logger;

import jesuscadev.dpf.Main;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class DpfProperties {

    private static String dpfConfigFile = "";
    public static String getDpfConfigFile() { return dpfConfigFile; }
	public static void setDpfConfigFile(String dpfConfigFile) { DpfProperties.dpfConfigFile = dpfConfigFile; }

    public static void getProperties() throws IOException {
		logger.info("Started reading Properties.");
		String dpfPropertiesFile = "config/dpfProperties.xml";
		ClassLoader classLoader = Main.class.getClassLoader();
		try (InputStream inputStream = classLoader.getResourceAsStream(dpfPropertiesFile)) {
			logger.config("dpfPropertiesFile: [" + dpfPropertiesFile + "]");
			Properties dpfProps = new Properties();
			dpfProps.loadFromXML(inputStream);
			setDpfConfigFile(dpfProps.getProperty("dpfConfigFile"));
			logger.config("dpfConfigFile: [" + dpfConfigFile + "]");
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Finished reading Properties.");
		return;
	}
}
