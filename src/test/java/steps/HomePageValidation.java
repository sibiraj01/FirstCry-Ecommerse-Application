package steps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class HomePageValidation {
    public WebDriver driver;
    public Properties properties;
    MainClass login;
    Logger logger = LogManager.getLogger(HomePageValidation.class);
    // ScreenShotsUtils screenShotsUtils = new ScreenShotsUtils();
    ActionUtils action;

    @Test
    public void validateHomePage() throws IOException {
        login = new MainClass();
        login.setup();
        login.loadUrl();
        login.VerifyPageTitle();
        driver = login.driver;

        action = new ActionUtils(driver);

        // Navigated to the URL and validating the login button is presented
        WebElement loginCTA = driver.findElement(By.xpath("//span[text()='Login /']"));
        Assert.assertTrue(loginCTA.isDisplayed(),"Login button is not present");
        logger.info("Login button is presented in the home page");

        // Validating the Cart icon present in the dom
        WebElement cartIcon = driver.findElement(By.xpath("//span[text()='Cart']"));
        Assert.assertTrue(cartIcon.isDisplayed(),"Cart icon is not present");
        ScreenShotsUtils.takeScreenShot(driver);
        action.ScrollDown();
    }
//
//    @Test
//    public void ScrollDown() {
//    //    actionUtils.ScrollDown();
    }

