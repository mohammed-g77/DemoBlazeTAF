package com.blazedemo.utils.action;

import com.blazedemo.utils.WaitManager;
import org.openqa.selenium.WebDriver;

public class AlertActions {
    private final WebDriver driver;
    private final WaitManager waitManager;
    public AlertActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }


    //accept alert
    public void acceptAlert() {
         waitManager.fluentWait().until(d -> {
            try {
                d.switchTo().alert().accept();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    //dismiss alert
    public void dismissAlert() {
        waitManager.fluentWait().until(d -> {
            try {
                d.switchTo().alert().dismiss();
                return true;
            } catch (Exception e) {
                return false;

            }
        });

    }

    //get alert text
    public String getAlertText() {
        return waitManager.fluentWait().until(d -> {
            try {
                String text= d.switchTo().alert().getText();
                return !text.isEmpty() ? text : null;
            } catch (Exception e) {
                return null;
            }
        });
    }

    //set text to alert
    public void setAlertText(String text) {
        waitManager.fluentWait().until(d -> {
            try {
                d.switchTo().alert().sendKeys(text);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

}


