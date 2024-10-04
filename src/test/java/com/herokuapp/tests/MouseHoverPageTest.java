package com.herokuapp.tests;

import com.herokuapp.base.BaseTest;
import com.herokuapp.pages.MouseHoverPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MouseHoverPageTest extends BaseTest {
    protected MouseHoverPage mouseHoverPage;
    protected final int USER1_INDEX = 0;
    protected final int USER2_INDEX = 1;
    protected final int USER3_INDEX = 2;

    @BeforeClass
    public void initPage() {
        landingPage.navigateTo("hovers");
        mouseHoverPage = PageFactory.initElements(driver,  MouseHoverPage.class);
    }

    @Test
    public void mouseHoverTest() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(USER1_INDEX), false);
        mouseHoverPage.mouseHoverToProfile(USER1_INDEX);
        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(USER1_INDEX), true);

        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(USER2_INDEX), false);
        mouseHoverPage.mouseHoverToProfile(USER2_INDEX);
        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(USER2_INDEX), true);

        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(USER3_INDEX), false);
        mouseHoverPage.mouseHoverToProfile(USER3_INDEX);
        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(USER3_INDEX), true);

        softAssert.assertAll();
    }
}
