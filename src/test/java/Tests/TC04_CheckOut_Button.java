package Tests;

import Utilities.DataUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P04_CheckOut_Button;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;

public class TC04_CheckOut_Button {

    @BeforeMethod
    public void setUP() throws IOException {
        setupDriver(DataUtility.getValue("environment", "browser"));
        getDriver().get(DataUtility.getValue("environment", "Base_URL"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void checkOutButton() throws IOException {
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
        Assert.assertTrue(new P04_CheckOut_Button(getDriver())
                .verifyUrl(DataUtility.getValue("environment", "expectedUrl")));
    }


}
