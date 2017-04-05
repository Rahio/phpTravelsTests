package com.selenium.test.pages;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rahi on 2017-04-04.
 */
public class LandingPage extends BasePage {

    @FindBy(xpath = "//b[@class='lightcaret mt-2']")
    WebElement myAccountDropDownOption;

    @FindBy(xpath = "//a[@href='http://www.phptravels.net/login']")
    WebElement loginDropDownOption;


    public LandingPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(TestsConfig.getBaseURL());
    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public LoginPage goToLoginPage()
    {
        myAccountDropDownOption.click();
        loginDropDownOption.click();
        return new LoginPage();
    }
}
