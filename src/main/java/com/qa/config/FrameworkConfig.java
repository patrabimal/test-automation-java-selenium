package com.qa.config;

import com.qa.utilities.FileReader;

import java.util.Properties;

public final class FrameworkConfig {
    private FrameworkConfig(){

    }
    private static Properties frameworkProperties;
    static{
        frameworkProperties = FileReader.readPropertiesFile("./src/main/resources/framework-config.properties");
    }
    public static String getBrowser(){
        return frameworkProperties.getProperty("browser");
    }

    public static String getEnvironment(){
        return frameworkProperties.getProperty("environment");
    }


}
