package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    // driver, element
    // this method will get hover over the WebElement
    // You need to pass the elements and driver

    public static void hover(WebElement element, WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    // this method will get the text of the WebElement and return String. You need to pass the elements

    public static String getText(WebElement element) {
        return element.getText();
    }
    // This method will take the list of WEbElements it will return lise of text from the WebElements

    public static List<String> getElementsText(List<WebElement> elements) {
        List<String> textList = new ArrayList();
        for (WebElement el : elements) {
            if (!el.getText().isEmpty()) {
                textList.add(el.getText());
            }
        }
        return textList;
    }

    public static void visibilityOfElement(WebDriver driver, WebElement element, int time) {
        // WebDriver is coming from Driver class, WbElement will come from page class, then you provide the time

        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void switchWindow(String targetTitle, WebDriver driver) {

        String origin = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String windows : allWindows) {
            driver.switchTo().window(windows);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
            }
            driver.switchTo().window(origin);
        }
    }

        // clickable, isAlertPresent, DragAndDrop, rightClick -- > homework
