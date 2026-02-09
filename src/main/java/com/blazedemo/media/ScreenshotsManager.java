package com.blazedemo.media;

import com.blazedemo.drivers.GUIDriver;
import com.blazedemo.utils.TimeManager;
import com.blazedemo.utils.logs.LogsManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotsManager {
    private static final String SCREENSHOTS_PATH = "test-output/screenshots/";

    // take full page screenshot
    public static void takeFullPageScreenshot(WebDriver driver, String screenshotName) throws IOException {
        try {
            //Capture screenshot using TakesScreenshot
            File screenshotSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //save screenshot to a file if needed
            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + "-" + TimeManager.getTimeStamp() + ".png");
            FileUtils.copyFile(screenshotSrc, screenshotFile);
            //TODO: Attach the screenshot to Allure if needed

            LogsManager.info("Screenshot Succeeded ");
        } catch (Exception e) {
            LogsManager.error("Failed to take screenshot: ", e.getMessage());
        }

    }
    // take specific element screenshot
      public static void  takeElementScreenshot(WebDriver driver, By elementSelector) throws IOException {
          try {
              String ariaName = driver.findElement(elementSelector).getAccessibleName();
              File screenshotSrc = driver.findElement(elementSelector).getScreenshotAs(OutputType.FILE);

              //save screenshot to a file if needed
              File screenshotFile = new File(SCREENSHOTS_PATH + ariaName + "-" + TimeManager.getTimeStamp() + ".png");
              FileUtils.copyFile(screenshotSrc, screenshotFile);
              //TODO: Attach the screenshot to Allure if needed

              LogsManager.info("Screenshot Succeeded ");
          } catch (Exception e) {
              LogsManager.error("Failed to take element screenshot: ", e.getMessage());
          }


      }


}
