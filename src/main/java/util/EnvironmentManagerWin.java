package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnvironmentManagerWin {
    private static WebDriver driver;
    private static ConfigProperties configProperties;


    public static void initChromeWebDriver() {
        configProperties = new ConfigProperties();

        System.setProperty("webdriver.chrome.driver", configProperties.getDriverPath());
        driver = new ChromeDriver();

        RunEnvironment.setWebDriver(driver);
    }

    public static void initFireFoxWebDriver() {
        System.setProperty("webdriver.gecko.driver", configProperties.getDriverPath() );
        driver = new FirefoxDriver();

        RunEnvironment.setWebDriver(driver);
    }

    public static void shutDownDriver() {
        if(driver!=null) {
            RunEnvironment.getWebDriver().quit();
            System.out.println("Closing browser");
        }

    }
}
