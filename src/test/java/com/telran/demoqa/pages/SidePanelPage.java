package com.telran.demoqa.pages;

import com.telran.demoqa.pages.bookstorePages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase{
    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".show #item-3")
    WebElement profile;

    public ProfilePage selectProfile() {
        clickWithJSExecutor(profile,0,500);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertPage selectAlert() {
    clickWithJSExecutor(alerts,0,300);
        return new AlertPage(driver);
    }


    @FindBy (xpath = "//span[.='Browser Windows']")
    WebElement browserWindow;

    public WindowPage selectBrowserWindows() {
        clickWithJSExecutor(browserWindow,0,300);
        return new WindowPage(driver);
    }

    @FindBy (xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage sesectSelectMenu() {
    clickWithJSExecutor(selectMenu,0,500);
        return new SelectMenuPage(driver);
    }
}