package stepDefinition;

import helpers.NavigationHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.body.homepagePage.HomepagePage;
import pages.header.Header;

public class HomepageSteps {

    private NavigationHelper navigationHelper = new NavigationHelper();
    private Header header = new Header();
    private HomepagePage homepagePage = new HomepagePage();

    @Given("I access {string} page")
    public void iAccessesPage(String p_page) {
        homepagePage.navigateToPage(p_page);
    }

    @And("I select the item at position {int} in list of products")
    public void iSelectTheItemAtPositionInListOfProducts(int p_position)  {
        homepagePage.selectItemByPositionInListOfProducts(p_position);
    }

    @And("I add {string} product to cart by pressing button {string}")
    public void iAddProductToCartByPressingButton(String p_numberOfItems, String p_button) {
        homepagePage.addProductToCart(p_numberOfItems, p_button);
    }

    @And("I click {string}")
    public void iClick(String p_goToShoppingBagButton) {
        homepagePage.selectButton(p_goToShoppingBagButton);
    }

    @And("I validate that I am at at the website homepage")
    public void iValidateThatIAmAtAtTheWebsiteHomepage() {
        homepagePage.validateCurrentPage();
    }
}