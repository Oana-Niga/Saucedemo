package tests;

import loggerUtility.LoggerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;

public class TC1_StandardUser_Login extends SharedData {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.clickLoginButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl, "Login failed for standard_user");
        LoggerUtility.infoTest("Login successful");
    }

    @Test
    public void testInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillUsername("standard_user1");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginButton();

        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = loginPage.getErrorMessage();

        Assert.assertEquals(actualError, expectedError, "Wrong error message for invalid username");
    }

    @Test
    public void testInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("secret_sauce1");
        loginPage.clickLoginButton();

        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = loginPage.getErrorMessage();

        Assert.assertEquals(actualError, expectedError, "Wrong error message for invalid password");
    }

    @Test
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("");
        loginPage.clickLoginButton();

        String expectedError = "Epic sadface: Password is required";
        String actualError = loginPage.getErrorMessage();

        Assert.assertEquals(actualError, expectedError, "Wrong error message for empty password");
    }

    @Test
    public void testEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillUsername("");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginButton();

        String expectedError = "Epic sadface: Username is required";
        String actualError = loginPage.getErrorMessage();

        Assert.assertEquals(actualError, expectedError, "Wrong error message for empty username");
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillUsername("");
        loginPage.fillPassword("");
        loginPage.clickLoginButton();

        String expectedError = "Epic sadface: Username and Password are required";
        String actualError = loginPage.getErrorMessage();

        Assert.assertEquals(actualError, expectedError, "Mesajul afișat nu acoperă ambele câmpuri goale");
    }
}

