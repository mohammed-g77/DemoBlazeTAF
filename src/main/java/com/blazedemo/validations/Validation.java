package com.blazedemo.validations;

import com.blazedemo.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

//Soft Assertion
public class Validation extends BaseAssertion {
    private static  SoftAssert softAssert = new SoftAssert();
    private static boolean used = false;//flag to track if softAssert was used in the test
    public Validation(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void assertTrue(boolean condition, String msg) {
       used=true;
        softAssert.assertTrue(condition, msg);
    }

    @Override
    protected void assertFalse(boolean condition, String msg) {
        used=true;
        softAssert.assertFalse(condition, msg);
    }

    @Override
    protected void assertEquals(String actual, String expected, String msg) {
        used=true;
        softAssert.assertEquals(actual, expected, msg);
    }

    public static void assertAll() {
         if (!used) return;//

        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            LogsManager.error("Soft assertion failed: ", e.getMessage());
            throw e;
        } finally {
                softAssert=new SoftAssert();//reset softAssert for next test
               }
    }
}
