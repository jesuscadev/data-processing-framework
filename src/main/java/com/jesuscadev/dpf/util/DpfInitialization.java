package com.jesuscadev.dpf.util;

import static com.jesuscadev.dpf.Main.logger;

import com.jesuscadev.dpf.Main;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DpfInitialization {
	private static String dpfConfigFile = "";

	public static String getDpfConfigFile() {
		return dpfConfigFile;
	}

	public static void setDpfConfigFile(String dpfConfigFile) {
		DpfInitialization.dpfConfigFile = dpfConfigFile;
	}

	public static void initializeLogger(String loginPropertiesFile) {
		ClassLoader classLoader = Main.class.getClassLoader();
		try (InputStream inputStream = classLoader.getResourceAsStream(loginPropertiesFile)) {
			LogManager.getLogManager().readConfiguration(inputStream);
		} catch (IOException e) {
			logger.severe(e.getMessage());
		}
		System.setProperty("java.util.logging.config.file", "src/main/resources/config/logging.properties");
		logger = Logger.getLogger("jesuscadev.dpf");
	}

	public static void readProperties(String dpfPropertiesFile) {
		logger.entering("Started reading Properties.", "readProperties");
		ClassLoader classLoader = Main.class.getClassLoader();
		try (InputStream inputStream = classLoader.getResourceAsStream(dpfPropertiesFile)) {
			logger.config("dpfPropertiesFile: [" + dpfPropertiesFile + "]");
			Properties dpfProps = new Properties();
			dpfProps.loadFromXML(inputStream);
			setDpfConfigFile(dpfProps.getProperty("dpfConfigFile"));
			logger.config("dpfConfigFile: [" + dpfConfigFile + "]");
		} catch (IOException e) {
			logger.severe(e.getMessage());
		} finally {
			logger.exiting("Finished reading Properties.", "readProperties");
		}
		return;
	}

	public static void processArguments(String[] dpfArgs) {
		int numArgs = dpfArgs.length;

		if (numArgs > 0) {
			logger.info("Processing command line arguments.");
			int argNum = 0;
			while (argNum < dpfArgs.length) {
				String dpfArg = dpfArgs[argNum];
				switch (dpfArg) {
					case "-c":
					case "-config": {
						if (argNum < dpfArgs.length - 1) {
							setDpfConfigFile(dpfArgs[++argNum]);
							logger.config("dpfConfigFile: [" + getDpfConfigFile() + "]");
						}
					}
				}
				argNum++;
			}
		}
	}
}
