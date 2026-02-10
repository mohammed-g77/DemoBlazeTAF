package com.automationexercices.utils.action;

import com.automationexercices.utils.WaitManager;
import com.automationexercices.utils.logs.LogsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class ElementActions {
    private final WebDriver driver;
    private final WaitManager waitManager;
    public ElementActions(WebDriver driver) {
        this.driver=driver;
        this.waitManager=new WaitManager(driver);
        

    }
    //click method
    public boolean click(By locator) {
        try {
            return waitManager.fluentWait().until(d -> {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                element.click();
                LogsManager.info("Clicked on element:", locator.toString());
                 return true;
            });
        } catch (Exception e) {
            return false;
        }
    }



   //type method
    public boolean type(By locator, String text) {
        try {
            return waitManager.fluentWait().until(d -> {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                element.clear();
                element.sendKeys(text);
                    LogsManager.info("Typed text: ", text, " into element: ", locator.toString());
                 return true;
            });
        } catch (Exception e) {
            return false;
        }
    }



    //getText method
    public String getText(By locator) {
        try {
            return waitManager.fluentWait().until(d -> {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                String msg = element.getText();
                    LogsManager.info("Got text: ", msg, " from element: ", locator.toString());
                return !msg.isEmpty() ? msg : null;
            });
        } catch (Exception e) {
            return null;
        }
    }


    //upload file method
    public boolean uploadFile(By locator, String filePath) {
        String fileAbsolutePath = System.getProperty("user.dir") + File.separator + filePath;
        try {
            return waitManager.fluentWait().until(d -> {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                element.sendKeys(fileAbsolutePath);
                    LogsManager.info("Uploaded file: ", fileAbsolutePath, " to element: ", locator.toString());
                return true;
            });
        } catch (Exception e) {
            return false;
        }
    }

    //find element method
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    //Scroll to element method using js
    public void scrollToElementJS(By locator) {
        WebElement element = driver.findElement(locator);
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("""
                        arguments[0].scrollIntoView({behaviour:"auto",block:"center",inline:"center"});""", element);

    }



}
