package Tests;

import Utilities.DataUtility;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LoginPage;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class TC01_LogignTest {

    @BeforeMethod
    public void setup() throws IOException {

        setupDriver(DataUtility
                .getValue("environment", "browser"));
        LogsUtils.info("open browser");
        getDriver().get(DataUtility
                .getValue("environment", "Base_URL"));

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test
    public void validLogin() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(DataUtility
                        .getValue("environment", "userName"))
                .enterPassword(DataUtility
                        .getValue("environment", "password"))
                .clickOnLogin();
        Assert.assertTrue(new P01_LoginPage(getDriver())
                .assertLoginTC(DataUtility.getValue("environment", "homeURL")));

    }

    @AfterMethod

    public void quit() {
        quitDriver();
    }


}
