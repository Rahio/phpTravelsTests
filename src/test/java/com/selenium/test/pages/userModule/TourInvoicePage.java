package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rahi on 2017-04-11.
 */
public class TourInvoicePage extends BasePhptravelsPage {

    @FindBy(xpath = "//button[@data-module='tours']")
    private WebElement payOnArrivalButton;

    public TourInvoicePage() {
        super();
    }

    @Override
    protected void openPage() {

    }


    public void payOnArrival()
    {
        payOnArrivalButton.click();
    }
}
