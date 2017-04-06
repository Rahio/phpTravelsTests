package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePage;
import com.selenium.test.pages.BasePhptravelsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rahi on 2017-04-06.
 */
public class HomePage extends BasePhptravelsPage {

    @FindBy(xpath = "//small[contains(.,'GBP')]")
    protected WebElement currencyText;

    public String getExpectedCurrency()
    {
        return currencyText.getText();
    }

}
