package com.automationexercices.validations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//Hard Assertion
public class Verification extends BaseAssertion {

    public Verification(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void assertTrue(boolean condition, String msg) {
        Assert.assertTrue(condition, msg);
    }

    @Override
    protected void assertFalse(boolean condition, String msg) {
        Assert.assertFalse(condition, msg);
    }

    @Override
    protected void assertEquals(String actual, String expected, String msg) {
        Assert.assertEquals(actual, expected, msg);
    }
}
