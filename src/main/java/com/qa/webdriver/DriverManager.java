package com.qa.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverManager {
    WebDriver driver;

    public WebDriver getDriver(Enum browser) {
        if (browser.equals(Browser.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Invalid Browser Name Please provide either chrome or firefox");
        }
        return driver;
    }
}
