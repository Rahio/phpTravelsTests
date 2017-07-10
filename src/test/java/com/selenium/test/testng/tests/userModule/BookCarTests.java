package com.selenium.test.testng.tests.userModule;

import com.selenium.test.pages.userModule.InvoicePage;
import com.selenium.test.pages.userModule.LandingPage;
import com.selenium.test.testng.tests.TestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Rahi on 2017-04-04.
 */
public class BookCarTests extends TestTemplate {

    private InvoicePage invoicePage;

    private static final String RESERVED_TOUR_MESSAGE = "Reserved";
    private static final String CONTACT_INFO = "PHPTRAVELS\n" +
            "1355 Market St, Suite 900\n" +
            "San Francisco, United States :\n" +
            "email@domain.com :\n" +
            "+123-456-789 :";
    private static final String CUSTOMER_DETAILS = "John Smith\n" +
            "R2, Avenue du Maroc\n" +
            "123456";
    private static final String CAR_DESCRIPTION = "Toyota Camry 2015 full option";


    @BeforeClass(alwaysRun = true)
    public void set()
    {
        invoicePage = new InvoicePage();
    }

    @Test(groups = "smoke")
    public void userCanBookCar(){
        new LandingPage()
            .goToLoginPage()
                    .fillCredentialsAndLogin("user@phptravels.com", "demouser")
                        .goToCarsPage()
                            .selectCar()
                                .setDestination()
                                .bookCar()
                                    .confirmBookingWithoutChanges()
                                        .payOnArrival();

        Assert.assertEquals(invoicePage.getOrderStatus(), RESERVED_TOUR_MESSAGE);
        Assert.assertEquals(invoicePage.getContactInfo(), CONTACT_INFO);
        Assert.assertEquals(invoicePage.getCustomerDetails("John Smith"), CUSTOMER_DETAILS);
        Assert.assertEquals(invoicePage.getCarDescription(), CAR_DESCRIPTION);


    }

}
