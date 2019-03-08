package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import pagefactories.*;
import util.ConfigProperties;
import util.Keywords;
import util.RunEnvironment;
import util.Utils;

import java.util.List;

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

    @AfterEach
    public void afterEach(){
        driver
    }
    
    @Test
    public void addToFavourites(){
        Navbar navBar = new Navbar();
        navBar.search("Steven Universe").clickOnTitle("Steven Universe").addToFavorites();
        List<String> titles = navBar.goToMyPage().goToFavorites().getFavoriteTitles();
        assertTrue(titles.contains("Steven Universe"));
    }

    @Test
    public void addToWatched(){
        Navbar navBar = new Navbar();
        navBar.search("Steven Universe").clickOnTitle("Steven Universe").addToMyShows();
        List<String> titles = navBar.goToMyPage().goToMyShows().getWatchedTitles();
        titles.forEach((e) -> System.out.println(e));
        assertTrue(titles.contains("Steven Universe"));
    }

}
