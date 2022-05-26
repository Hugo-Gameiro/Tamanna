package pages.body.ShoppingBagPage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BasePage;

public class ShoppingBagPage extends BasePage {

    private final String SELECTED_ITEMS_XPATH = "//h3[contains(text(),'item')]";
    private final String SELECTED_TOTAL_AMOUNT_XPATH = "//p[contains(text(),'Total')]//following-sibling::p";
    private final String PRODUCT_BIN_BUTTON_XPATH =
            "//button[contains(translate(@aria-label, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),"
                    + "'delete')]";

    /**
     * Asserts number of selected products comparing with the number of items selected until we enter the shopping bac
     */
    public void validateNumberOfSelectedProducts() {
        WebElement selectedItems = webElementHelper.getWebElementByXpath(SELECTED_ITEMS_XPATH);
        Assert.assertEquals(Integer.parseInt(selectedItems.getText().substring(0, 1)), getCartItems());
    }

    /**
     * Asserts Total Amount comparing with the sum amount selected until we enter the shopping bag
     */
    public void validateTotalAmountOfSelectedProducts() {
        WebElement selectedTotalAmount = webElementHelper.getWebElementByXpath(SELECTED_TOTAL_AMOUNT_XPATH);
        String selectedAmount = selectedTotalAmount.getText().substring(4);
        Assert.assertEquals(getCartTotalAmount(),
                Integer.parseInt(selectedAmount.replace(".", "")));
    }

    /**
     * Removes all products from the shopping bag validating number of products and total amount registered after
     * removing products
     * @throws InterruptedException
     */
    public void removeAllProducts() throws InterruptedException {

        for (int i = getCartItems() - 1; i >= 0; i--) {
                webElementHelper.waitUntilElementIsPresent(PRODUCT_BIN_BUTTON_XPATH);
                WebElement selectedItems = webElementHelper.getWebElementByXpath(PRODUCT_BIN_BUTTON_XPATH);
                webElementHelper.waitUntilElementIsClickable(selectedItems);
                selectedItems.click();
                Thread.sleep(2000);
        }

        //Asserts there's no selected item
        WebElement selectedItems = webElementHelper.getWebElementByXpath(SELECTED_ITEMS_XPATH);
        Assert.assertEquals(Integer.parseInt(selectedItems.getText().substring(0, 1)), 0);

        //Asserts total amount is 0
        WebElement selectedTotalAmount = webElementHelper.getWebElementByXpath(SELECTED_TOTAL_AMOUNT_XPATH);
        String selectedAmount = selectedTotalAmount.getText().substring(4);
        Assert.assertEquals((Integer.parseInt(selectedAmount.replace(".", ""))), 0);
    }
}
