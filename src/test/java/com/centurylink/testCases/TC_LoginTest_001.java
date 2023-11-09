package com.centurylink.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cennturylink.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass 
{
	@Test
	public void loginTest()
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter UserName");
		
		lp.setPassword(password);
		logger.info("Enter Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test pass");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}

}
