package com.herokuapp.pages;

import com.herokuapp.base.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CheckboxPage extends WebPage {
    @FindBy(css = "input[type='checkbox']")
    List<WebElement> checkBoxes;

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isChecked(int index) {
        return checkBoxes.get(index).isSelected();
    }

    public void selectCheckbox(int index) {
        if (!isChecked(index)) {
            checkBoxes.get(index).click();
        }
    }

    public void unselectCheckbox(int index) {
        if (isChecked(index)) {
            checkBoxes.get(index).click();
        }
    }

    public List<WebElement> getCheckBoxes() {
        return checkBoxes;
    }
}
