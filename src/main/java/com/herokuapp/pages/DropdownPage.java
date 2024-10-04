package com.herokuapp.pages;

import com.herokuapp.base.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends WebPage {
    protected WebElement dropdownElement;
    protected Select dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver);
        dropdownElement = driver.findElement(By.id("dropdown"));
        dropdown = new Select(dropdownElement);
    }

    public void selectDropdownOption(int index) {
        dropdown.selectByIndex(index);
    }

    public String getSelectedOption() {
        return dropdown.getAllSelectedOptions().get(0).getText();
    }
}
