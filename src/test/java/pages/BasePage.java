package pages;

import helpers.NavigationHelper;
import helpers.WebElementHelper;
import managers.WebDriverManager;
import org.testng.Assert;

public class BasePage {

    protected WebDriverManager webDriverManager = new WebDriverManager();
    protected NavigationHelper navigationHelper = new NavigationHelper();
    protected WebElementHelper webElementHelper = new WebElementHelper();
    private static int cartTotalAmountCounter = 0 ;
    private static int cartItemsCounter = 0;

    protected final String TRANSLATE_FUNCTION =
            "translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')";

    protected final String PRODUCT_PRICE_CURRENCY = "KWD";
    protected String ADD_TO_CART_SUCCESS_MESSAGE_TEXT = "added to your shopping bag!";

    //Common locators
    protected final String CLICK_BUTTON_BY_NAME_XPATH =
            String.format("//button[contains(%s", TRANSLATE_FUNCTION).concat(",'%s')]");

    protected final String P_ELEMENT_CONTAINS_TEXT_XPATH =
            String.format("//p[contains(%s", TRANSLATE_FUNCTION).concat(",'%s')]");

    protected final String ORDER_QUANTITY_SELECTOR_XPATH =
            "//select[@data-testid='quantity-selector' and @name='quantity']";

    /**
     * Navigates back to previous page
     * @param p_page
     */
    public void navigateBack(String p_page) {
        webDriverManager.getDriver().navigate().back();
    }

    /**
     * Assert current page contains a given text in Title
     * @param p_page
     */
    public void assertCurrentPage(String p_page) {
        Assert.assertTrue(webDriverManager.getDriver().getTitle().toLowerCase().contains(p_page.toLowerCase()));
    }

    //Common properties getters and setters
    protected void setCartItems(String p_numberOfItems) {
        cartItemsCounter += Integer.parseInt(p_numberOfItems);
    }

    protected void setTotalAmountCounter(String p_productPrice, String p_numberOfItems) {
        cartTotalAmountCounter += (Integer.parseInt(p_productPrice.replace(".",""))
                * Integer.parseInt(p_numberOfItems));
    }

    protected int getCartItems() {
        return cartItemsCounter;
    }

    protected int getCartTotalAmount() {return cartTotalAmountCounter;
    }


}
