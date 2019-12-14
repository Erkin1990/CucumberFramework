package stepDefs;

import cucumber.api.java.cs.A;
import utilities.Configuration;
import utilities.Driver;
import Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;




public class VerifyLoginFunctionality {

    LoginPage loginPage = new LoginPage();

    @Given("^Navigate to log in page$")
    public void navigate_to_log_in_page() throws Throwable{
        Driver.driver.get(Configuration.getProperties("browserURL"));
        Thread.sleep(3000);
    }

    @Then("^User logs in with valid credentials username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_valid_credentials_username_password(String username, String password) throws Throwable{
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("^Verify user is in Homepage$")
    public void verify_user_is_in_Homepage(){
        String actualTitle = Driver.driver.getTitle();
        String expectedTitle = "Web Orders";

        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @Then("^User logs in with invalid credentials username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_invalid_credentials_username_password(String username, String password) throws Throwable {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("^Verify user gets error message \"([^\"]*)\"$")
    public void verify_user_gets_error_message(String errorMessage) throws Throwable {
        String actualResult = loginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage,actualResult);



    }

}
