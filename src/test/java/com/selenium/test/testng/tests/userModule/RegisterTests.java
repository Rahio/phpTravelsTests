package com.selenium.test.testng.tests.userModule;

import com.selenium.test.pages.userModule.AccountPage;
import com.selenium.test.pages.userModule.LandingPage;
import com.selenium.test.pages.userModule.RegisterPage;
import com.selenium.test.testng.tests.TestTemplate;
import com.selenium.test.to.Credential;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

import static com.selenium.test.webtestsbase.WebDriverFactory.getDriver;

/**
 * Created by Rahi on 2017-04-04.
 */
public class RegisterTests extends TestTemplate {

    private static final String WELCOME_MESSAGE = "Hi, ";
    private static final String EXISTING_EMAIL_MESSAGE = "Email Already Exists.";
    private static final String NOT_MATCHING_PASSWORD_MESSAGE = "Password not matching with confirm password.";
    private static final String REQUIRED_FIELDS_MESSAGE = "The Email field is required.\n" +
                                                            "The Password field is required.\n" +
                                                            "The Password field is required.\n" +
                                                            "The First name field is required.\n" +
                                                            "The Last Name field is required.";
    private static final String EMAIL_VALIDATION_MESSAGE = "The Email field must contain a valid email address.";

    @AfterClass
    public void afterMethod(){
        getDriver().close();
    }

    @DataProvider(name = "ValidRegistrationCredentials")
    public static Object[][] validData(){
        Credential credential = new Credential("John", "Doe", "765434514", "JohnDoe@mail.com", "user12345", "user12345");
        return new Object[][] {
                { credential}
        };
    }

    @Test(groups = "authentication", dataProvider = "ValidRegistrationCredentials")
    public void userCanRegisterFromUpperDropdownUsingValidData(Credential credential)
    {
        new LandingPage()
                .goToRegisterPage()
                    .fillRegistrationForm(credential)
                    .registerAccount()
                    .goToMyProfile();

        Assert.assertEquals(WELCOME_MESSAGE+credential.getFirstname()+" "+credential.getLastname(), new AccountPage().getWelcomeMessage());

        new AccountPage()
                .logout();
    }

    @Test
    public void userCanRegisterWhileBookingUsingValidData()
    {
        //TODO after booking tests
    }

    @DataProvider(name = "CredentialsWithoutRequiredData")
    public static Object[][] withoutRequiredData(){
        return new Object[][]{
                {new Credential("456987023")}
        };
    }
    @Test(groups = "authentication", dataProvider = "CredentialsWithoutRequiredData")
    public void userCannotRegisterWithoutRequiredData(Credential credential)
    {
        new LandingPage()
                .goToRegisterPage()
                .fillRegistrationForm(credential)
                .registerAccount();

        Assert.assertEquals(REQUIRED_FIELDS_MESSAGE, new RegisterPage().getErrorMessage());
    }

    @DataProvider(name = "CredentialsWithNotMatchingPassword")
    public static Object[][] notMatchingConfirmPassword(){
        return new Object[][] {
                { new Credential("John", "Doe", "765434514", "JohnDoe@mail.com", "user12345", "user123456")}
        };
    }
    @Test(groups = "authentication", dataProvider = "CredentialsWithNotMatchingPassword")
    public void userCannotRegisterWithNotMatchingPasswords(Credential credential)
    {
        new LandingPage()
                .goToRegisterPage()
                .fillRegistrationForm(credential)
                .registerAccount();

        Assert.assertEquals(NOT_MATCHING_PASSWORD_MESSAGE, new RegisterPage().getErrorMessage());
    }


    @DataProvider(name = "CredentialsWithInvalidMail")
    public static Object[][] notValidMail(){
        return new Object[][] {
                { new Credential("John", "Doe", "765434514", "JohnDoemail.com", "user12345", "user12345")}
        };
    }
    @Test(groups = "authentication", dataProvider = "CredentialsWithInvalidMail")
    public void userCannotRegisterWithInvalidMail(Credential credential)
    {
        new LandingPage()
                .goToRegisterPage()
                .fillRegistrationForm(credential)
                .registerAccount();

        Assert.assertEquals(EMAIL_VALIDATION_MESSAGE, new RegisterPage().getErrorMessage());
    }

    @DataProvider(name = "AlreadyUsedCredentials")
    public static Object[][] usedCredentials(){
        return new Object[][] {
                { new Credential("John", "Doe", "765434514", "user12345", "user12345")}
        };
    }
    @Test(groups = "authentication", dataProvider = "AlreadyUsedCredentials")
    public void userCannotRegisterWithAlreadyUsedData(Credential credential)
    {
        new LandingPage()
                .goToRegisterPage()
                .fillRegistrationForm(credential)
                .registerAccount();

        Assert.assertEquals(EXISTING_EMAIL_MESSAGE, new RegisterPage().getErrorMessage());
    }


    @DataProvider(name = "InvalidRegistrationCredentials")
    public static Object[][] invalidData(){
        Credential withoutRequiredData = new Credential("534534534");
        Credential notMatchingPassword = new Credential("John", "Doe", "765434514", "JohnDoe@mail.com", "user12345", "user123456");
        Credential alreadyUsedData = new Credential("John", "Doe", "765434514", "user12345", "user12345");
        Credential invalidMail = new Credential("John", "Doe", "765434514", "JohnDoemail.com", "user12345", "user12345");

        return new Object[][] {
                { withoutRequiredData, REQUIRED_FIELDS_MESSAGE },
                { notMatchingPassword, NOT_MATCHING_PASSWORD_MESSAGE },
                { alreadyUsedData, EXISTING_EMAIL_MESSAGE},
                { invalidMail, EMAIL_VALIDATION_MESSAGE}
        };
    }
    @Test(groups = "justthistest", dataProvider = "InvalidRegistrationCredentials")
    public void userCannotRegistedWithInvalidCredentials(Credential credential, String expectedResult)
    {
        new LandingPage()
                .goToRegisterPage()
                .fillRegistrationForm(credential)
                .registerAccount();

        Assert.assertEquals(expectedResult, new RegisterPage().getErrorMessage());
    }


}
