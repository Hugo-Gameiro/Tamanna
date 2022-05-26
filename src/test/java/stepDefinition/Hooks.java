package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.WebDriverManager;

public class Hooks {

    WebDriverManager webDriverManager = new WebDriverManager();

    /**
     * Prepares a new WebBrowser before every test case
     */
    @Before
    public void setUp() {
        webDriverManager.getDriver();
        webDriverManager.getDriver().manage().window().maximize();
    }

    /**
     * Closes and quits the browser after every test case being executed
     */
    @After
    public void tearDown() {
        webDriverManager.quitDriver();
    }
}