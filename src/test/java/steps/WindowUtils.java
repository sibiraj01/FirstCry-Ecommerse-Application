package steps;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowUtils {
    public static String  SwitchToChildWindow(WebDriver driver, String parentWindow){

        Set<String> Allwindow = driver.getWindowHandles();
         for(String windowHandle: Allwindow) {
             //Switch to the new window
             if (!windowHandle.equals(parentWindow)) {
                 driver.switchTo().window(windowHandle);
                 System.out.println("Switched to child window: " + driver.getTitle());
                 return windowHandle;
             }
         }
        System.out.println("No child window found!");
        return null;
    }
    public static void switchToParentWindow(WebDriver driver, String parentWindow) {
        driver.switchTo().window(parentWindow);
        System.out.println("Switched back to parent window: " + driver.getTitle());
    }
    }
