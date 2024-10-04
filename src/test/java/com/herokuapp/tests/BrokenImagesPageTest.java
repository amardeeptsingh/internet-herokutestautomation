package com.herokuapp.tests;

import com.herokuapp.base.BaseTest;
import com.herokuapp.pages.BrokenImagesPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenImagesPageTest extends BaseTest {
    protected BrokenImagesPage brokenImagesPage;
    //By default, the page has 2 broken images
    protected int NUMBER_OF_EXPECTED_BROKEN_IMAGES = 2;

    @BeforeClass
    public void initPage() {
        landingPage.navigateTo("broken_images");
        brokenImagesPage = PageFactory.initElements(driver, BrokenImagesPage.class);
    }

    @Test
    public void brokenImagesTest() {
        int numberOfBrokenImagesFound = brokenImagesPage.getNumberOfBrokenImages();
        Assert.assertEquals(numberOfBrokenImagesFound, NUMBER_OF_EXPECTED_BROKEN_IMAGES);
    }
}

