package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.CartLocators;
import sharedData.SharedData;

public class CartPage extends SharedData {
    private WebDriver driver;
    private ElementHelper elementHelper;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
    }

    public void removeProduct() {
        elementHelper.clickLocator(CartLocators.removeButton);
        LoggerUtility.infoTest("Produsul a fost eliminat din coș");
    }

    public void clickCheckoutButton() {
        driver.findElement(CartLocators.checkoutButton).click();
        LoggerUtility.infoTest("S-a dat click pe butonul Checkout");
    }
}
