package com.qa.config;

import java.util.Properties;

import com.qa.utilities.FileReader;

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

    public static String getBaseURLWeb() {
        return environmentproperties.getProperty("baseUrlWeb");
    }

    public static String getUserName() {
        return environmentproperties.getProperty("username");
    }

    public static String getPassword() {
        return environmentproperties.getProperty("password");
    }

    public static String getBaseURLApi() {
        return environmentproperties.getProperty("baseUrlApi");
    }

    public static String getApiKey() {
        return environmentproperties.getProperty("apiKey");
    }

    public static String getBookingById() {
        return environmentproperties.getProperty("getBookingById");
    }

    public static String getBooking() {return environmentproperties.getProperty("getBooking");}

    public static String postCredential() {
        return environmentproperties.getProperty("postCredential");
    }

}
