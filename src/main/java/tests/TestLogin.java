package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pagefactories.LoginPage;
import pagefactories.Navbar;
import util.ConfigProperties;
import util.RunEnvironment;
import util.Utils;

import static org.junit.jupiter.api.Assertions.*;

public class TestLogin {

    protected static LoginPage login;
    protected static WebDriver driver;
    protected static ConfigProperties configProperties;

    @BeforeAll
    public static void setupAll() {
        //Read the user's properties from file
        //TODO: if user not exist register it

        Utils.setup();
        driver = RunEnvironment.getWebDriver();
        login = new LoginPage();
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

    @BeforeEach
    public void setup() {
        //Utils.setup();
        //driver = RunEnvironment.getWebDriver();


    }


    @Test
    public void testLoginWithValidCredentials() {
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();
        Navbar navbar = new Navbar();

        login.goToLoginPage();
        login.fillUserName(userName);
        login.fillPassword(password);

        login.clickOnLoginButton();

        assertTrue(navbar.isLogoutButtonAvailableInTheHeader(),
                "LoginPage: something went wrong with login. Please check the credentials!");
        navbar.clickLogoutInHeader();
    }

    @Test
    void testLoginWithEmptyAndInvalidCredentials() {
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();
        String unregisteredUsername = "Tesla";
        String invalidPassword = "Tesla";
        Navbar navbar = new Navbar();

        /*** Test for empty fields ***/
        login.goToLoginPage();
        login.fillUserName("");
        login.fillPassword("");
        assertFalse(login.isLoginButtonDisplayedOnTheForm(),
                "LoginPage: something went wrong with login. Please check the credentials!");

        /*** Test for unregistered username ***/
        login.goToLoginPage();
        login.fillUserName(unregisteredUsername);
        login.fillPassword(password);
        login.clickOnLoginButton();
        assertFalse(navbar.isLogoutButtonAvailableInTheHeader(),
                "LoginPage: something went wrong with login. Please check the credentials!");

        /*** Test for invalid password ***/
        login.goToLoginPage();
        login.fillUserName(userName);
        login.fillPassword(invalidPassword);
        login.clickOnLoginButton();
        assertFalse(navbar.isLogoutButtonAvailableInTheHeader(),
                "LoginPage: something went wrong with login. Please check the credentials!");

    }

    @AfterEach
    public void tearDown() {
        //Utils.tearDown();
    }

    @AfterAll
    public static void tearDownAll() {
        Utils.tearDown();
        //driver.close();
    }

}
