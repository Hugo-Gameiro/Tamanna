package managers;

import handlers.ConfigFileReaderHandler;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    static ConfigFileReaderHandler configFileReaderHandler;

    public WebDriverManager() {
        this.configFileReaderHandler = new ConfigFileReaderHandler();
    }

    public WebDriver getDriver(){
        return SingletonWebDriver.getInstanceOfSingletonWebDriverManager().getDriver();
    }

    //TODO: substitute for a explicit method according to ExpectedConditions
    public void setImplicitlyWait() {
        getDriver().manage().timeouts().implicitlyWait(configFileReaderHandler.getImplicitlyWait(), TimeUnit.SECONDS);
    }

    public String getApplicationUrl() {
        return configFileReaderHandler.getApplicationUrl();
    }

    public void quitDriver() {
        getDriver().close();
        getDriver().quit();
    }
}
