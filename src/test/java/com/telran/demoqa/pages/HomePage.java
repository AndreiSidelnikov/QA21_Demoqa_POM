package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]")
    WebElement bookStoreApplication;

    public LoginPage clickBookStoreApplication() {
        bookStoreApplication.click();
        return new LoginPage(driver);
    }
}
