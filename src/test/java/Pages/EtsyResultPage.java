package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
;
import java.util.List;

public class EtsyResultPage {
    WebDriver driver;
    public  EtsyResultPage(){
        this.driver= Driver.driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h1[@class='display-inline strong wt-text-caption']")
            public WebElement searchMessage;

    @FindBy(xpath="//*[@id=\"search-filter-reset-form\"]/fieldset[2]/div/div[1]/div/a/label")
    public WebElement freeShippingCheckBox;

    @FindBy(xpath="//span[@class='text-body-smaller no-wrap']")
    public List<WebElement> freeShippingLabels;

    @FindBy(xpath = "//input[@aria-label='Over $1,000']")
    public WebElement over1000CheckBox;

    @FindBy(xpath = "//ul[@class='responsive-listing-grid we-grid wt-grid-block justify-content-flex-start pl-xs-0']")
    public List<WebElement> resultPrice;
}
