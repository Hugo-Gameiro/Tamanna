package stepDefinition;

import helpers.NavigationHelper;
import io.cucumber.java.en.And;
import pages.BasePage;
import pages.body.ShoppingBagPage.ShoppingBagPage;
import pages.header.Header;

public class ShoppingBagSteps {

    private ShoppingBagPage shoppingBagPage = new ShoppingBagPage();

    @And("I validate the number of selected products corresponds to my previous selections")
    public void iValidateTheNumberOfSelectedProductsCorrespondsToMyPreviousSelections() {
        shoppingBagPage.validateNumberOfSelectedProducts();
    }

    @And("I validate the total amount corresponds to the sum of my previous selections")
    public void iValidateTheTotalAmountCorrespondsToTheSumOfMyPreviousSelections() {
        shoppingBagPage.validateTotalAmountOfSelectedProducts();
    }

    @And("I remove all products asserting there is no total value or items selected")
    public void iRemoveAllProductsAssertingThereIsNoTotalValueOrItemsSelected() throws InterruptedException {
        shoppingBagPage.removeAllProducts();
    }

    @And("validate that I am at {string} page")
    public void validateThatIAmAtPage(String p_page) {
        shoppingBagPage.assertCurrentPage(p_page);
    }
}
