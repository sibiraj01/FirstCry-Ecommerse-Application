package SeleniumPrac1;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.WeakHashMap;

public class Pract {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://letcode.in/frame");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.switchTo().frame(0);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fname")));

            element.sendKeys("sibiraj");
        }catch (TimeoutException e){
            System.out.println("Element not found");
        }
        System.out.println("Implemented try catch block");
      //  driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("sibiraj");
        driver.switchTo().frame(1);
        WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        element2.sendKeys("sibiraj@gmail.com");


       driver.switchTo().parentFrame();
       driver.findElement(By.name("lname")).sendKeys("testdata");


    }
}
