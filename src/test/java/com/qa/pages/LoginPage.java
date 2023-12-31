package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver localDriver;
	
	public LoginPage(WebDriver driver)
	{
		localDriver =driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name="user-name")
	WebElement usernameText;
	
	@FindBy(name="password")
	WebElement passwordText;
	
	@FindBy(name="login-button")
	WebElement loginButton;

	@FindBy(className = "bm-item menu-item")
	WebElement logoutButton;
	
	public void setUserName(String uname)
	{
		usernameText.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		passwordText.sendKeys(pwd);
	}
	
	public void clickSubmitButton()
	{
		loginButton.click();
	}

	public void clickLogoutButton(){logoutButton.click();}

}
