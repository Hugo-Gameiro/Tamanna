package helpers;

import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

    public WebDriverManager webDriverManager = new WebDriverManager();
    private WebDriver driver;

    public void navigateToURL(){
        driver = webDriverManager.getDriver();
        driver.get(webDriverManager.getApplicationUrl());
    }
}
