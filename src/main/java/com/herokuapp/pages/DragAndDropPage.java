package com.herokuapp.pages;

import com.herokuapp.base.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends WebPage {
    @FindBy(css = "#column-a")
    protected WebElement elementA;
    @FindBy(css = "#column-b")
    protected WebElement elementB;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void dragAndDrop(WebElement elementA, WebElement elementB) {
        actions.dragAndDrop(elementA, elementB).perform();
    }

    public WebElement getFirstElement() {
        return elementA;
    }

    public WebElement getSecondElement() {
        return elementB;
    }
}
