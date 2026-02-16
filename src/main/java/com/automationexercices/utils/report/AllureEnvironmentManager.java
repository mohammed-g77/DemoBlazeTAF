package com.automationexercices.utils.report;

import com.automationexercices.utils.dataReader.PropertyReader;
import com.automationexercices.utils.logs.LogsManager;
import com.google.common.collect.ImmutableMap;

import java.io.File;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;


public class AllureEnvironmentManager {
    public static void setEnvironmentVariables() {

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("OS", PropertyReader.getProperty("os.name"))
                        .put("Java version", PropertyReader.getProperty("java.runtime.version"))
                        .put("Browser", PropertyReader.getProperty("browserType"))
                        .put("Execution Type", PropertyReader.getProperty("executionType"))
                        .put("URL", PropertyReader.getProperty("baseUrlWeb"))
                        .build(),
                String.valueOf(AllureConstants.RESULTS_FOLDER) + File.separator
        );

        LogsManager.info("Allure environment variables set.");
        AllureBinaryManager.downloadAndExtract();
    }
}

