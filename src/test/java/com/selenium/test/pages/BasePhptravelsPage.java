package com.selenium.test.pages;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.pages.userModule.LandingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Rahi on 2017-04-06.
 */
public class BasePhptravelsPage extends BasePage {

    @FindBy(xpath = "//b[@class='lightcaret mt-2']")
    protected WebElement myAccountDropDown;

    @FindBy(xpath = "//select[@id='currency']")
    protected WebElement currecnyDropDown;

    private Navigate navigate;

    public BasePhptravelsPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(TestsConfig.getBaseURL());
        navigate = new Navigate();
    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public void clickOnMyAccountDropdown() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(myAccountDropDown));
        myAccountDropDown.click();
    }

    public BasePhptravelsPage changeCurrency(String currency)
    {
        new Select(currecnyDropDown).selectByVisibleText(currency);
        return this;
    }

    public Navigate navigate()
    {
        return navigate;
    }

}
