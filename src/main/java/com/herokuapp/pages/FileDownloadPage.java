package com.herokuapp.pages;

import com.herokuapp.base.WebPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends WebPage {
    @FindBy(css = "div.example > a:nth-of-type(1)")
    protected WebElement fileToDownload;
    protected String downloadsDirectory = System.getProperty("user.home") + "/Downloads/";
    protected String fileName = null;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void downloadFile(WebElement file) {
        waitForElementToBeVisible(file);
        fileName = file.getText();
        file.click();
        pauseBrowser(TWO_SECONDS);
    }

    public boolean isFileInDownloads(String fileName) {
        driver.get(downloadsDirectory);
        try {
            if (driver.findElement(By.xpath("//*[contains(@href, '" + fileName + "')]")).isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("File not present");
        }
        return false;
    }

    public WebElement getFileToDownload() {
        return fileToDownload;
    }

    public String getFileName() {
        return fileName;
    }
}
