package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pagefactories.Login;
import util.ConfigProperties;
import util.RunEnvironment;
import util.Utils;

public class testAddFavourites {
    private static Login login;
    private static WebDriver driver;
    private static ConfigProperties configProperties;

    @BeforeAll
    public static void registerUser() {
        //Read the user's properties from file
        configProperties = new ConfigProperties();
        Utils.setup();
        driver = RunEnvironment.getWebDriver();
        login = new Login(driver);
        driver.manage().window().maximize();
    }

    @BeforeEach
    public static void beforeEach(){
        login.login();
    }
    
    @Test
    public void addFavourites(){
        
    }

}
