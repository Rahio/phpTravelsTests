package com.selenium.test.testng.tests.userModule;

import com.selenium.test.pages.userModule.InvoicePage;
import com.selenium.test.pages.userModule.LandingPage;
import com.selenium.test.pages.userModule.LoginPage;
import com.selenium.test.testng.tests.TestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Rahi on 2017-04-06.
 */
public class ForgottenPasswordTests extends TestTemplate {

    private LandingPage landingPage;
    private LoginPage loginPage;

    private static final String VALID_EMAIL = "testuser@gmail.com";
    private static final String INVALID_EMAIL = "invalidtestuser@gmail.com";
    private static final String RESTORING_FAILED = "Email Not Found";
    private static final String RESTORING_PASSED = "New Password sent to user@phptravels.com, Kindly check email";


    @BeforeClass(alwaysRun = true)
    public void set()
    {
        landingPage = new LandingPage();
        loginPage = new LoginPage();

    }

    @Test(groups = "tldr")
    public void userCanRestorePasswordWithValidMail()
    {
        landingPage
                .goToLoginPage()
                .forgottenPassword()
                .fillEmailAndRestorePassword(VALID_EMAIL);

        Assert.assertEquals(loginPage.getResetResult(), RESTORING_PASSED);


    }

    @Test(groups = "smoke")
    public void userCannotRestorePasswordBecauseOfInvalidMail()
    {
        landingPage
                .goToLoginPage()
                .forgottenPassword()
                .fillEmailAndRestorePassword(INVALID_EMAIL);

        Assert.assertEquals(loginPage.getResetResult(), RESTORING_FAILED);
    }

}
