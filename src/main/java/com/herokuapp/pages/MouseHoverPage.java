package com.herokuapp.pages;

import com.herokuapp.base.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MouseHoverPage extends WebPage {
    @FindBy(css = "div.example > div > img")
    protected List<WebElement> imageElements;

    @FindBy(css = "div.figcaption > a")
    protected List<WebElement> viewProfileLinkElements;

    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }

    public void mouseHoverToProfile(int index) {
        actions.moveToElement(imageElements.get(index)).build().perform();
        pauseBrowser(TWO_SECONDS);
    }

    public boolean isUserNameVisible(int index) {
        return viewProfileLinkElements.get(index).isDisplayed();
    }
}
