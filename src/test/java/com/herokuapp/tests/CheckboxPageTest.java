package com.herokuapp.tests;

import com.herokuapp.base.BaseTest;
import com.herokuapp.pages.CheckboxPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckboxPageTest extends BaseTest {
    protected CheckboxPage checkboxPage;

    @BeforeClass
    public void initCheckboxPage() {
        landingPage.navigateTo("checkboxes");
        checkboxPage = PageFactory.initElements(driver, CheckboxPage.class);
    }

    @Test
    public void checkboxTests() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < checkboxPage.getCheckBoxes().size(); i++) {
            boolean isSelected = checkboxPage.isChecked(i);
            if (isSelected) {
                checkboxPage.unselectCheckbox(i);
                isSelected = checkboxPage.isChecked(i);
                softAssert.assertTrue(!isSelected);
            } else {
                checkboxPage.selectCheckbox(i);
                isSelected = checkboxPage.isChecked(i);
                softAssert.assertTrue(isSelected);
            }
        }
        softAssert.assertAll();
    }

}
