package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import com.selenium.test.utils.ActionBot;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rahi on 2017-04-11.
 */
public class InvoicePage extends BasePhptravelsPage {

    @FindBy(xpath = "//button[contains(.,'Pay on Arrival')]")
    private WebElement payOnArrivalButton;

    @FindBy(xpath = "//b[contains(.,'Reserved')]")
    private WebElement orderStatus;

    @FindBy(xpath = "//p[contains(.,'PHPTRAVELS')]")
    private WebElement contactInfo;

    @FindBy(xpath = "//strong[contains(.,'Customer Details')]")
    private WebElement customerDetails;

    @FindBy(xpath = "//td/strong")
    private WebElement carDescription;

    public InvoicePage() {
        super();
    }

    @Override
    protected void openPage() {

    }


    public void payOnArrival()
    {
        payOnArrivalButton.click();
        new ActionBot(getDriver()).acceptSimpleAlert();

    }


    public String getOrderStatus()
    {
        return orderStatus.getText();
    }

    public String getContactInfo()
    {
        return contactInfo.getText();
    }

    public String getCustomerDetails(String customer)
    {
        return getDriver().findElement(By.xpath("//p[contains(.,'" + customer + "')]")).getText();
    }

    public String getCarDescription()
    {
        return carDescription.getText();
    }


}
