package com.herokuapp.tests;

import com.herokuapp.base.BaseTest;
import com.herokuapp.pages.DragAndDropPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropPageTest extends BaseTest {
    protected DragAndDropPage dragAndDropPage;

    @BeforeClass
    public void initPage() {
        landingPage.navigateTo("drag_and_drop");
        dragAndDropPage = PageFactory.initElements(driver, DragAndDropPage.class);
    }

    @Test
    public void dragAndDropTest() {
        String firstElementHeader = dragAndDropPage.getFirstElement().getText();
        dragAndDropPage.dragAndDrop(dragAndDropPage.getFirstElement(),
                dragAndDropPage.getSecondElement());
        String secondElementHeader = dragAndDropPage.getSecondElement().getText();
        Assert.assertEquals(firstElementHeader, secondElementHeader);
    }
}
