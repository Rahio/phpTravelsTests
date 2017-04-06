package com.selenium.test.testng.smokeTests;

import com.selenium.test.pages.BasePhptravelsPage;
import com.selenium.test.pages.userModule.HomePage;
import com.selenium.test.pages.userModule.LandingPage;
import com.selenium.test.testng.tests.TestTemplate;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by Rahi on 2017-04-04.
 */
public class ChangeCurrencyTests extends TestTemplate{

    private static final String CURRENCY = "GBP";

    //expecty dla pozostałych podstron TODO
    @Test
    public void userCanChangeCurrency() {
        new BasePhptravelsPage()
                .changeCurrency(CURRENCY);

        Assert.assertEquals(new HomePage().getExpectedCurrency(), CURRENCY);
    }

    public void userCanBookHotelInChoosenCurrency()
    {

    }

}
