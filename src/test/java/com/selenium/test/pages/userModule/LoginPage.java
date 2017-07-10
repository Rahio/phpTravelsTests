package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePage;
import com.selenium.test.pages.BasePhptravelsPage;
import com.selenium.test.utils.ActionBot;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rahi on 2017-04-04.
 */
public class LoginPage extends BasePhptravelsPage {

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(.,'Login')]")
    WebElement loginButton;

    @FindBy (xpath = "//div[@class='alert alert-danger']")
    WebElement invalidCredentialsMessage;

    @FindBy (xpath = "//a[@href='#ForgetPassword']")
    WebElement forgetPasswordButton;

    @FindBy (xpath = "//input[@id='resetemail']")
    WebElement resetEmail;

    @FindBy (xpath = "//div[@class='resultreset']")
    WebElement resetResult;

    @FindBy (xpath = "//button[contains(.,'Reset')]")
    WebElement resetButton;

    public LoginPage() {
        super();
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public AccountPage fillCredentialsAndLogin(String username, String password){
        typeUsername(username);
        typePassword(password);
        loginButton.click();
        return new AccountPage();
    }

    private void typeUsername(String username)
    {
        ActionBot bot = new ActionBot(getDriver());
        bot.waitUntilElementIsClickable(usernameField, 2);
        bot.type(usernameField, username);
    }

    private void typePassword(String password)
    {
        new ActionBot(getDriver()).type(passwordField, password);
    }

    public String getInvalidCredentialsMessage(){
        new ActionBot(getDriver()).waitUntilElementIsVisibleAndCllickIt(invalidCredentialsMessage, 5);
        return invalidCredentialsMessage.getText();
    }

    public LoginPage forgottenPassword()
    {
        ActionBot bot = new ActionBot(getDriver());
        bot.waitUntilElementIsVisibleAndCllickIt(loginButton,5 );
        bot.waitUntilElementIsVisibleAndCllickIt(forgetPasswordButton, 5);
        return this;
    }

    public LoginPage fillEmailAndRestorePassword(String email)
    {
        ActionBot bot = new ActionBot(getDriver());
        bot.type(resetEmail, email);
        bot.waitUntilElementIsClickableAndClickOnIt(resetButton,5 );
        return this;
    }

    public String getResetResult()
    {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ActionBot(getDriver()).waitUntilElementIsVisibleAndGetText(resetResult, 5);

    }

}
