package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageLocators.ProductsLocators;

public class ProductsPage {
    private WebDriver driver;
    private ElementHelper elementHelper;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkProductListIsVisible() {
        elementHelper.waitForElementVisible(ProductsLocators.productName);
        elementHelper.waitForElementVisible(ProductsLocators.productPrice);
        elementHelper.waitForElementVisible(ProductsLocators.productImage);

        LoggerUtility.infoTest("Lista de produse este afișată corect: nume, preț și imagine");
    }


    public void clickMenuButton() {
        driver.findElement(ProductsLocators.burgerMenuButton).click();
        LoggerUtility.infoTest("A fost apăsat butonul de meniu");
    }

    public void checkMenuOptionIsCorrect(String expectedText) {
        elementHelper.waitForElementVisible(ProductsLocators.menuOption);
        String actualText = driver.findElement(ProductsLocators.menuOption).getText();
        Assert.assertEquals(actualText, expectedText, "Opțiunea din meniu este greșită");
        LoggerUtility.infoTest("Opțiunea din meniu este corectă: " + actualText);
    }

    public void sortProducts(String value) {
        elementHelper.selectElement(ProductsLocators.sortDropdown, value);
        LoggerUtility.infoTest("A fost selectată opțiunea de sortare: " + value);
    }

    public void clickAddToCartButton() {
        driver.findElement(ProductsLocators.addToCartButton).click();
        LoggerUtility.infoTest("A fost apăsat butonul „Add to cart”");
    }

    public void checkCartBadgeIs(String expectedCount) {
        elementHelper.waitForElementVisible(ProductsLocators.cartBadge);
        String actualCount = driver.findElement(ProductsLocators.cartBadge).getText();
        Assert.assertEquals(actualCount, expectedCount, "Numărul produselor din coș nu este corect");
        LoggerUtility.infoTest("Coșul afișează corect numărul de produse: " + actualCount);
    }

    public void clickCartIcon() {
        driver.findElement(By.className("shopping_cart_link")).click();
        LoggerUtility.infoTest("A fost apăsată pictograma coșului");
    }

    public void clickRemoveButton() {
        driver.findElement(ProductsLocators.removeButton).click();
        LoggerUtility.infoTest("A fost apăsat butonul „Remove”");
    }

    public void clickFirstProduct() {
        driver.findElement(ProductsLocators.productName).click();
        LoggerUtility.infoTest("Navigat către pagina de detalii a produsului");
    }

    public void clickSecondAddToCartButton() {
        driver.findElements(By.className("btn_inventory")).get(1).click();
        LoggerUtility.infoTest("A fost apăsat al doilea buton „Add to cart”");
    }

    public void clickLogoutOption() {
        driver.findElement(By.id("logout_sidebar_link")).click();
        LoggerUtility.infoTest("A fost apăsată opțiunea Logout");
    }
}
