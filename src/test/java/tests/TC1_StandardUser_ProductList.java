package tests;

import loggerUtility.LoggerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import sharedData.SharedData;

public class TC1_StandardUser_ProductList extends SharedData {

    @Test
    public void testProductDisplayOnMainPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        LoggerUtility.infoTest("Afișarea produselor pe pagina principală");

        loginPage.login("standard_user", "secret_sauce");
        productsPage.checkProductListIsVisible();

        LoggerUtility.infoTest("Produsele sunt afișate corect pe pagina principală");
    }

    @Test
    public void testMenuDisplayedCorrectly() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        LoggerUtility.infoTest("Afișare meniu lateral corect");

        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickMenuButton();
        productsPage.checkMenuOptionIsCorrect("All Items");

        LoggerUtility.infoTest("Meniul lateral este afișat corect cu opțiunea 'All Items'");
    }


    @Test
    public void testSortByPriceLowToHigh() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        LoggerUtility.infoTest("➡Sortare produse după preț (crescător)");

        loginPage.login("standard_user", "secret_sauce");
        productsPage.sortProducts("lohi");

        LoggerUtility.infoTest("Produsele au fost sortate după preț crescător");
    }

    @Test
    public void testSortByPriceHighToLow() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        LoggerUtility.infoTest("Sortare produse după preț (descrescător)");

        loginPage.login("standard_user", "secret_sauce");
        productsPage.sortProducts("hilo");

        LoggerUtility.infoTest("Produsele au fost sortate după preț descrescător");
    }


    @Test
    public void testSortByNameAToZ() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        LoggerUtility.infoTest("Sortare produse după nume (A → Z)");

        loginPage.login("standard_user", "secret_sauce");
        productsPage.sortProducts("az");

        LoggerUtility.infoTest("Produsele au fost sortate după nume de la A la Z");
    }

    @Test
    public void testSortByNameZToA() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        LoggerUtility.infoTest("Sortare produse după nume (Z → A)");

        loginPage.login("standard_user", "secret_sauce");
        productsPage.sortProducts("za");

        LoggerUtility.infoTest("Produsele au fost sortate după nume de la Z la A");
    }


    @Test
    public void testAddProductToCartFromMainPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton();
        productsPage.checkCartBadgeIs("1");
    }
    @Test
    public void testNavigateToCartPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickAddToCartButton();
        productsPage.clickCartIcon();

        LoggerUtility.infoTest("Utilizatorul a fost direcționat spre pagina coșului");
    }

}
