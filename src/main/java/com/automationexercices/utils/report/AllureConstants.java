package com.automationexercices.utils.report;

import com.automationexercices.utils.dataReader.PropertyReader;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllureConstants {
    // paths > final static

        // static
        final Path USER_DIR = Paths.get(PropertyReader.getProperty("user.dir"), File.separator);
        final Path USER_HOME = Paths.get(PropertyReader.getProperty("user.home"), File.separator);

        static final Path RESULTS_FOLDER = Paths.get(String.valueOf(USER_DIR), "test-outputs", "allure-results", File.separator);
        final Path REPORT_PATH = Paths.get(String.valueOf(USER_DIR), "test-outputs", "reports", File.separator);
        final Path FULL_REPORT_PATH = Paths.get(String.valueOf(USER_DIR), "test-outputs", "full-report", File.separator);

        final Path HISTORY_FOLDER = Paths.get(FULL_REPORT_PATH.toString(), "history", File.separator);
        final Path RESULTS_HISTORY_FOLDER = Paths.get(RESULTS_FOLDER.toString(), "history", File.separator);

        final String INDEX_HTML = "index.html";
        final String REPORT_PREFIX = "AllureReport-";
        final String REPORT_EXTENSION = ".html";

        final String ALLURE_ZIP_BASE_URL =
                "https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/";

        final Path EXTRACTION_DIR = Paths.get(String.valueOf(USER_HOME),
                ".m2/repository/allure", File.separator);

}
