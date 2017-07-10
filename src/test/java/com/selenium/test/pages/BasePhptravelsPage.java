package com.selenium.test.pages;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.pages.userModule.CarsDetailsPage;
import com.selenium.test.pages.userModule.CarsPage;
import com.selenium.test.pages.userModule.LandingPage;
import com.selenium.test.pages.userModule.ToursPage;
import com.selenium.test.utils.ActionBot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.ws.WebEndpoint;

/**
 * Created by Rahi on 2017-04-06.
 */
public class BasePhptravelsPage extends BasePage {

    @FindBy(xpath = "//b[@class='lightcaret mt-2']")
    protected WebElement myAccountDropDown;

    @FindBy(xpath = "//select[@id='currency']")
    protected WebElement currecnyDropDown;

    @FindBy(xpath = "//a[@href='http://www.phptravels.net/tours']")
    protected WebElement tours;

    @FindBy(xpath = "//a[@href='http://www.phptravels.net/cars']")
    protected WebElement cars;

    public BasePhptravelsPage() {
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

    public void clickOnMyAccountDropdown() {
       new ActionBot(getDriver()).waitUntilElementIsClickableAndClickOnIt(myAccountDropDown, 2);
    }

    public BasePhptravelsPage changeCurrency(String currency)
    {
        new ActionBot(getDriver()).selectFromDropdownByVisibleText(currecnyDropDown, currency);
        return this;
    }

    public ToursPage goToToursPage()
    {
        new ActionBot(getDriver()).waitUntilElementIsClickableAndClickOnIt(tours, 2);
        return new ToursPage();
    }

    public CarsPage goToCarsPage()
    {
        cars.click();
        return new CarsPage();
    }



}
