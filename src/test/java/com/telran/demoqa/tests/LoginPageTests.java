package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).clickBookStoreApplication().clickToLogin();

    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver).closeBanner();
        new LoginPage(driver).login("kroozs", "Kroz1234@").verifyUserName("kroozs").logout();
    }
}
