package stepDefs;

import Pages.HRHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.Configuration;
import utilities.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HRSteps {

    HRHomePage hrHomePage = new HRHomePage();

    List<String> uiNames = new ArrayList<>();
    List<String> dbNames = new ArrayList<>();

    public HRSteps() throws InterruptedException{

    }

    @Given("^User goes to HR homepage$")
    public void user_goes_to_HR_homepage() throws Throwable {
        Driver.driver.get(Configuration.getProperties("HRProjectUrl"));
    }

    @When("^User gets first and last names of the employees from homepage$")
    public void user_gets_first_and_last_names_of_the_employees_from_homepage() throws Throwable {

    }

    @When("^User counts the number of the employees from the homepage$")
    public void user_counts_the_number_of_the_employees_from_the_homepage() throws Throwable {

    }

    @When("^User gets first and last names from database and counts$")
    public void user_gets_first_and_last_names_from_database_and_counts() throws Throwable {

    }

    @When("^User compares the both data$")
    public void user_compares_the_both_data() throws Throwable {

    }

    @Then("^User updates the excel file for documentation$")
    public void user_updates_the_excel_file_for_documentation() throws Throwable {

    }
}