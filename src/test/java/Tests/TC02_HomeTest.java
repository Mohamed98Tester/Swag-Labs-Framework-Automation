package Tests;

import Utilities.DataUtility;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_HomePage;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class TC02_HomeTest {

    @BeforeMethod
    public void setup() throws IOException {

        setupDriver(DataUtility.getValue("environment", "browser"));
        getDriver().get(DataUtility.getValue("environment", "Base_URL"));
        getDriver().manage().timeouts().implicitlyWait
                (Duration.ofSeconds(10));
    }

    @Test
    public void checkNumberSelected() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(DataUtility.getValue("environment", "userName"))
                .enterPassword(DataUtility.getValue("environment", "password"))
                .clickOnLogin().addAllProduct();
        Utility.takeFullScreen(getDriver(), "CheckNumerOfCart", new P02_HomePage(getDriver()).retrievedCarIcon());
//take full screen by mark on car icon
        Assert.assertTrue(new P02_HomePage(getDriver()).compareNumSelected());
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }

}
