package com.automationexercices.validations;

import com.automationexercices.utils.WaitManager;
import com.automationexercices.utils.action.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseAssertion {
protected final WebDriver driver;
protected final WaitManager waitManager;
protected final ElementActions elementActions;


    public BaseAssertion(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
        this.elementActions = new ElementActions(driver);
     }

     protected abstract void  assertTrue(boolean condition, String msg);
     protected abstract void assertFalse(boolean condition, String msg);
     protected abstract void assertEquals(String actual, String expected, String msg);

     protected void Equals(String actual, String expected, String msg) {
         assertEquals(actual, expected, msg);
     }
     protected void isElementVisible(By locator){
         boolean flag= waitManager.fluentWait().until(driver1->
                 {
                   try {
                        driver1.findElement(locator).isDisplayed();
                       return true;
                   }catch (Exception e){
                       return false;
                   }

                 });
         assertTrue(flag, "Element is not visible: " + locator);

     }

     //verify page url
        protected void assertPageUrl(String expectedUrl, String msg) {
            String actualUrl = driver.getCurrentUrl();
            assertEquals(actualUrl, expectedUrl, msg);
        }
        //verify page title
        protected void assertPageTitle(String expectedTitle, String msg) {
            String actualTitle = driver.getTitle();
            assertEquals(actualTitle, expectedTitle, msg);
        }



}
