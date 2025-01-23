package Listeners;

import Utilities.Utility;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.IOException;

import static DriverFactory.DriverFactory.getDriver;

public class IInvokedMethod implements IInvokedMethodListener {

    public void beforeInvocation(org.testng.IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }

    public void afterInvocation(org.testng.IInvokedMethod method, ITestResult testResult, ITestContext context) {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            try {
                Utility.takeScreenshot(getDriver(), testResult.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
