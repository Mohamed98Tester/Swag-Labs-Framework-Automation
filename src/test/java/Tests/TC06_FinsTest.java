package Tests;

import Utilities.DataUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P04_CheckOut_Button;
import pages.P05_CheckoutOverview;
import pages.P06_FinshPage;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;

public class TC06_FinsTest {

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(DataUtility.getValue("environment", "browser"));
        getDriver().get(DataUtility.getValue("environment", "Base_URL"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Finshpage() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(DataUtility.getValue("environment", "userName"))
                .enterPassword(DataUtility.getValue("environment", "password"))
                .clickOnLogin().addAllProduct()
                .clickOnCarIcon();
        new P04_CheckOut_Button(getDriver()).clickOnCheckButton()
                .enterData(DataUtility.getValue("environment", "firstName"),
                        DataUtility.getValue("environment", "lastName"),
                        DataUtility.getValue("environment", "zipCode"))
                .clickOnContinue();
        new P05_CheckoutOverview(getDriver()).clickOnFinishButton();

        Assert.assertTrue(new P06_FinshPage(getDriver()).checkThanksMessage());

    }

//    @AfterMethod
//    public void quite() {
//        quitDriver();
//    }
}
