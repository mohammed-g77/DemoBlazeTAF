package com.automationexercices.utils;

import com.automationexercices.utils.dataReader.PropertyReader;

public class OSUtils {
    private enum OS {
        WINDOWS, MAC, LINUX, OTHER
    }
    public static OS getOS() {
        String osName = PropertyReader.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return OS.WINDOWS;
        } else if (osName.contains("mac")) {
            return OS.MAC;
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            return OS.LINUX;
        } else {
            return OS.OTHER;
        }
    }





}
