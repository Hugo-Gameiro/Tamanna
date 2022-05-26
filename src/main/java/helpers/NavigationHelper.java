package helpers;

import helpers.EnumHelper.PageEnum;
import managers.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

    public WebDriverManager webDriverManager = new WebDriverManager();
    private WebDriver driver;
    private String url;

    //Pages url
    private String HOMEPAGE_URL = webDriverManager.getApplicationUrl();

    /**
     * Navigates WebBrowser to a given page
     * @param p_pageEnum - WebPage available in Enum
     */
    public void navigateToPage(PageEnum p_pageEnum){

        switch (p_pageEnum){
            case HOMEPAGE:
                url = HOMEPAGE_URL;
                break;
            default:
                throw new NoSuchElementException("There is no " + p_pageEnum.toString() + " Page defined in PageEnum");
        }

        driver = webDriverManager.getDriver();
        driver.get(url);
    }

    /**
     * Executes a click on browser's back button
     */
    public void backWebBrowserNavigation(){
        webDriverManager.getDriver().navigate().back();
    }
}
