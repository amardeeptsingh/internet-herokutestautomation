package com.herokuapp.tests;

import com.herokuapp.base.BaseTest;
import com.herokuapp.pages.FileDownloadPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FileDownloadPageTest extends BaseTest {
    protected FileDownloadPage fileDownloadPage;

    @BeforeClass
    public void initPage() {
        fileDownloadPage = PageFactory.initElements(driver, FileDownloadPage.class);
    }

    @Test
    public void fileDownloadTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(fileDownloadPage.isFileInDownloads(fileDownloadPage.getFileName()), false);

        landingPage.navigateTo("download");
        fileDownloadPage.downloadFile(fileDownloadPage.getFileToDownload());
        softAssert.assertEquals(fileDownloadPage.isFileInDownloads(fileDownloadPage.getFileName()), true);

        softAssert.assertAll();
    }

}
