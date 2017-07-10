package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Rahi on 2017-06-22.
 */
public class BookingOptionsPage extends BasePhptravelsPage{

    @FindBys(@FindBy(id = "pickuplocation"))
    protected WebElement pickUpLocation;

    @FindBys(@FindBy(xpath = "//span[@class='select2-result-label']"))
    protected List<WebElement> cityList;

    public BookingOptionsPage() {
        super();
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public void setPickUpLocation()
    {
        Select select = new Select(pickUpLocation);
        select.getOptions().get(1).click();
    }



}
