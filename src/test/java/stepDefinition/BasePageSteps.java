package stepDefinition;

import io.cucumber.java.en.Then;
import pages.BasePage;

public class BasePageSteps {

    private BasePage basePage = new BasePage();

    @Then("I access back to {string} page")
    public void iAccessBackToPage(String p_page) {
        basePage.navigateBack(p_page);
    }
}
