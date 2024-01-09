package com.qa.config;

import com.qa.utilities.FileReader;

import java.util.Properties;

public class EnvironmentConfig {
    private EnvironmentConfig() {

    }
    private static Properties environmentproperties;

    static {
        if (FrameworkConfig.getEnvironment().equalsIgnoreCase("dev")) {
            environmentproperties = FileReader.readPropertiesFile("./src/main/resources/dev-config.properties");
        } else if (FrameworkConfig.getEnvironment().equalsIgnoreCase("stage")) {
            environmentproperties = FileReader.readPropertiesFile("./src/main/resources/stage-config.properties");
        } else {
            throw new RuntimeException("Invalid property file");
        }
    }

    public static String getBaseURL() {
        return environmentproperties.getProperty("baseUrl");
    }

    public static String getUserName() {
        return environmentproperties.getProperty("username");
    }

    public static String getPassword() {
        return environmentproperties.getProperty("password");
    }

}
