package com.centurylink.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cennturylink.pageObjects.LoginPage;


public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickSubmitButton();

        String productPageTitle = driver.getTitle();
        Assert.assertEquals(productPageTitle, "Swag Labs");

    }

}
