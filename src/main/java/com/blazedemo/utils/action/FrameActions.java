package com.blazedemo.utils.action;

import com.blazedemo.utils.WaitManager;
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
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }


}
