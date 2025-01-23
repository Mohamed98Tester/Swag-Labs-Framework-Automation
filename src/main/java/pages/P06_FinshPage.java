package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_FinshPage {
    private final By thanksMessage = By.className("complete-header");
    private WebDriver driver;


    public P06_FinshPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkThanksMessage() {
//        return  thanksMessage.equals("THANK YOU FOR YOUR ORDER");
//        return driver.findElement(thanksMessage).isDisplayed();
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/checkout-complete.html");
    }
}
