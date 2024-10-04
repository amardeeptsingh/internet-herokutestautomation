package com.herokuapp.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected LandingPage landingPage;
    protected String LANDING_PAGE_URL = "http://the-internet.herokuapp.com/";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LANDING_PAGE_URL);
        landingPage = PageFactory.initElements(driver, LandingPage.class);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
