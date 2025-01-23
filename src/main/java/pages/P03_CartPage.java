package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_CartPage {

    static float totalPrice;

    private final By priceIsChossing = By.className("inventory_item_price");
    private WebDriver driver;

    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: for return all price which chose
    public String getTotalPrice() {
// get all price choce and save in list
        List<WebElement> priceOfSelectElement = driver.findElements(priceIsChossing);

        for (int i = 1; i <= priceOfSelectElement.size(); i++) {

            By element = By.xpath("(//button[.='REMOVE']//preceding-sibling::div[@class='inventory_item_price'])[" + i + "]");
            String FullText = Utility.getText(driver, element);// full text ( price + $ )
            totalPrice += Float.parseFloat(FullText.replace("$", " "));
            // replace $ from total price
        }


        return String.valueOf(totalPrice);
    }

    public P03_CartPage openCartPage() {
        Utility.clickOnElement(driver, priceIsChossing);
        return this;
    }

    public boolean comparePrice(String price) {

        return getTotalPrice().equals(price);
    }


}
