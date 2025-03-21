package steps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Login {
    public WebDriver driver;
    public Properties properties;
    Logger logger = LogManager.getLogger(Login.class);
    ScreenShotsUtils screenShotsUtils = new ScreenShotsUtils();

    @BeforeClass
    public void setup() throws IOException {
        // Setting up WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        properties = new Properties();
        properties.load(new FileInputStream("./Xpath.properties"));
        logger.info("Launched the browser successfully");
    }

    @Test(priority = 1)
    public void loadUrl() throws IOException {
        String url = properties.getProperty("Url");
        driver.get(url);
        System.out.println("Navigate to URl"+ url);
        logger.info("Navigated to the URL successfully");
        screenShotsUtils.takeScreenShot(driver);
        logger.info("taken home Page screenshot");
    }

 @Test(dependsOnMethods = "loadUrl()")

    public void VerifyPageTitle() throws IOException {
        //verifying the page title
        WebElement PageLogo = driver.findElement(By.xpath("//img[contains(@title,'Firstcry.com')]"));
        Assert.assertTrue(PageLogo.isDisplayed(),"page logo is not displayed. User might not be logged in.");
        logger.info("Verfied page title");
        screenShotsUtils.takeScreenShot(driver);
    }

   @Test(priority = 3)
    public void SearchProduct() throws IOException {
        //Search a product from search bar in home screen and validating it
        WebElement SearchProduct = waitUtils.waitForElementToBeVisible(driver,(By.id("search_box")),10);
        SearchProduct.click();
        SearchProduct.sendKeys("Footwear");
        driver.findElement(By.xpath("//span[@class='search-button']")).click();
        WebElement Footwear = driver.findElement(By.xpath("//div[@class=\"titleleft\"]//following::h1[contains(text(),'Best Footwear')]"));
        Assert.assertTrue(Footwear.isDisplayed(),"footwear is not displayed user searched for some other product");

        //Clicking first element
        driver.findElement(By.xpath("(//div[@class=\"list_img wifi\"])[1]")).click();
       logger.info("Search for a product");
       screenShotsUtils.takeScreenShot(driver);
      }

      @Test(priority = 4)
    public void SecondWindow(){
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Handle: " + parentWindow);
        String childwindow = WindowUtils.SwitchToChildWindow(driver, parentWindow);
        System.out.println("Child Window handle " + childwindow);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @Test(priority = 5)
    public String validatingTheProduct() throws IOException{
        //verifying the product price is displayed
        WebElement productName = driver.findElement(By.xpath("//span[contains(@class,'h1-name')]/child::span/span"));
        System.out.println(productName.getText());
        String productname = productName.getText();
        WebElement productprice = driver.findElement(By.xpath("//span[contains(@class,'th-discounted')]/parent::p"));
        Assert.assertTrue(productprice.isDisplayed(), "The product price is not displayed");
        System.out.println("Price " + productprice.getText());

        //verifying the age is displayed
        WebElement AgeisVisible = driver.findElement(By.xpath("//span[text()=\"Age: \"]//parent::div[@class=\"euro-span J11M_42\"]"));
        Assert.assertTrue(AgeisVisible.isDisplayed(), "The Age price is not displayed");
        System.out.println("Price " +AgeisVisible.getText());
        logger.info("Verfied page title");
        return productname;

        //selecting the age
        // driver.findElement(By.xpath("//div[@class=\"euro-span J11M_42\"]//following::span[text()=\"8  - 9 Y\"]")).click();
    }

    @Test(priority = 6)

    public void AddtoCart(){

        ActionUtils actionUtils = new ActionUtils(driver);
        actionUtils.ScrollDown();
        driver.findElement(By.xpath("//span[text()=\"ADD TO CART\"]/parent::div")).click();
      //  clickback(driver);
    }

    @Test(priority = 7)
    public void CartPageValidation(){
        driver.findElement(By.id("mbc")).click();
        //validate added product is present in cart page
        WebElement productnameincart = driver.findElement(By.xpath("//div[contains(@class,'product_info')]/child::div/div[1]"));
        System.out.println(productnameincart.getText());
//      Assert.assertEquals(productnameincart,expectedProductName,"Product names do not match");
    }
}