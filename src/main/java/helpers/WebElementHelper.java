package helpers;

import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementHelper {

    private WebDriverManager webDriverManager = new WebDriverManager();
    WebDriverWait wait = new WebDriverWait(webDriverManager.getDriver(), webDriverManager.getWaitingTime());

    /**
     * Creates a list of every WebElement that fits criteria to the given locator
     * @param p_locator - xpath locator
     * @return - WebElements List
     */
    public List<WebElement> getWebElementsListByXPath(String p_locator){
        return webDriverManager.getDriver().findElements(By.xpath(p_locator));
    }

    /**
     * Gets an WebElement from a given WebElements list at a given position
     * @param p_list - Given WebElements list
     * @param p_position - Position of WebElement in given list
     * @return - WebElement instance
     */
    public WebElement getElementFromList(List<WebElement> p_list, int p_position){
        return p_list.get(p_position);
    }

    /**
     * Gets WebElement By xpath
     * @param p_xpath - xpath locator
     * @return - WebElement instance
     */
    public WebElement getWebElementByXpath(String p_xpath) {
        return webDriverManager.getDriver().findElement(By.xpath(p_xpath));
    }

    /**
     * Gets selector instance from select WebElement
     * @param p_element - select WebElement
     * @return - Selector instance
     */
    public Select getSelectorByXpath(WebElement p_element){
        return new Select(p_element);
    }

    /**
     * Click on a WebElement using javascript
     * @param p_xpath - xpath locator
     */
    public void specialClick(String p_xpath){
        WebElement element = webDriverManager.getDriver().findElement(By.xpath(p_xpath));
        JavascriptExecutor executor = (JavascriptExecutor)webDriverManager.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    //Waits

    /**
     * Allow driver to wait until given WebElement is present in page
     * @param p_xpath
     */
    public void waitUntilElementIsPresent(String p_xpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p_xpath)));
    }

    /**
     * Allows driver to wait until given WebElement is ready to be clickable
     * @param p_element - element to be clicked
     */
    public void waitUntilElementIsClickable(WebElement p_element){
        wait.until(ExpectedConditions.elementToBeClickable(p_element));
    }
}
