package pageLocators;

import org.openqa.selenium.By;

public class CheckoutLocators {
    public static final By firstName = By.id("first-name");
    public static final By lastName = By.id("last-name");
    public static final By postalCode = By.id("postal-code");
    public static final By continueButton = By.id("continue");
    public static final By finishButton = By.id("finish");
    public static final By errorMessage = By.cssSelector("h3[data-test='error']");



}
