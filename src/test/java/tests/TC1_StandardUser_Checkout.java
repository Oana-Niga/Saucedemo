package tests;

import loggerUtility.LoggerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import sharedData.SharedData;

public class TC1_StandardUser_Checkout extends SharedData {

    @Test
    public void testContinueToCheckoutStepTwo() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        loggerUtility.LoggerUtility.infoTest("Utilizatorul a fost autentificat");

        productsPage.clickAddToCartButton();
        productsPage.clickCartIcon();
        loggerUtility.LoggerUtility.infoTest("Produsul a fost adăugat și s-a navigat către coș");

        cartPage.clickCheckoutButton();
        loggerUtility.LoggerUtility.infoTest("S-a dat click pe butonul Checkout");

        checkoutPage.fillFirstName("Oana");
        checkoutPage.fillLastName("Niga");
        checkoutPage.fillPostalCode("12345");
        loggerUtility.LoggerUtility.infoTest("S-au completat câmpurile de checkout");

        checkoutPage.clickContinue();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";

        Assert.assertEquals(currentUrl, expectedUrl, "Nu ai ajuns la pasul 2 din checkout");
        loggerUtility.LoggerUtility.infoTest("Navigare corectă în pasul 2 al checkout-ului");
    }

    @Test
    public void testOrderCompletion() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        loggerUtility.LoggerUtility.infoTest("Autentificare reușită");

        productsPage.clickAddToCartButton();
        productsPage.clickCartIcon();
        loggerUtility.LoggerUtility.infoTest("Navigare în coș după adăugarea produsului");

        cartPage.clickCheckoutButton();
        loggerUtility.LoggerUtility.infoTest("Click pe Checkout");

        checkoutPage.fillFirstName("Oana");
        checkoutPage.fillLastName("Niga");
        checkoutPage.fillPostalCode("12345");
        loggerUtility.LoggerUtility.infoTest("Informații completate pentru comandă");

        checkoutPage.clickContinue();
        checkoutPage.clickFinishButton();
        loggerUtility.LoggerUtility.infoTest("Comanda a fost finalizată");
    }

    @Test
    public void testErrorMessageForMissingFields() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        LoggerUtility.infoTest("Autentificare efectuată");

        productsPage.clickAddToCartButton();
        productsPage.clickCartIcon();
        LoggerUtility.infoTest("Navigare în coș");

        cartPage.clickCheckoutButton();
        LoggerUtility.infoTest("Accesare pagina de checkout");

        checkoutPage.fillFirstName("Oana");
        checkoutPage.clickContinue();
        LoggerUtility.infoTest("S-a încercat continuarea fără completarea câmpurilor obligatorii (Last Name + Postal Code)");

        String actualError = checkoutPage.getErrorMessage();
        String expectedError = "Error: Last Name and Postal Code are required";

        Assert.assertEquals(actualError, expectedError, "Aplicația NU a afișat toate câmpurile lipsă.");
        LoggerUtility.infoTest("Verificarea mesajului de eroare s-a realizat");
    }

    @Test
    public void testCheckoutWithEmptyCartFails() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        LoggerUtility.infoTest("Utilizatorul s-a autentificat cu succes");

        productsPage.clickCartIcon();
        LoggerUtility.infoTest("S-a accesat coșul (care este gol)");

        cartPage.clickCheckoutButton();
        LoggerUtility.infoTest("S-a apăsat pe butonul Checkout");


        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/cart.html";

        Assert.assertEquals(actualUrl, expectedUrl, "Checkout-ul NU trebuia să continue cu coșul gol!");
        LoggerUtility.infoTest("Checkout-ul nu a continuat");
    }
}
