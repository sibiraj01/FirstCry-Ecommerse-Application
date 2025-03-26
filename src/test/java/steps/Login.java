package steps;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class Login {
    public WebDriver driver;
    public Properties properties;
    MainClass login;
    Logger logger = LogManager.getLogger(HomePageValidation.class);
    // ScreenShotsUtils screenShotsUtils = new ScreenShotsUtils();
    ActionUtils action;

    @Test
    public void LoginButton() throws IOException {
        login = new MainClass();
        login.setup();
        login.loadUrl();
        driver = login.driver;
        WebElement loginCTA = driver.findElement(By.xpath("//span[text()='Login /']"));
        Assert.assertTrue(loginCTA.isDisplayed(),"Login button is not present");
        logger.info("Login button is presented in the home page");
        loginCTA.click();
        logger.info("Clicked on Login button");
    }
}
