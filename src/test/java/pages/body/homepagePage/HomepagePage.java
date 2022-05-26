package pages.body.homepagePage;

import helpers.ConvertToEnum;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.BasePage;

import java.util.List;

public class HomepagePage extends BasePage {


    private ConvertToEnum page = new ConvertToEnum();
    private final String PRODUCTS_LIST_XPATH = "//button[@aria-label='Wishlist']//..//following-sibling::a";
    private final String BUTTON_CONTAINS_NAME = "//button[contains(text(),'%s')]";
    private final String PARTIAL_WEB_LINK = "tamanna.com";
    /**
     * Navigates WebBrowser to a page url
     * @param p_page - Page name
     */
    public void navigateToPage(String p_page) {
        navigationHelper.navigateToPage(page.convertToPageEnum(p_page));
    }

    /**
     * Selects a product at Nth position given by user perspective. To get the element from a list we must subtract 1
     * @param p_position - position base on user perspective
     */
    public void selectItemByPositionInListOfProducts(int p_position) {

        webElementHelper.waitUntilElementIsPresent(PRODUCTS_LIST_XPATH);
        List<WebElement> webElements = webElementHelper.getWebElementsListByXPath(PRODUCTS_LIST_XPATH);

        if(webElements.size() == 0){
            throw new NoSuchElementException("There are no elements in New In");
        }

        WebElement element = webElementHelper.getElementFromList(webElements, p_position - 1);
        webElementHelper.waitUntilElementIsClickable(element);
        element.click();
    }

    /**
     * Adds selected products to cart has stores the total amount and selected items so far, after adding
     * successful message
     * @param p_numberOfItems - number of items selected
     * @param p_button - button name to click
     */
    public void addProductToCart(String p_numberOfItems, String p_button) {
        String productPrice;

        String addToCartLocator = String.format(String.format(CLICK_BUTTON_BY_NAME_XPATH, p_button.toLowerCase()));
        webElementHelper.waitUntilElementIsPresent(addToCartLocator);

        //select quantity
        WebElement selectQuantity = webElementHelper.getWebElementByXpath(ORDER_QUANTITY_SELECTOR_XPATH);
        webElementHelper.waitUntilElementIsClickable(selectQuantity);
        Select quantitySelector = webElementHelper.getSelectorByXpath(selectQuantity);
        quantitySelector.selectByValue(p_numberOfItems);

        //gets product price
        String priceLocator = String.format(P_ELEMENT_CONTAINS_TEXT_XPATH, PRODUCT_PRICE_CURRENCY.toLowerCase());
        WebElement price = webElementHelper.getWebElementByXpath(priceLocator);
        productPrice = price.getText().substring(4);

        //select addToCart
        webElementHelper.waitUntilElementIsPresent(addToCartLocator);
        WebElement button = webElementHelper.getWebElementByXpath(addToCartLocator);
        webElementHelper.waitUntilElementIsClickable(button);
        button.click();

        //Assert success message
        String cartSuccessMessageLocator =
                String.format(P_ELEMENT_CONTAINS_TEXT_XPATH, ADD_TO_CART_SUCCESS_MESSAGE_TEXT);
        webElementHelper.waitUntilElementIsPresent(cartSuccessMessageLocator);

        //Add purchase data
        setCartItems(p_numberOfItems);
        setTotalAmountCounter(productPrice,p_numberOfItems);
    }

    /**
     * Selects a button by case sensitive button text
     * @param p_buttonText - button text
     */
    public void selectButton(String p_buttonText){
        webElementHelper.waitUntilElementIsPresent(String.format(BUTTON_CONTAINS_NAME, p_buttonText));
        WebElement button = webElementHelper.
                getWebElementByXpath(String.format(BUTTON_CONTAINS_NAME, p_buttonText));
        webElementHelper.waitUntilElementIsClickable(button);
        button.click();
    }

    public void validateCurrentPage() {
        webElementHelper.waitUntilElementIsPresent(PRODUCTS_LIST_XPATH);
        String currentUrl = webDriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(PARTIAL_WEB_LINK));
    }
}
