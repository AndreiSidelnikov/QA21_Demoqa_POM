package com.telran.demoqa.tests;

import com.telran.demoqa.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{
    @Test
    public void loginPositiveTest () {
        new LoginPage(driver).login("kroozs","Kroz1234@").verifyUserName("kroozs").logout();
    }
}
