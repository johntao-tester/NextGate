package com.nextgate.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

    private static Properties properties;

    static {
        try {
            String path = "src/test/resources/NextGateConfigs.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //only one method to read a value from configs.properties file
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
