package com.nextgate.utilities;


import org.openqa.selenium.WebDriver;


public class Driver {

    private Driver() {
    }


    private static WebDriver driver;
    //1st method - creating a driver depending on the browser speciefied in config.properties

    public static WebDriver getDriver() {

        if (driver == null) {
            //we will create a new driver instance here and assing it to
            // our driver variable
            if ("firefox".equals(ConfigsReader.getProperty("browser").toLowerCase())) {
                driver = FirefoxWebDriver.loadFirefoxDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
            } else {
                driver = ChromWebDriver.ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
            }
        }

        return driver;
    }


    //This will close the driver if it is running
    public static void closeDriver() {
        if (driver == null) return;

        try {
            driver.close();
            driver.quit();
            driver = null;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
