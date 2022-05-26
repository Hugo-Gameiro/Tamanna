package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.header.Header;

public class HeaderSteps {

    private Header header = new Header();
    @When("I select the category menu {string}")
    public void iSelectTheCategoryMenu(String p_categoryMenu) {
        header.selectCategoryMenu(p_categoryMenu);
    }

    @And("I select the category sub-menu {string}")
    public void iSelectTheCategorySubMenu(String p_categorySubMenu) throws InterruptedException {
        header.selectSubCategoryMenu(p_categorySubMenu);
    }

    @And("I close the success message notification")
    public void iCloseTheSuccessMessageNotification() {
        header.closeSuccessNotification();
    }

    @And("I select the shopping bag button")
    public void iSelectTheShoppingBagButton() {
        header.selectShoppingBagButton();
    }
}
