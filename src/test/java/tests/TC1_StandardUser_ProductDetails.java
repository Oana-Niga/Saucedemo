package tests;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageLocators.ProductDetailsLocators;
import pageLocators.ProductsLocators;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import sharedData.SharedData;

public class TC1_StandardUser_ProductDetails extends SharedData {

    @Test
    public void testProductDetailsDisplayedCorrectly() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickFirstProduct();

        productDetailsPage.checkProductDetailsDisplayed();
    }


    @Test
    public void testAddProductToCartFromProductDetailsPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ElementHelper elementHelper = new ElementHelper(driver);

        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginButton();

        driver.findElement(ProductsLocators.productName).click();
        LoggerUtility.infoTest("Am accesat pagina produsului");

        driver.findElement(ProductDetailsLocators.addToCartButton).click();
        LoggerUtility.infoTest("Am dat click pe butonul Add to Cart");

        elementHelper.waitForElementVisible(ProductsLocators.cartBadge);
        String badgeCount = driver.findElement(ProductsLocators.cartBadge).getText();

        Assert.assertEquals(badgeCount, "1", "Nu s-a adăugat produsul în coș");
        LoggerUtility.infoTest("Produsul a fost adăugat în coș");
    }
    @Test
    public void testRemoveProductFromDetailsPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickFirstProduct();

        productDetailsPage.clickAddToCartButton();
        LoggerUtility.infoTest("Produsul a fost adăugat în coș de pe pagina de detalii");

        productDetailsPage.clickRemoveButton();
        LoggerUtility.infoTest("Produsul a fost eliminat din coș de pe pagina de detalii");
    }
    @Test
    public void testNavigateToCartFromProductDetailsPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickFirstProduct();

        productDetailsPage.clickAddToCartButton();
        LoggerUtility.infoTest("Produsul a fost adăugat în coș din pagina de detalii");

        productDetailsPage.clickCartIcon();
        LoggerUtility.infoTest("Am navigat către pagina de coș");
    }

}
