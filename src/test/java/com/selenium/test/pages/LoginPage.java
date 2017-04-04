package com.selenium.test.pages;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.webtestsbase.BasePage;
import junit.extensions.TestSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rahi on 2017-04-04.
 */
public class LoginPage extends BasePage {

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(.,'Login')]")
    WebElement loginButton;

    public LoginPage() {
        super(true);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public void fillFieldsAndLogin()
    {
        usernameField.sendKeys("user@phptravels.com");
        passwordField.sendKeys("demouser");
        loginButton.click();
    }
}
