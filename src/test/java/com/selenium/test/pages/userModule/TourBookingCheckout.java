package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Rahi on 2017-04-11.
 */
public class TourBookingCheckout extends BasePhptravelsPage {

    @FindBy(xpath = "//a[@id='signintab']")
    private WebElement singInButton;

    @FindBy(xpath = "//button[contains(.,'CONFIRM THIS BOOKING')]")
    private WebElement confirmThisBookingButton;

    @FindBy(xpath = "//textarea[@name='additionalnotes']")
    private WebElement additionalNotes;

    public TourBookingCheckout() {
        super();
    }

    @Override
    protected void openPage() {

    }

    public TourInvoicePage confirmBookingWithoutChanges()
    {
        confirmThisBookingButton.click();
        return new TourInvoicePage();
    }

    public TourInvoicePage addAdditionalNotes()
    {
        additionalNotes.sendKeys("additional notes");
        return new TourInvoicePage();
    }
}
