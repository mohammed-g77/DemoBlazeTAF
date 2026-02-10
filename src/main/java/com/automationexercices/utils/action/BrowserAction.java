package com.automationexercices.utils.action;

import com.automationexercices.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;

public class BrowserAction {
    private final WebDriver driver;

    public BrowserAction(WebDriver driver) {
        this.driver = driver;
    }

    //Maximize browser window
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    //get current URL
    public String getCurrentUrl() {
        LogsManager.info("Current URL: ", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //navigate to a URL
    public void navigateTo(String url) {
        driver.navigate().to(url);
        LogsManager.info("Navigated to URL: ", url);
    }

    //refresh the page
    public void refreshPage() {
        driver.navigate().refresh();
    }

    //close the current window
    public void closeWindow() {
        driver.close();
    }

    //open a new window
    public void openNewWindow() {
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.WINDOW);
    }

}
