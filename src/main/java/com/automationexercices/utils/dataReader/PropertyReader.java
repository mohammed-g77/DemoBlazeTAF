package com.automationexercices.utils.dataReader;

import com.automationexercices.utils.logs.LogsManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Properties;

public class PropertyReader {

    // Load all .properties files into System properties
    public static Properties loadProperties() {

        Properties properties = new Properties();

        try {
            Collection<File> propertiesFiles = FileUtils.listFiles(
                    new File("src/main/resources"),
                    new String[]{"properties"},
                    true
            );

            for (File file : propertiesFiles) {
                try {
                    properties.load(FileUtils.openInputStream(file));
                } catch (Exception e) {
                    LogsManager.error("Failed to load properties file: ", file.getName(), " - ", e.getMessage());
                }
            }

            // Put loaded properties into System properties
            System.getProperties().putAll(properties);

        } catch (Exception e) {
                LogsManager.error("Error reading properties directory: ", e.getMessage());
            System.out.println("Error reading properties directory");
        }

        return properties;
    }

    public static String getProperty(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            LogsManager.error("Failed to get property: ", key, " - ", e.getMessage());
            return  "";
        }
    }

}
