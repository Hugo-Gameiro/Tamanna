package pages.header;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class Header extends BasePage {

    //Locators
    private final String MENU_CATEGORY_XPATH = String
            .format("//header//nav//div[1]//a[starts-with(%s", TRANSLATE_FUNCTION).concat(",'%s')]");

    private final String SUB_MENU_CATEGORY_XPATH = String
            .format("//header//nav//div[2]//a[starts-with(%s", TRANSLATE_FUNCTION).concat(",'%s')]");

    private final String CLOSE_SUCCESS_MESSAGE_XPATH =
            String.format(P_ELEMENT_CONTAINS_TEXT_XPATH, ADD_TO_CART_SUCCESS_MESSAGE_TEXT)
                    .concat("/../../following-sibling::span");

    private final String SHOPPING_BAG_HEADER_BUTTON_XPATH =
            "//button[contains(translate(@aria-label, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')," +
                    "'shoppingbag')]";

    //Actions
    /**
     * Selects Category Menu option from header, throws a NoSuchElementException in case the option is not defined
     * in the method
     *
     * @param p_categoryMenu - category menu option
     * @throws InterruptedException
     */
    public void selectCategoryMenu(String p_categoryMenu) {
        WebElement element;

        switch (p_categoryMenu.toLowerCase()) {
            case "women":
            case "men":
            case "kids":
            case "beauty":
            case "home":
            case "harvey nichols":
                String elementXPath = String.format(MENU_CATEGORY_XPATH, p_categoryMenu.toLowerCase());
                webElementHelper.waitUntilElementIsPresent(elementXPath);
                element = webElementHelper.getWebElementByXpath(elementXPath);
                break;
            default:
                throw new NoSuchElementException("There is no " + p_categoryMenu + " defined in selectCategoryMenu()");
        }
        webElementHelper.waitUntilElementIsClickable(element);
        element.click();
    }

    /**
     * Selects Sub Category Menu option from header, throws a NoSuchElementException in case the option is not defined
     * in the method
     *
     * @param p_subCategoryMenu - sub category menu option
     * @throws InterruptedException
     */
    public void selectSubCategoryMenu(String p_subCategoryMenu) throws InterruptedException {
        WebElement element;
        switch (p_subCategoryMenu.toLowerCase()) {
            case "new arrivals":
            case "clothing":
            case "shoes":
            case "beauty":
            case "brands":
            case "sale":
            case "care":
            case "babies":
            case "girls":
            case "boys":
            case "vavavoom":
            case "beauty accessories":
            case "women":
                String elementXPath = String.format(SUB_MENU_CATEGORY_XPATH, p_subCategoryMenu.toLowerCase());
                webElementHelper.waitUntilElementIsPresent(elementXPath);
                element = webElementHelper.getWebElementByXpath(elementXPath);
                break;
            default:
                throw new NoSuchElementException("There is no " + p_subCategoryMenu + " menu defined in " +
                        "CategoryEnum");
        }
        webElementHelper.waitUntilElementIsClickable(element);
        element.click();

        //For demonstration purposes I decided to keep this Thread.sleep since the next method waits for a carousel
        //to be present that exists in both overview and sub-menu.
        //Would have to analyze better how to identify the difference of pages after choosing the sub-menu.
        //Working with the team I would have asked for some clarification about this behavior to identify a WebElement
        //that would be rendered after the page changes.
        Thread.sleep(5000);
    }

    /**
     * Closes success pop-up notification
     */
    public void closeSuccessNotification() {
                webElementHelper.specialClick(CLOSE_SUCCESS_MESSAGE_XPATH);
    }

    /**
     * Selects shopping bag button
     */
    public void selectShoppingBagButton() {
        webElementHelper.getWebElementByXpath(SHOPPING_BAG_HEADER_BUTTON_XPATH).click();
    }
}
