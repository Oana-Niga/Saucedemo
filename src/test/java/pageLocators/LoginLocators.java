package pageLocators;

import org.openqa.selenium.By;

public class LoginLocators {

    public static final By usernameElement = By.id("user-name");
    public static final By passwordElement = By.id("password");
    public static final By loginButton = By.id("login-button");
    public static final By errorMessage = By.cssSelector("h3[data-test='error']");
}
