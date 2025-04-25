package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SharedData {

    public WebDriver driver;
    public String testName;

    @BeforeMethod
    public void prepareEnvironment() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        testName = this.getClass().getSimpleName();
        LoggerUtility.startTest(testName);
    }

    @AfterMethod
    public void clearEnvironment() {
        driver.quit();

        testName = this.getClass().getSimpleName();
        LoggerUtility.finishTest(testName);

    }
}
