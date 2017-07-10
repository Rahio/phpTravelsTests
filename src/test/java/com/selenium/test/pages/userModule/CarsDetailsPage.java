package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import com.selenium.test.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Rahi on 2017-06-20.
 */
public class CarsDetailsPage extends BasePhptravelsPage {

    @FindBy(xpath = "//button[contains(@type,'submit')]")
    WebElement bookNowButton;

    @FindBy(xpath = "//h4[@class='totalCost strong']")
    WebElement totalCost;

    private BookingOptionsPage bookingOptionsPage;

    public BookingOptionsPage getBookingOptionsPage()
    {
        return bookingOptionsPage;
    }

    public CarsDetailsPage() {
        super();
        bookingOptionsPage = new BookingOptionsPage();
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public TourBookingCheckout bookCar()
    {
        new ActionBot(getDriver()).moveToElementAndClickOnIt(bookNowButton);
        return new TourBookingCheckout();
    }

    public CarsDetailsPage setDestination()
    {
        bookingOptionsPage.setPickUpLocation();
        new ActionBot(getDriver()).waitUntilElementIsVisibleAndCllickIt(totalCost, 2);
        return this;
    }

}
