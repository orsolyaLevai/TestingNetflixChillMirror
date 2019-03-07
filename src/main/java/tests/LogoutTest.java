package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pagefactories.Login;
import pagefactories.Navbar;
import pagefactories.Registration;
import util.ConfigProperties;
import util.RunEnvironment;
import util.Utils;

import static org.junit.jupiter.api.Assertions.*;

public class LogoutTest {
    protected static Login login;
    protected static WebDriver driver;
    protected static Navbar navbar;
    protected static ConfigProperties configProperties;

    @BeforeAll
    public static void setUpBeforeAll() {
        Utils.setup();
        driver = RunEnvironment.getWebDriver();
        configProperties = new ConfigProperties();
        login = new Login(driver);
        navbar = new Navbar(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogout() {
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();

        login.goToLoginPage();
        login.fillUserName(userName);
        login.fillPassword(password);
        login.clickOnLoginButton();
        assertTrue(navbar.isLogoutButtonAvailableInTheHeader(),
                "Logout: something went wrong with login.");

        navbar.clickLogoutInHeader();
        assertFalse(navbar.isLogoutButtonAvailableInTheHeader(),
                "Logout: something went wrong with logout.");

    }


    @AfterAll
    public static void tearDownAll() {
        Utils.tearDown();
    }
}
