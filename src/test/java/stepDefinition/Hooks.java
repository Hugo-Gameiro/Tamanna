package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.WebDriverManager;

public class Hooks {

    WebDriverManager webDriverManager = new WebDriverManager();

    @Before
    public void setUp() {
        //creates a driver if there is non
        webDriverManager.getDriver();
        //TODO: substitute for a explicit method according to ExpectedConditions
        webDriverManager.setImplicitlyWait();
        webDriverManager.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        webDriverManager.quitDriver();
    }
}