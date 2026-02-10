package com.automationexercices.drivers;

import com.automationexercices.utils.dataReader.PropertyReader;
import com.automationexercices.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public class FirefoxFactory extends AbstractDriver {
    private final String remoteHost = PropertyReader.getProperty("remoteHost");
    private final String remotePort = PropertyReader.getProperty("remotePort");

    private FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("disable-extensions");
        options.addArguments("--disable-gpu");
       if(PropertyReader.getProperty("executionType").equalsIgnoreCase("LocalHeadless") || PropertyReader.getProperty("executionType").equalsIgnoreCase("Remote")){
           options.addArguments("--headless");
       }
        options.setAcceptInsecureCerts(true);
        // Note: PageLoadStrategy can be set similarly if needed

        return options;
    }
    @Override
    public WebDriver createDriver() {
        if(PropertyReader.getProperty("executionType").equalsIgnoreCase("LocalHeadless") || PropertyReader.getProperty("executionType").equalsIgnoreCase("Remote"))
        {  return new FirefoxDriver(getOptions());}
        else if(PropertyReader.getProperty("executionType").equalsIgnoreCase("Remote")) {
            try {
                return new RemoteWebDriver(
                        new URI("http://"+remoteHost +":"+remotePort+"/wd/hub").toURL(),getOptions()

                );
            } catch (Exception e) {
                LogsManager.error("Failed to create RemoteWebDriver: ", e.getMessage());
                throw new RuntimeException(e);
            }
        } else {
            LogsManager.error("Invalid execution type: ", PropertyReader.getProperty("executionType"));
        }
        throw new IllegalArgumentException("Invalid execution type: " + PropertyReader.getProperty("executionType"));
    }
}
