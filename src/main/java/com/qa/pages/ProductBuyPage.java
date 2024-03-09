package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductBuyPage {
    WebDriver localDriver;

    public ProductBuyPage(WebDriver driver) {
        localDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "add-to-cart-sauce-labs-backpack")
    WebElement clickAddToCart;
    @FindBy(className = "shopping_cart_link")
    WebElement clickCartIcon;
    @FindBy(name = "checkout")
    WebElement clickCheckout;
    @FindBy(name = "firstName")
    WebElement enterFirstName;
    @FindBy(name = "lastName")
    WebElement enterLastName;
    @FindBy(name = "postalCode")
    WebElement enterPostalCode;
    @FindBy(name = "continue")
    WebElement clickContinue;
    @FindBy(name = "finish")
    WebElement clickFinish;

    public void clickAddtoCart(){clickAddToCart.click();}

    public void clickAddtoCartIcon(){clickCartIcon.click();}

    public void clickCheckOut(){clickCheckout.click();}
    public void setFirstName(){enterFirstName.sendKeys("Bimal");}
    public void setLastName(){enterLastName.sendKeys("Patra");}
    public void setPostalCode(){enterPostalCode.sendKeys("560037");}

    public void clickContinue(){clickContinue.click();}
    public void clickFinish(){clickFinish.click();}


}
