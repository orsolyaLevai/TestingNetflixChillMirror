package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pagefactories.*;
import util.ConfigProperties;
import util.Keywords;
import util.RunEnvironment;
import util.Utils;

public class TestMyPage {
    private static LoginPage login;
    private static WebDriver driver;
    private static ConfigProperties configProperties;

    @BeforeAll
    public static void registerUser() {
        //Read the user's properties from file
        configProperties = new ConfigProperties();
        Utils.setup();
        driver = RunEnvironment.getWebDriver();
        login = new LoginPage();
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void beforeEach(){
        Keywords.login();
    }
    
    @Test
    public void addToFavourites(){
        Navbar navBar = new Navbar();
        navBar.search("steven universe").clickOnTitle("steven universe").addToFavorites();
        navBar.goToMyPage().goToFavorites();
    }

}
