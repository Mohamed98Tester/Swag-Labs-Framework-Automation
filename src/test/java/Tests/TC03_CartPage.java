package Tests;

import Utilities.DataUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_HomePage;
import pages.P03_CartPage;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;

public class TC03_CartPage {


    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(DataUtility.getValue("environment", "browser"));
        getDriver().get(DataUtility.getValue("environment", "Base_URL"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void clickONCartIcon() throws IOException {
        String totalPrice = new P01_LoginPage(getDriver())
                .enterUserName(DataUtility.getValue("environment", "userName"))
                .enterPassword(DataUtility.getValue("environment", "password"))
                .clickOnLogin().addAllProduct().getPrice();

        new P02_HomePage(getDriver()).clickOnCarIcon();
        Assert.assertTrue(new P03_CartPage(getDriver()).comparePrice(totalPrice));

    }


}
