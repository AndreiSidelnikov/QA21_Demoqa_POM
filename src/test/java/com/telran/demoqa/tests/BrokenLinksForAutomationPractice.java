package com.telran.demoqa.tests;

import com.telran.demoqa.helpers.MyListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinksForAutomationPractice {

    public EventFiringWebDriver driver;

    @BeforeMethod
    public void intro() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.register(new MyListener());
    }

    @Test
    public void addBrokenLinksForForAutomationPractice() {
        getBrokenLinksForAutomationPractice();
    }

    public void getBrokenLinksForAutomationPractice() {

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        String urlItem = "";
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            urlItem = iterator.next().getText();
            System.out.println(urlItem);
        }

        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");
            verifyLinksForAutomationPractice(url);
        }
    }

    private void verifyLinksForAutomationPractice(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
            httpURL.setConnectTimeout(5000);
            httpURL.connect();
            if (httpURL.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURL.getResponseMessage() + "is a broken link");
            } else {
                System.out.println(linkUrl + " - " + httpURL.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + "broken link");
        }
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
