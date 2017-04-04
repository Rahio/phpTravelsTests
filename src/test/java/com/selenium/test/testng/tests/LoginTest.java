package com.selenium.test.testng.tests;

import com.selenium.test.pages.AccountPage;
import com.selenium.test.pages.LandingPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Rahi on 2017-04-04.
 */
public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private StringBuffer verificationErrors = new StringBuffer();
    private static final String WELCOME_MESSAGE = "Hi, John Smith";

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        WebDriverFactory.startBrowser(true);
        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void shouldLogInToPageAsCustomer()
    {
        String login = "user@phptravels.com";
        String passowrd = "demouser";

        new LandingPage()
                .goToLoginPage()
                    .fillFieldsAndLogin();

        Assert.assertEquals(WELCOME_MESSAGE, new AccountPage().getWelcomeMessage());

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
        }
    }
}
