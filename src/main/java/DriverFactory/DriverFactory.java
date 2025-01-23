package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setupDriver(String browser) {
        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-Maximized");
                driverThreadLocal.set(new ChromeDriver(chromeOptions));
                break;
            default:
                EdgeOptions options1 = new EdgeOptions();
                options1.addArguments("--start-Maximized");
                driverThreadLocal.set(new EdgeDriver(options1));
                break;


        }

    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        getDriver().quit();
    }


}
