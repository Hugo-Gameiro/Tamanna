package managers;

import handlers.ConfigFileReaderHandler;
import helpers.EnumHelper.DriverTypeEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SingletonWebDriver {

    private static SingletonWebDriver instanceOfSingletonWebDriver = null;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static ConfigFileReaderHandler configFileReaderHandler = new ConfigFileReaderHandler();
    private DriverTypeEnum driverTypeEnum;
    private WebDriver driver;
    
    
    //Constructor
    private SingletonWebDriver(DriverTypeEnum driverTypeEnum) {
        this.driverTypeEnum = driverTypeEnum;
    }

    public static SingletonWebDriver getInstanceOfSingletonWebDriverManager() {
        if (instanceOfSingletonWebDriver == null) {
            instanceOfSingletonWebDriver = new SingletonWebDriver(configFileReaderHandler.getBrowser());
        }
        return instanceOfSingletonWebDriver;
    }

    /**
     * Creates and handles a driver instance either the Static SingletonWebDriver has none or if
     * after quit() the driver exists but has no valid SessionID. If the WebDriver already exists handles the driver
     * previous created
     * @return - WebDriver instance
     */
    public WebDriver getDriver() {

        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            switch (driverTypeEnum) {
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
