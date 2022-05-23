package stepDefinition;

import helpers.NavigationHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageSteps {

    private NavigationHelper navigationHelper = new NavigationHelper();

    @Given("access to homepage")
    public void access_to_homepage() throws InterruptedException {
        navigationHelper.navigateToURL();
    }


    @When("introduce the {string} and {string}")
    public void introduce_the_username_and_password(String p_username, String p_password) {

    }


    @When("I select the {string} button")
    public void i_select_the_button(String p_button) {

    }

    @Then("I verify that I am at {string} according to {string} message")
    public void i_verify_that_i_am_at_page_according_to_message_success(String p_page, String p_success) {

    }
}
