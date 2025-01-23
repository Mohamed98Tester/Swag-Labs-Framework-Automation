package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utilities.Utility.generalWait;

public class P04_CheckOut_Button {
    //    private final By checkOutButton = By.xpath("//button[contains(@class, 'btn_action')]");
    private final By checkOutButton = By.cssSelector("[href='./checkout-step-one.html']");

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zibCode = By.id("postal-code");
    private final By continueButton = By.cssSelector("[type='submit']");

    private WebDriver driver;

    public P04_CheckOut_Button(WebDriver driver) {
        this.driver = driver;
    }


//
//    public P04_CheckOut_Button enterFirstName(String FirstName) {
//        Utility.sendData(driver, firstName, FirstName);
//        return this;
//    }
//
//    public P04_CheckOut_Button enterLastName(String LastName) {
//        Utility.sendData(driver, lastName, LastName);
//        return this;
//    }
//
//    public P04_CheckOut_Button enterZibCode(String ZibCode) {
//        Utility.sendData(driver, zibCode, ZibCode);
//        return this;
//    }

    public P04_CheckOut_Button clickOnCheckButton() {
        Utility.clickOnElement(driver, checkOutButton);
        return this;
    }

    public P04_CheckOut_Button enterData(String FName, String lName, String Zcode) {

        Utility.sendData(driver, firstName, FName);
        Utility.sendData(driver, lastName, lName);
        Utility.sendData(driver, zibCode, Zcode);
        return this;

    }

    public P05_CheckoutOverview clickOnContinue() {
        Utility.clickOnElement(driver, continueButton);
        return new P05_CheckoutOverview(driver);
    }

    public boolean verifyUrl(String expectedUrl) {
        generalWait(driver).until(ExpectedConditions.urlToBe(expectedUrl));
        return true;
    }
}
