package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {

    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");


    private WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage enterUserName(String userNameText) {
        Utility.sendData(driver, userName, userNameText);
        return this;
    }

    public P01_LoginPage enterPassword(String passwordText) {
        Utility.sendData(driver, password, passwordText);
        return this;
    }

    public P02_HomePage clickOnLogin() {
        Utility.clickOnElement(driver, loginButton);
        return new P02_HomePage(driver);
    }


    public boolean assertLoginTC(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);

    }


}
