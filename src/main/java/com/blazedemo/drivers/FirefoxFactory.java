package com.blazedemo.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxFactory extends AbstractDriver {
   private FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("disable-extensions");
        options.addArguments("--disable-gpu");
        options.setAcceptInsecureCerts(true);
        // Note: PageLoadStrategy can be set similarly if needed

        return options;
    }
    @Override
    public WebDriver createDriver() {
    return new FirefoxDriver(getOptions());
    }
}
