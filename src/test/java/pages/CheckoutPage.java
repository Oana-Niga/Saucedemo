package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.CheckoutLocators;

public class CheckoutPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
    }

    public void fillFirstName(String name) {
        elementHelper.fillLocator(CheckoutLocators.firstName, name);
        LoggerUtility.infoTest("Câmpul First Name a fost completat cu: " + name);
    }

    public void fillLastName(String name) {
        elementHelper.fillLocator(CheckoutLocators.lastName, name);
        LoggerUtility.infoTest("Câmpul Last Name a fost completat cu: " + name);
    }

    public void fillPostalCode(String code) {
        elementHelper.fillLocator(CheckoutLocators.postalCode, code);
        LoggerUtility.infoTest("Câmpul Zip/Postal Code a fost completat cu: " + code);
    }

    public void clickContinue() {
        elementHelper.clickLocator(CheckoutLocators.continueButton);
        LoggerUtility.infoTest("S-a dat click pe butonul Continue");
    }

    public void clickFinishButton() {
        elementHelper.clickLocator(CheckoutLocators.finishButton);
        LoggerUtility.infoTest("S-a dat click pe butonul Finish pentru a finaliza comanda");
    }
    public String getErrorMessage() {
        return driver.findElement(CheckoutLocators.errorMessage).getText();
    }

}
