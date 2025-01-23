package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_CheckoutOverview {

    private final By itemTotal = By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");
    private final By total = By.className("summary_total_label");
    private final By finishButton = By.xpath("//a[contains(@class,'btn_action')]");
    private WebDriver driver;

    public P05_CheckoutOverview(WebDriver driver) {
        this.driver = driver;
    }

    public Float getItemTotal() {
        return Float.parseFloat(Utility.getText(driver, itemTotal).replace("Item total: $", ""));
    }

    public Float getTax() {


        return Float.parseFloat(Utility.getText(driver, tax).replace("Tax: $", " "));

    }

    public Float getTotal() {

        return Float.parseFloat(Utility.getText(driver, total).replace("Total: $", " "));
    }


    //TODO: Calculate item total + Tax
    public String calculateTotalPrice() {
        return String.valueOf(getItemTotal() + getTax());
    }

//TODO Compare

    public boolean comparePrice() {
        return calculateTotalPrice().equals(String.valueOf(getTotal()));
    }

    //TODO Click on Finish button and take a driver in another page create new class
    public P06_FinshPage clickOnFinishButton() {
        Utility.clickOnElement(driver, finishButton);
        return new P06_FinshPage(driver);
    }

}

