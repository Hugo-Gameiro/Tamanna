package managers;

import handlers.ConfigFileReaderHandler;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebDriverManager {

    static ConfigFileReaderHandler configFileReaderHandler;

    public WebDriverManager() {
        this.configFileReaderHandler = new ConfigFileReaderHandler();
    }

    /**
     * Gets a valid WebDriver from SingletonWebDriver
     * @return - WebDriver
     */
    public WebDriver getDriver(){
        return SingletonWebDriver.getInstanceOfSingletonWebDriverManager().getDriver();
    }

    /**
     * Gets Default Wait from Configuration Handler
     * @return - Duration in seconds
     */
    public Duration getWaitingTime() {
        return configFileReaderHandler.getDefaultWait();
    }

    /**
     * Gets homepage URL from ConfigFileReader
     * @return - String URL
     */
    public String getApplicationUrl() {
        return configFileReaderHandler.getApplicationUrl();
    }

    /**
     * Closes and quit current driver
     */
    public void quitDriver() {
        getDriver().close();
        getDriver().quit();
    }
}
