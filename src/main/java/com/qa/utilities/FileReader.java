package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileReader {
    public static Properties readPropertiesFile(String filePath) {
        Properties properties = new Properties();
        File src;
        try {
            src = new File(filePath);
        } catch (Exception e) {
            throw new RuntimeException("Please check the file path");
        }
        try {
            FileInputStream fis = new FileInputStream(src);
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Invalid properties file");
        }
        return properties;

    }

}
