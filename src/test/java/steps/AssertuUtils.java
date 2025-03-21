package steps;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertuUtils {
    public static void assertElementIsDisplayed(WebElement element, String message) {
        Assert.assertTrue(element.isDisplayed(), message);
    }
}

