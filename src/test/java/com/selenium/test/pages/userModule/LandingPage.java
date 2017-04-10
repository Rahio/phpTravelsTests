package com.selenium.test.pages.userModule;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.pages.BasePage;
import com.selenium.test.pages.BasePhptravelsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rahi on 2017-04-04.
 */
public class LandingPage extends BasePhptravelsPage {

    @FindBy(xpath = "//a[@href='http://www.phptravels.net/login']")
    WebElement loginDropDownOption;

    @FindBy(xpath = "//a[@href='http://www.phptravels.net/register']")
    WebElement registerDropDownOption;

    public LandingPage() {
        super();
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
        clickOnMyAccountDropdown();
        loginDropDownOption.click();
        return new LoginPage();
    }

    public RegisterPage goToRegisterPage()
    {
        clickOnMyAccountDropdown();
        registerDropDownOption.click();
        return new RegisterPage();
    }
}
