package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnvironmentManagerMac {

    private static WebDriver driver;
    private static ConfigProperties configProperties;


    public static void initChromeWebDriver() {
        configProperties = new ConfigProperties();

            //String driverPath = configProperties.getDriverPath();
            driver = new ChromeDriver();
            //System.setProperty("webdriver.chrome.driver", driverPath);
            RunEnvironment.setWebDriver(driver);
    }

    public static void initFireFoxWebDriver() {
        System.setProperty("webdriver.gecko.driver", configProperties.getDriverPath());
        driver = new FirefoxDriver();

        RunEnvironment.setWebDriver(driver);
    }

    public static void shutDownDriver() {
        if(driver != null) {
            RunEnvironment.getWebDriver().close();
            System.out.println("Closing browser");
        }

    }
}
