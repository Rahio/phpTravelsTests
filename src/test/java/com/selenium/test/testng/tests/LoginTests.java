package com.selenium.test.testng.tests;

import com.selenium.test.pages.AccountPage;
import com.selenium.test.pages.LandingPage;
import com.selenium.test.pages.LoginPage;
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
public class LoginTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private StringBuffer verificationErrors = new StringBuffer();
    private static final String WELCOME_MESSAGE = "Hi, John Smith";
    private static final String INVALID_CREDENTIALS_MESSAGE = "Invalid Email or Password";
    private static final String LOGIN_PAGE_URL = "http://www.phptravels.net/login";

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        WebDriverFactory.startBrowser(true);
        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(groups = "authentication")
    public void userCanLoginWithValidCredentialsFromUpperDropdown()
    {
        String login = "user@phptravels.com";
        String password = "demouser";

        new LandingPage()
                .goToLoginPage()
                    .fillFieldsAndLogin(login, password);

        Assert.assertEquals(new AccountPage().getWelcomeMessage(), WELCOME_MESSAGE);

    }

    @Test(groups = "authentication", dependsOnMethods = "userCanLoginWithValidCredentialsFromUpperDropdown")
    public void userCanLogoutFromUppperDropdown()
    {
        new AccountPage()
                .logout();

        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
    }

    @Test(groups = "authentication", dependsOnMethods = "userCanLogoutFromUppperDropdown")
    public void userCannotLoginWithInvalidCredentialsFromUpperDropdown()
    {
        String login = "invalidUser@phptravels.com";
        String password = "invalidpassword";

        new LandingPage()
                .goToLoginPage()
                .fillFieldsAndLogin(login, password);

        Assert.assertEquals(new LoginPage().getInvalidCredentialsMessage(), INVALID_CREDENTIALS_MESSAGE);

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
