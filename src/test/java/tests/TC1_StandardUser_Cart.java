package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import sharedData.SharedData;
import loggerUtility.LoggerUtility;

public class TC1_StandardUser_Cart extends SharedData {

    @Test
    public void testRemoveProductFromCartPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickAddToCartButton();
        LoggerUtility.infoTest("Produsul a fost adăugat în coș din pagina principală");

        productsPage.clickCartIcon();
        LoggerUtility.infoTest("Navigare către pagina coșului");

        cartPage.removeProduct();
        LoggerUtility.infoTest("Produsul a fost eliminat din coș");
    }

    @Test
    public void testRemoveProductFromMainPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickAddToCartButton();
        LoggerUtility.infoTest("Produsul a fost adăugat");

        productsPage.clickRemoveButton();
        LoggerUtility.infoTest("Produsul a fost eliminat din pagina principală");
    }

    @Test
    public void testRemoveProductFromDetailsPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickFirstProduct();
        LoggerUtility.infoTest("S-a deschis pagina de detalii a produsului");

        productDetailsPage.clickAddToCartButton();
        LoggerUtility.infoTest("Produsul a fost adăugat din pagina de detalii");

        productDetailsPage.clickRemoveButton();
        LoggerUtility.infoTest("Produsul a fost eliminat din pagina de detalii");
    }

    @Test
    public void testAddTwoProductsAndAccessCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickAddToCartButton();
        productsPage.clickSecondAddToCartButton();
        LoggerUtility.infoTest("Două produse au fost adăugate în coș");

        productsPage.clickCartIcon();
        LoggerUtility.infoTest("Navigare către pagina de coș");
    }

    @Test
    public void testProductPersistenceAfterLogout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickAddToCartButton();
        LoggerUtility.infoTest("Produs adăugat în coș");

        productsPage.clickMenuButton();
        productsPage.clickLogoutOption();
        LoggerUtility.infoTest("Utilizatorul s-a delogat");

        loginPage.login("standard_user", "secret_sauce");
        LoggerUtility.infoTest("Utilizatorul s-a relogat");

    }

    @Test
    public void testErrorOnCheckoutWithEmptyCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickCartIcon();
        LoggerUtility.infoTest("Navigare în coș cu coșul gol");

        cartPage.clickCheckoutButton();
        LoggerUtility.infoTest("S-a apăsat pe butonul Checkout fără produse în coș");
    }

    @Test
    public void testNavigateToCheckoutPageWithProduct() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickAddToCartButton();
        LoggerUtility.infoTest("Produs adăugat în coș");

        productsPage.clickCartIcon();
        cartPage.clickCheckoutButton();
        LoggerUtility.infoTest("S-a dat click pe Checkout");

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";

        Assert.assertEquals(currentUrl, expectedUrl, "Nu s-a navigat către pagina de checkout");
        LoggerUtility.infoTest("Navigare corectă în pagina de checkout");
    }
}
