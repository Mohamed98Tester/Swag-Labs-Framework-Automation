package Utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utility {

    //TODO : fun to Click on element whit Wait
    public static void clickOnElement(WebDriver driver, By locator) {

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    //TODO : fun to send Data with Wait
    public static void sendData(WebDriver driver, By locator, String text) {

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    //TODO : fun get Test
    public static String getText(WebDriver driver, By locator) {

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();


    }

    //TODO : General Wait can use (.Until ) and any expected
    public static WebDriverWait generalWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //TODO : Time Stamp
    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());
    }


    //TODO: ScreenShoot
    public static void takeScreenshot(WebDriver driver, String screenName) throws IOException {      // send name of image everytime
        String path = "Test-outPuts/ScreenShots";// save path

        try {             //عشان لو حصل اى حاجه هنا متعطلش التيست بتاعى وتكمل عادى ويقولى لمشكلة فين


            File ScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File location = new File(path + screenName + "   " + getTimeStamp() + ".JPG");
            FileUtils.copyFile(ScreenShot, location);
            Allure.addAttachment(screenName, Files.newInputStream(Path.of(location.getPath())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO: Take Full ScreenShoot
    public static void takeFullScreen(WebDriver driver, String screenName, By locator) {
        String path = "Test-outPuts/ScreenShots";// save path
        Shutterbug.shootPage(driver, Capture.FULL_SCROLL)
                .highlight(findElement(driver, locator)).save(path);

    }


    //TODO : Transfer  WebElement to Locator
    public static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    //TODO : Scrolling
    public static void scrolling(WebDriver driver, By loator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , findElement(driver, loator));
    }

    //TODO : Select From DropDown List
    public static void selectDDL(WebDriver driver, By locator, String option) {
        new Select(findElement(driver, locator)).selectByVisibleText(option);
    }


}
