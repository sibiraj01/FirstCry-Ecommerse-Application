package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {
    private WebDriver driver;
    private Actions actions;

    // Constructor to initialize Actions with the passed WebDriver
    public ActionUtils(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void ScrollDown(){
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    public void ScrollUp(){
        actions.sendKeys(Keys.PAGE_UP).perform();
    }
    public void MouseOver(WebElement element){
        actions.moveToElement(element).perform();
    }
    public void DragAndDrop(WebElement source, WebElement target){
        actions.dragAndDrop(source, target).perform();
    }

}
