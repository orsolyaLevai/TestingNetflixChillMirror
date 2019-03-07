package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pagefactories.*;
import util.ConfigProperties;
import util.RunEnvironment;
import util.Utils;

public class TestMyPage {
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
    public void beforeEach(){
        login.login();
    }
    
    @Test
    public void addToFavourites(){
        Navbar navBar = new Navbar();
        navBar.search("steven universe");
        SearchResults searchResults = new SearchResults();
        searchResults.clickOnTitle("steven universe");
        ShowDetails showDetails = new ShowDetails();
        showDetails.addToFavorites();
        MyPage myPage = new MyPage();
        myPage.goToFavorites();
    }

}
