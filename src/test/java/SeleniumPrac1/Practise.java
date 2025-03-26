package SeleniumPrac1;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import steps.ActionUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Practise {
    public static void main(String[] args) throws IOException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.firstcry.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        File screenshot= driver.getScreenshotAs(OutputType.FILE);
        File Destination = new File("./ScreenShot/google.png");
        FileHandler.copy(screenshot,Destination);
        ActionUtils utils = new ActionUtils(driver);
        utils.MouseOver(driver.findElement(By.xpath("//a[text()=' All Categories']")));

        List<WebElement> AllCategories = driver.findElements(By.xpath("//a"));

        for (WebElement element : AllCategories) {
            System.out.println(element.getText());
        }
    }
}
