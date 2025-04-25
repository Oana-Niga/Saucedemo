package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageLocators.ProductDetailsLocators;
import pageLocators.ProductsLocators;

public class ProductDetailsPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void checkProductDetailsDisplayed() {
        elementHelper.waitForElementVisible(ProductDetailsLocators.productName);
        elementHelper.waitForElementVisible(ProductDetailsLocators.productPrice);
        elementHelper.waitForElementVisible(ProductDetailsLocators.productImage);
        elementHelper.waitForElementVisible(ProductDetailsLocators.productDescription);
        LoggerUtility.infoTest("Numele, prețul, imaginea și descrierea sunt afișate în pagina de produs");
    }

    public void clickAddToCartButton() {
        elementHelper.clickJSLocator(ProductDetailsLocators.addToCartButton);
        LoggerUtility.infoTest("S-a dat click pe butonul „Add to cart” din pagina de detalii");
    }

    public void clickRemoveButton() {
        elementHelper.clickLocator(ProductDetailsLocators.removeButton);
        LoggerUtility.infoTest("S-a dat click pe butonul „Remove” din pagina de detalii");
    }

    public void clickCartIcon() {
        elementHelper.clickLocator(ProductsLocators.cartIcon);
        LoggerUtility.infoTest("S-a dat click pe iconița coșului din pagina de detalii");
    }
}
