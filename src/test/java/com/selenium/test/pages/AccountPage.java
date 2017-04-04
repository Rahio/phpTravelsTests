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

    public String getWelcomeMessage()
    {
        return welcomeMessage.getText();
    }
}
