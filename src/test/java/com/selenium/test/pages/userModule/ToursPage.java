package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import com.selenium.test.pages.Navigate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Rahi on 2017-04-07.
 */
public class ToursPage extends BasePhptravelsPage {

    @FindBy(xpath = "//small[contains(.,'GBP')]")
    protected WebElement currencyText;

    @FindBys(@FindBy(xpath = "//button[contains(.,'Details')]"))
    protected List<WebElement> tourDetailsList;

    public ToursPage() {
        super();
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return true;
    }


    public String getExpectedCurrency()
    {
        return currencyText.getText();
    }

    public Navigate navigate()
    {
        return new Navigate();
    }

    public TourDetailsPage openFirstTourPage()
    {
        System.out.println(tourDetailsList.size());
        tourDetailsList.get(0).click();
        return new TourDetailsPage();
    }
}
