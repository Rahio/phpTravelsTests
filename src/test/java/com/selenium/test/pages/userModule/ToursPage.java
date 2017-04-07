package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import com.selenium.test.pages.Navigate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rahi on 2017-04-07.
 */
public class ToursPage extends BasePhptravelsPage {

    @FindBy(xpath = "//small[contains(.,'GBP')]")
    protected WebElement currencyText;

    public String getExpectedCurrency()
    {
        return currencyText.getText();
    }


    public Navigate navigate()
    {
        return new Navigate();
    }
}
