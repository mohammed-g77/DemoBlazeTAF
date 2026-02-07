package com.blazedemo.utils.action;

import com.blazedemo.utils.WaitManager;
import com.blazedemo.utils.logs.LogsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameActions {
    private final WaitManager waitManager;
    private final WebDriver driver;
    public FrameActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }

    //switch to frame by index
    public void switchToFrameByIndex(int index) {
          waitManager.fluentWait().until(d -> {

            try {
                d.switchTo().frame(index);
                 return true;

        } catch (Exception e) {
            return false;
        }

        });
    }

    //switch to frame by name or ID
    public void switchToFrameByNameOrId(String nameOrId) {
        waitManager.fluentWait().until(d -> {
            try {
                d.switchTo().frame(nameOrId);
                LogsManager.info("Switched to frame with name or ID: ", nameOrId);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    //switch to frame by WebElement
    public void switchToFrameByWebElement(By frameElement) {
        waitManager.fluentWait().until(d -> {
            try {
                d.switchTo().frame(d.findElement(frameElement));
                LogsManager.info("Switched to frame with WebElement: ", frameElement.toString());
                return true;
            } catch (Exception e) {
                return false;
            }
        });

    }

    //switch back to default content
    public void switchToDefaultContent() {
        waitManager.fluentWait().until(d -> {
            try {
                d.switchTo().defaultContent();
                LogsManager.info("Switched back to default content");
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }


}
