package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

/**
 * Created by Rahi on 2017-06-20.
 */
public class CarsPage extends BasePhptravelsPage {

    @FindBys(@FindBy(xpath = "//button[contains(.,'Details')]"))
    protected List<WebElement> carDetailsList;

    public CarsPage() {
        super();
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return true;
    }


    public CarsDetailsPage selectCar()
    {
        carDetailsList.get(0).click();
        return new CarsDetailsPage();
    }



}
