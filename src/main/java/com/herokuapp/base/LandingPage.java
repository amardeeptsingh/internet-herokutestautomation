package com.herokuapp.base;

import org.openqa.selenium.WebDriver;

public class LandingPage extends WebPage {
    protected final String BASE_URL = "https://the-internet.herokuapp.com/";

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(String pageName) {
        driver.get(BASE_URL + pageName);
    }
}
