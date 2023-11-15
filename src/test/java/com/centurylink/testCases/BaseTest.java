package com.centurylink.testCases;

import com.centurylink.utilities.ReadConfig;
import com.centurylink.webdriver.Browser;
import com.centurylink.webdriver.DriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    ReadConfig readonfig = new ReadConfig();

    public String baseURL = readonfig.getApplicationURL();
    public String username = readonfig.getUsername();
    public String password = readonfig.getpassword();
    public WebDriver driver;
    DriverManager driverManager;

    @BeforeClass
    public void setup() {
        driverManager = new DriverManager();
        driver = driverManager.getDriver(Browser.CHROME);
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
