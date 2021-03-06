package handlers;

import helpers.EnumHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigFileReaderHandler {

    private Properties properties;
    private final String propertyFilePath = "./src/test/resources/configs/Configuration.properties";

    public ConfigFileReaderHandler(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the " +
                    "Key:driverPath");
    }

    public Duration getDefaultWait() {
        String defaultWait = properties.getProperty("defaultWait");
        if (defaultWait != null) {
            try {
                return Duration.ofSeconds(Integer.parseInt(defaultWait));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + defaultWait + " in to Long");
            }
        }
        return Duration.ofSeconds(30);
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the " +
                    "Key:url");
    }

    public EnumHelper.DriverTypeEnum getBrowser() {

        String browserName = properties.getProperty("browser").toLowerCase();

        if (browserName.equals(""))
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not present for the " +
                    "Key \"browser\"");

        switch (browserName){
            case "chrome":
                return EnumHelper.DriverTypeEnum.CHROME;
            case "internetexplorer":
                return EnumHelper.DriverTypeEnum.INTERNETEXPLORER;
            case "firefox":
                return EnumHelper.DriverTypeEnum.FIREFOX;
            default:
                throw new RuntimeException("Browser in Configuration.properties "+ browserName + " is not a " +
                        "supported browser");
        }
    }

}
