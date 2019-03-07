package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pagefactories.Login;
import pagefactories.Navbar;
import util.ConfigProperties;
import util.RunEnvironment;
import util.Utils;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    protected static Login login;
    protected static WebDriver driver;
    protected static ConfigProperties configProperties;

    @BeforeAll
    public static void setupAll() {
        Utils.setup();
        driver = RunEnvironment.getWebDriver();
        login = new Login(driver);
        driver.manage().window().maximize();
        configProperties = new ConfigProperties();

        /*Registration registration = new Registration(driver);

        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();
        String email = configProperties.getEmail();

        registration.fillUserNameField(userName);
        registration.fillPasswordField(password);
        registration.fillConfirmPasswordField(password);
        registration.fillEmailField(email);

        registration.clickOnJoinButton();*/
    }

    @Test
    public void testLoginWithValidCredentials() {
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();
        Navbar navbar = new Navbar(driver);

        login.goToLoginPage();
        login.fillUserName(userName);
        login.fillPassword(password);

        login.clickOnLoginButton();

        assertTrue(navbar.isLogoutButtonAvailableInTheHeader(),
                "Login: something went wrong with login. Please check the credentials!");
        navbar.clickLogoutInHeader();
    }

    @Test
    void testLoginWithEmptyAndInvalidCredentials() {
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();
        String unregisteredUsername = "Tesla";
        String invalidPassword = "Tesla";
        Navbar navbar = new Navbar(driver);

        /*** Test for empty fields ***/
        login.goToLoginPage();
        login.fillUserName("");
        login.fillPassword("");
        assertFalse(login.isLoginButtonDisplayedOnTheForm(),
                "Login: something went wrong with login. Please check the credentials!");

        /*** Test for unregistered username ***/
        login.goToLoginPage();
        login.fillUserName(unregisteredUsername);
        login.fillPassword(password);
        login.clickOnLoginButton();
        assertFalse(navbar.isLogoutButtonAvailableInTheHeader(),
                "Login: something went wrong with login. Please check the credentials!");

        /*** Test for invalid password ***/
        login.goToLoginPage();
        login.fillUserName(userName);
        login.fillPassword(invalidPassword);
        login.clickOnLoginButton();
        assertFalse(navbar.isLogoutButtonAvailableInTheHeader(),
                "Login: something went wrong with login. Please check the credentials!");
    }

    @AfterAll
    public static void tearDownAll() {
        Utils.tearDown();
    }
}
