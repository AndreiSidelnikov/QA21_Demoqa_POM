package com.telran.demoqa.tests;

import com.telran.demoqa.helpers.MyListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    //    public WebDriver driver;

    public static EventFiringWebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();


        driver.get("https://demoqa.com");
        //     driver.get("https://demoqa.com/login");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.register(new MyListener());
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        driver.quit();
    }


    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + "with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: test method " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: test method " + result.getMethod().getMethodName());
        }
        logger.info("========================================================");
    }
}
