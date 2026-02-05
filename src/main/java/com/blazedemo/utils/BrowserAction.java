package com.blazedemo.utils;

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
        return driver.getCurrentUrl();
    }

    //navigate to a URL
    public void navigateTo(String url) {
        driver.navigate().to(url);
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
