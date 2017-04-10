package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePage;
import com.selenium.test.pages.BasePhptravelsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    private void typePassword(String password)
    {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public String getInvalidCredentialsMessage(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(invalidCredentialsMessage));
        return invalidCredentialsMessage.getText();
    }
}
