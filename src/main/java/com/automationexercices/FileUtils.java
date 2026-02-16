package com.automationexercices;

import com.automationexercices.utils.dataReader.PropertyReader;
import com.automationexercices.utils.logs.LogsManager;

import java.io.File;

public class FileUtils {
    private static final String USER_DIR = PropertyReader.getProperty("user.dir")+ File.separator;
    private  FileUtils() {
        // Private constructor to prevent instantiation
    }

    //Renaming
    public static void renameFile(String oldPath, String newPath) {
        try {
            File oldFile = new File(USER_DIR + oldPath);
            File newFile = new File(USER_DIR + newPath);

            if (oldFile.exists()) {
                if (oldFile.renameTo(newFile)) {
                    LogsManager.info("File renamed successfully: ", oldPath, " to ", newPath);
                } else {
                    LogsManager.error("Failed to rename file: ", oldPath, " to ", newPath);
                }
            } else {
                LogsManager.error("File not found for renaming: ", oldPath);
            }
        } catch (Exception e) {
            LogsManager.error("Error renaming file: ", oldPath, " to ", newPath, " - ", e.getMessage());
        }
    }

    //creating Directory
    public static void createDirectory(String path) {
        try {
           File file=new File(USER_DIR+path);
              if (!file.exists()) {
                if (file.mkdirs()) {
                    LogsManager.info("Directory created successfully: ", path);
                } else {
                    LogsManager.error("Failed to create directory: ", path);
                }
              }
        } catch (Exception e) {
            LogsManager.error("Error creating directory: ", path, " - ", e.getMessage());
        }
    }

    //cleaning Directory
     public static void cleanDirectory(File file){
        try {
            org.apache.commons.io.FileUtils.deleteQuietly(file);
        } catch (Exception e) {
            LogsManager.error("Failed to clean directory: ", file.getName(), " - ", e.getMessage());
        }

     }


}
