package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HRHomePage {

    WebDriver driver;
    public HRHomePage(){
        this.driver= Driver.driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"europe-employees\"]/tbody/tr/td")
    public List<WebElement> listOfFirstLastNames;
}
