package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Rahi on 2017-04-04.
 */
public class AccountPage extends BasePage {

    @FindBy(className = "RTL")
    WebElement welcomeMessage;

    @FindBy(xpath = "//a[@href='http://www.phptravels.net/account/logout/']")
    WebElement logoutDropDownOption;

    @FindBy(xpath = "//b[@class='lightcaret mt-2']")
    WebElement myAccountDropDownOption;

    @FindBy(xpath = "//a[@href='#profile']")
    WebElement myProfileButton;

    public AccountPage() {
        super(true);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public LoginPage logout()
    {
        myAccountDropDownOption.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutDropDownOption));
        logoutDropDownOption.click();
        return new LoginPage();
    }

    public String getWelcomeMessage()
    {
        return welcomeMessage.getText();
    }

    public AccountPage goToMyProfile()
    {
        myProfileButton.click();
        return this;
    }
}
