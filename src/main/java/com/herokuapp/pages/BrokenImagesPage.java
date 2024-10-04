package com.herokuapp.pages;

import com.herokuapp.base.WebPage;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;
import java.util.List;

public class BrokenImagesPage extends WebPage {
    @FindBy(xpath = "//div/img")
    protected List<WebElement> images;
    protected final int SUCCESS_CODE = 200;

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfBrokenImages() {
        // Initially the number will be zero
        int numberOfBrokenImages = 0;
        try (CloseableHttpClient client = HttpClients.createDefault()){
            HttpGet request;
            CloseableHttpResponse response;
            for (WebElement image: images) {
                String imageSrc = image.getAttribute("src");
                request = new HttpGet(imageSrc);
                try {
                    response = client.execute(request);
                    if (response.getCode() != SUCCESS_CODE) {
                        numberOfBrokenImages++;
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return numberOfBrokenImages;
    }
}
