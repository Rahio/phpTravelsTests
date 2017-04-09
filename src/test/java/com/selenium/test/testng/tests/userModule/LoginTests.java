package com.selenium.test.testng.tests.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import com.selenium.test.pages.userModule.AccountPage;
import com.selenium.test.pages.userModule.LandingPage;
import com.selenium.test.pages.userModule.LoginPage;
import com.selenium.test.testng.tests.TestTemplate;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Rahi on 2017-04-04.
 */
public class LoginTests extends TestTemplate {

    private static final String WELCOME_MESSAGE = "Hi, John Smith";
    private static final String INVALID_CREDENTIALS_MESSAGE = "Invalid Email or Password";
    private static final String LOGIN_PAGE_URL = "http://www.phptravels.net/login";

    @Test(groups = "authentication")
    public void userCanLoginWithValidCredentialsFromUpperDropdown()
    {
        String login = "user@phptravels.com";
        String password = "demouser";

        new LandingPage()
                .goToLoginPage()
                    .fillCredentialsAndLogin(login, password);

        Assert.assertEquals(new AccountPage().getWelcomeMessage(), WELCOME_MESSAGE);

    }

    @Test(groups = "authentication", dependsOnMethods = "userCanLoginWithValidCredentialsFromUpperDropdown")
    public void userCanLogoutFromUppperDropdown()
    {
        new AccountPage()
                .logout();

        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
    }

    @DataProvider(name = "InvalidUserOrUnvalidMail")
    public static Object[][] notValidMail(){
        return new Object[][]{{"user@phptravels.com", "invalidpassword"}, {"invaliduser@phptravels.com", "demouser"} };
    }

    @Test(dataProvider = "InvalidUserOrUnvalidMail", groups = "authentication", dependsOnMethods = "userCanLogoutFromUppperDropdown")
    public void userCannotLoginWithInvalidCredentialsFromUpperDropdown(String login, String password)
    {
        new LandingPage()
                .goToLoginPage()
                .fillCredentialsAndLogin(login, password);

        Assert.assertEquals(new LoginPage().getInvalidCredentialsMessage(), INVALID_CREDENTIALS_MESSAGE);

    }

}
