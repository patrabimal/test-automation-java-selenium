package com.qa.functionaltests;

import com.qa.config.EnvironmentConfig;
import com.qa.webdriver.Browser;
import com.qa.webdriver.DriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public String baseURL = EnvironmentConfig.getBaseURL();
    public String username = EnvironmentConfig.getUserName();
    public String password = EnvironmentConfig.getPassword();
    public WebDriver driver;
    DriverManager driverManager;

    @BeforeClass
    public void setup() {
        driverManager = new DriverManager();
        driver = driverManager.getDriver(Browser.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
