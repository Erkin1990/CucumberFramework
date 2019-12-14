package stepDefs;

import Pages.OrdersHomePage;
import Pages.OrdersPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class AddingOrderSteps {

    OrdersHomePage ordersHomePage = new OrdersHomePage();
    OrdersPage ordersPage = new OrdersPage();
    int initialOrderCount;

    @Then("^User clicks on Order$")
    public void user_clicks_on_Order() throws Throwable {

        initialOrderCount = ordersHomePage.orderRows.size();
        ordersHomePage.OrderButton.click();

    }

    @Then("^User creates new order$")
    public void user_creates_new_order(DataTable dataTable) throws Throwable {
        List<Map<String, Object>> listOfMaps = dataTable.asMaps(String.class, Object.class);

        Select select = new Select(ordersPage.productName);
        select.selectByVisibleText(listOfMaps.get(0).get("Product Name").toString());
        ordersPage.quantity.sendKeys(listOfMaps.get(0).get("Quantity").toString());
        ordersPage.customerName.sendKeys(listOfMaps.get(0).get("Customer Name").toString());
        ordersPage.street.sendKeys(listOfMaps.get(0).get("Street").toString());
        ordersPage.city.sendKeys(listOfMaps.get(0).get("City").toString());
        ordersPage.zipCode.sendKeys(listOfMaps.get(0).get("Zip").toString());
        ordersPage.visaCardType.click();
        ordersPage.cardNr.sendKeys(listOfMaps.get(0).get("Card Nr").toString());
        ordersPage.expireDate.sendKeys(listOfMaps.get(0).get("Expire Date").toString());
        ordersPage.processButton.click();

    }
//    @Then("^User verifies Order is created$")
//    public void user_verifies_Order_is_created() throws Throwable {
//        ordersPage.ordersViewButton.click();
//        int afterOrderCreated=ordersHomePage.orderRows.size();
//        Assert.assertEquals("Initial order number is: "+initialOrderCount+
//                "\n"+"After you created order the row number is:"
//                +afterOrderCreated,initialOrderCount+1,afterOrderCreated);
//
//    }
//    @Then("^User verifies Order is created$")
//    public void User_verifies_Order_is_NOT_created() throws Throwable {
//        ordersPage.ordersViewButton.click();
//        Thread.sleep(5000);
//        int afterOrderCreated=ordersHomePage.orderRows.size();
//        Assert.assertEquals("Initial order number is: " +initialOrderCount +
//                "\n" + "After you created order the row number is:"
//                +afterOrderCreated,initialOrderCount,afterOrderCreated);
//
//
//    }

    @Then("^User verifies Order \"([^\"]*)\' created$")
    public void user_verifies_Order_created(String isCondition) throws Throwable {
        ordersPage.ordersViewButton.click();
        Thread.sleep(1000);
        int afterOrderCreated = ordersHomePage.orderRows.size();
        if (isCondition.equalsIgnoreCase("is")) {
            Assert.assertEquals(initialOrderCount + 1, afterOrderCreated);
        } else {
            Assert.assertEquals(initialOrderCount, afterOrderCreated);
        }
    }

    @Then("^User deletes \"([^\"]*)\" from table$")
    public void user_deletes_from_table(String name) throws Throwable {
        for (int i = 0; i < ordersHomePage.names.size(); i++) {
            if (ordersHomePage.names.get(i).getText().equalsIgnoreCase(name)) {
                ordersHomePage.checkBoxes.get(i).click();

            }
        }
        Thread.sleep(3000);
        ordersHomePage.deleteButton.click();
        Thread.sleep(4000);
    }

    @Then("^Validate that \"([^\"]*)\" is deleted$")
    public void validate_that_is_deleted(String name) throws Throwable {
        for(WebElement element: ordersHomePage.names){
            Assert.assertFalse(element.getText().equalsIgnoreCase(name));
        }


    }
}