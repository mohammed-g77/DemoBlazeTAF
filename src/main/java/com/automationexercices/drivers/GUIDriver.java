package com.automationexercices.drivers;

import com.automationexercices.utils.dataReader.PropertyReader;
import com.automationexercices.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class GUIDriver {
    private final String browser=  PropertyReader.getProperty("browserType");

    private  ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public GUIDriver(){
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        LogsManager.info("Starting driver for browser: ", browser);
        AbstractDriver abstractDriver=browserType.getDriverFactory();
        WebDriver driver = ThreadGuard.protect(abstractDriver.createDriver());
        driverThreadLocal.set(driver);
    }





  public WebDriver get(String browser){

        return driverThreadLocal.get();

  }

  public  void quitDriver(){
        driverThreadLocal.get().quit();
    }

}
