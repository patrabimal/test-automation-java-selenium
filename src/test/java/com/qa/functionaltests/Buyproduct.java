package com.qa.functionaltests;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductBuyPage;
import org.testng.annotations.Test;

public class Buyproduct extends BaseTest{

    @Test
    public void buyProduct() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickSubmitButton();

        Thread.sleep(3000);

        ProductBuyPage productBuyPage=new ProductBuyPage(driver);
        productBuyPage.clickAddtoCart();
        productBuyPage.clickAddtoCartIcon();
        productBuyPage.clickCheckOut();
        productBuyPage.setFirstName();
        productBuyPage.setLastName();
        productBuyPage.setPostalCode();
        productBuyPage.clickContinue();
        productBuyPage.clickFinish();

    }
}
