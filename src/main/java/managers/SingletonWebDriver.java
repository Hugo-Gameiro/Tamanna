package managers;

import handlers.ConfigFileReaderHandler;
import helpers.EnumHelper.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SingletonWebDriver {

    private static SingletonWebDriver instanceOfSingletonWebDriver = null;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static ConfigFileReaderHandler configFileReaderHandler = new ConfigFileReaderHandler();
    private DriverType driverType;
    private WebDriver driver;
    
    
    //Constructor
    private SingletonWebDriver(DriverType driverType) {
        this.driverType = driverType;
    }

    public static SingletonWebDriver getInstanceOfSingletonWebDriverManager() {
        if (instanceOfSingletonWebDriver == null) {
            instanceOfSingletonWebDriver = new SingletonWebDriver(configFileReaderHandler.getBrowser());
        }
        return instanceOfSingletonWebDriver;
    }

    public WebDriver getDriver() {

        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            switch (driverType) {
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    System.setProperty(CHROME_DRIVER_PROPERTY, configFileReaderHandler.getDriverPath());
                    System.setProperty("webdriver.chrome.whitelistedIps", "");
                    driver = new ChromeDriver();
                    break;
                case INTERNETEXPLORER:
                    driver = new InternetExplorerDriver();
                    break;
            }
        }
        return driver;
    }
}
