package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        logoutDropDownOption.click();
        return new LoginPage();
    }

    public String getWelcomeMessage()
    {
        return welcomeMessage.getText();
    }
}
