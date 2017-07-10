package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import com.selenium.test.utils.ActionBot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public InvoicePage confirmBookingWithoutChanges()
    {

        new ActionBot(getDriver()).moveToElementAndClickOnIt(confirmThisBookingButton);
        return new InvoicePage();
    }

    public InvoicePage addAdditionalNotes(String notes)
    {
        new ActionBot(getDriver()).type(additionalNotes, notes);
        return new InvoicePage();
    }
}
