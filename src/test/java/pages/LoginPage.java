package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.LoginLocators;

import static pageLocators.LoginLocators.passwordElement;
import static pageLocators.LoginLocators.usernameElement;

public class LoginPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void fillUsername(String usernameValue) {
        elementHelper.fillLocator(usernameElement, usernameValue);
        LoggerUtility.infoTest("Utilizatorul a completat numele de utilizator");
    }

    public void fillPassword(String passwordValue) {
        elementHelper.fillLocator(passwordElement, passwordValue);
        LoggerUtility.infoTest("Utilizatorul a completat parola");
    }

    public void clickLoginButton(){
        elementHelper.clickLocator(LoginLocators.loginButton);
        LoggerUtility.infoTest("Utilizatorul a dat click pe butonul de login");
    }

    public String getErrorMessage() {
            return driver.findElement(LoginLocators.errorMessage).getText();
        }
    public void login(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLoginButton();
        LoggerUtility.infoTest("Autentificare finalizată" + username);
    }



}



