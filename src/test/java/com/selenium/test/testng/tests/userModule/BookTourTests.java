package com.selenium.test.testng.tests.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import com.selenium.test.pages.userModule.LandingPage;
import com.selenium.test.testng.tests.TestTemplate;
import org.testng.annotations.Test;

/**
 * Created by Rahi on 2017-04-04.
 */
public class BookTourTests extends TestTemplate{

    @Test(groups = "run")
    public void userCanBookNormalTour(){
        new LandingPage()
                .goToLoginPage()
                    .fillCredentialsAndLogin("user@phptravels.com", "demouser")//.goToMyProfile()
                        .goToToursPage()
                            .openFirstTourPage()
                                .bookThisTour()
                                    .confirmBookingWithoutChanges()
                                        .payOnArrival();
    }


}
