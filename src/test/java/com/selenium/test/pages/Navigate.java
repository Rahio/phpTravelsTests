package com.selenium.test.pages;

import com.selenium.test.pages.userModule.HomePage;
import com.selenium.test.pages.userModule.HotelsPage;
import com.selenium.test.pages.userModule.ToursPage;

import static com.selenium.test.webtestsbase.WebDriverFactory.getDriver;

/**
 * Created by Rahi on 2017-04-07.
 */
public class Navigate  {

    public Navigate()
    {

    }

    public HotelsPage toHotelsPage()
    {
        getDriver().navigate().to("http://www.phptravels.net/hotel/");
        return new HotelsPage();
    }

    public HomePage toHomePage()
    {
        getDriver().navigate().to("http://www.phptravels.net/");
        return new HomePage();
    }

    public ToursPage toToursPage()
    {
        getDriver().navigate().to("http://www.phptravels.net/tours/");
        return new ToursPage();
    }


}
