package com.herokuapp.tests;

import com.herokuapp.base.BaseTest;
import com.herokuapp.pages.DropdownPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DropdownPageTest extends BaseTest {
    protected  DropdownPage dropdownPage;
    protected final int OPTION_ONE_INDEX = 1;
    protected final String OPTION_ONE_TEXT = "Option 1";
    protected final int OPTION_TWO_INDEX = 2;
    protected final String OPTION_TWO_TEXT = "Option 2";

    @BeforeClass
    public void initPage() {
        landingPage.navigateTo("dropdown");
        dropdownPage = PageFactory.initElements(driver, DropdownPage.class);
    }

    @Test
    public void dropdownTest(){
        SoftAssert softAssert = new SoftAssert();

        dropdownPage.selectDropdownOption(OPTION_ONE_INDEX);
        softAssert.assertEquals(dropdownPage.getSelectedOption(), OPTION_ONE_TEXT);

        dropdownPage.selectDropdownOption(OPTION_TWO_INDEX);
        softAssert.assertEquals(dropdownPage.getSelectedOption(), OPTION_TWO_TEXT);

        softAssert.assertAll();
    }
}
