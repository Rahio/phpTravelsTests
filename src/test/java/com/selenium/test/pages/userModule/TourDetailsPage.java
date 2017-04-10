package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rahi on 2017-04-11.
 */
public class TourDetailsPage extends BasePhptravelsPage {

    @FindBy(xpath = "//button[contains(.,'Book Now')]")
    WebElement bookNowButton;

    public TourDetailsPage() {
        super();
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public TourBookingCheckout bookThisTour()
    {
        bookNowButton.click();
        return new TourBookingCheckout();
    }
}
