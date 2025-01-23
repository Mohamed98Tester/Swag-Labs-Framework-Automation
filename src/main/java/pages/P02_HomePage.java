package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class P02_HomePage {

    static float totalPrice = 0; // the real price

    private final By SelectAllProduct = By.xpath("//button[@class]");
    private final By cartIcon = By.cssSelector("span.fa-layers-counter.shopping_cart_badge");
    private final By numberWhichSelected = By.xpath("//button[contains(text(), 'REMOVE')]");
    private final By pageOFCARIcon = By.id("shopping_cart_container");//to select car icon then open car page
    private final By priceIsChossing = By.xpath("//button[.='REMOVE']//preceding-sibling::div[@class='inventory_item_price']");//to select price which selected in home page
    //TODO: list to save all product
    private List<WebElement> allProduct;
    // find locator use
    //TODO : List of num of selected
    private List<WebElement> alreadySelected;
    private WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //initialize driver
// TODO: عشان بس ترجعلى الايقون ده عشان اقدر استخدمها لما اخد اسكرين كامله واستدعى الإليمنت ده يتعمل عليه علامة هيلايت
    public By retrievedCarIcon() {
        return cartIcon;
    }

    //TODO: Action : Add ALL product to Cart
    public P02_HomePage addAllProduct() {
        allProduct = driver.findElements(SelectAllProduct);// الى هيتحفظ ف all product الى هما دول
        for (int i = 1; i <= allProduct.size(); i++) {
            By SelectAllProduct = By.xpath("(//button[@class])[" + i + "]");//dynamic locator i= 1:6
            Utility.clickOnElement(driver, SelectAllProduct);
        }
        return this;
    }

    //TODO : get number of product on icon of cart
//    public String getNumOfProduct() {
//        try {           // if not have a num of icon (no such element)
//            return Utility.getText(driver, cartIcon);
//
//        } catch (Exception e) {
//            LogsUtils.error(e.getMessage());
//        }
//        return "0";
//    }

    public String getNumOfProduct() {

        return Utility.getText(driver, cartIcon).trim();
    }

    //TODO : Compare between Selected product and number which written on cart icon علامة الســـلـة
    /* دلوقتى هشوف عدد الى اتغير الاستيتيس بتاعتهم من ادد للكارت إلى الريموف
    fun to clear which count of number have change status from add to chart for Remove
     هتحفظهوملى ف القايمة دى وترجعلى عددهم بس كدا
     */
    public String getNubmerOfSelected() {
        alreadySelected = driver.findElements(numberWhichSelected);
        return String.valueOf(alreadySelected.size()); // return count or size number selected
//String.valueOf IDE عشان دي استرينج وهترجع رقم اضافها

    }

    // دلوقتى معايا عدد الى اتعملهم ف الاول ادد للكارت ومعايا دلوقتى عدد الى بقى معملوهم استيتس ريموف اقارن بقي
//    public boolean compareNumSelected() {
//        return getNumOfProduct().equals(getNubmerOfSelected());
//    }

    public boolean compareNumSelected() {
        String numOnCartIcon = getNumOfProduct();
        String numOfSelected = getNubmerOfSelected();

        // إضافة السجلات
        System.out.println("Number on Cart Icon: " + numOnCartIcon);
        System.out.println("Number of Selected Products: " + numOfSelected);

        return numOnCartIcon.equals(numOfSelected);
    }


    public P03_CartPage clickOnCarIcon() {

        Utility.clickOnElement(driver, pageOFCARIcon);
        return new P03_CartPage(driver);

    }

    //TODO: for return all price which chose
    public String getPrice() {
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

}
