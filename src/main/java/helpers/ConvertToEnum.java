package helpers;

import helpers.EnumHelper.PageEnum;
import org.openqa.selenium.NoSuchElementException;

public class ConvertToEnum {

    private EnumHelper enumHelper = new EnumHelper();

    /**
     * Converts string into a PageEnum constant
     *
     * @param p_page - String page
     * @return - PageEnum constant
     */
    public PageEnum convertToPageEnum(String p_page) {

        switch (p_page.toLowerCase()) {
            case "homepage":
                return PageEnum.HOMEPAGE;
            default:
                throw new NoSuchElementException("There is no " + p_page.toString() + " Page defined in ConvertToEnum");
        }
    }
}
