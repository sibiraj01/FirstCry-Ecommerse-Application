package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShotsUtils {
    public static void takeScreenShot(WebDriver driver) throws IOException {
    // Cast the WebDriver instance to TakesScreenshot interface to access screenshot capabilities
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    // Define the destination file path where the screenshot will be saved
        File Destination = new File("./ScreenShot/Homepage.png");
        FileHandler.copy(screenshot,Destination);
    }
}
