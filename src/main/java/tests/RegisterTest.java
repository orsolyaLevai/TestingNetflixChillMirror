package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pagefactories.LoginPage;
import pagefactories.Navbar;
import pagefactories.Registration;
import util.ConfigProperties;
import util.RunEnvironment;
import util.Utils;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest {
    protected static ConfigProperties configProperties;
    protected static Registration registration;
    protected static LoginPage login;
    protected static WebDriver driver;

    @BeforeAll
    public static void setUpBeforeAll() {
        Utils.setup();
        driver = RunEnvironment.getWebDriver();
        configProperties = new ConfigProperties();
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", configProperties.getDriverPath());
        registration = new Registration(driver);
        login = new LoginPage();
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void setup() {

    }

    @Test
    public void testRegistrationWithValidCredentials() {
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();
        String email = configProperties.getEmail();
        Navbar navbar = new Navbar();

        registration.goToTheRegisterPage();

        registration.fillUserNameField(userName);
        registration.fillPasswordField(password);
        registration.fillConfirmPasswordField(password);
        registration.fillEmailField(email);

        registration.clickOnJoinButton();

        login.goToLoginPage();
        login.fillUserName(userName);
        login.fillPassword(password);

        login.clickOnLoginButton();

        assertTrue(navbar.isLogoutButtonAvailableInTheHeader(),
                "Registration: something went wrong with registration. The user cannot be found in the database! " +
                        "Check the credentials!");

        driver.navigate().refresh();
        navbar.clickLogoutInHeader();
    }

    @Test
    void testRegistrationWithEmptyCredentials() {
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();
        String email = configProperties.getEmail();

        registration.goToTheRegisterPage();

        registration.fillUserNameField("");
        assertFalse(registration.isJoinButtonAvailable());

        registration.fillUserNameField(userName);
        registration.fillPasswordField("");
        assertFalse(registration.isJoinButtonAvailable());

        registration.fillPasswordField(password);
        registration.fillConfirmPasswordField("");
        assertFalse(registration.isJoinButtonAvailable());

        registration.fillConfirmPasswordField(password);
        registration.fillEmailField("");
        assertFalse(registration.isJoinButtonAvailable());

        registration.fillEmailField(email);
        assertTrue(registration.isJoinButtonAvailable());
    }

    @Test
    void testRegistrationWithInvalidCredentials() {
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();
        String email = configProperties.getEmail();
        String invalidPassword = "Tesla";
        String invalidEmailWithDotWithoutAt = "mm.com";
        String invalidEmailWithAtWithoutDot = "m@mcom";

        registration.goToTheRegisterPage();

        registration.fillUserNameField(userName);
        registration.fillPasswordField(password);
        registration.fillConfirmPasswordField(invalidPassword);
        registration.fillEmailField(email);

        assertFalse(registration.isJoinButtonAvailable());

        registration.fillConfirmPasswordField(password);
        registration.fillPasswordField(invalidPassword);
        assertFalse(registration.isJoinButtonAvailable());

        registration.fillPasswordField(password);
        registration.fillEmailField(invalidEmailWithDotWithoutAt);
        assertFalse(registration.isJoinButtonAvailable());

        //TODO: the registration is working with m@mail
        //registration.fillEmailField(invalidEmailWithAtWithoutDot);
        //assertFalse(registration.isJoinButtonAvailable());
    }

    /*@AfterEach
    public void tearDown() {
        Utils.tearDown();
    }*/

    @AfterAll
    public static void tearDownAll() {
        Utils.tearDown();
        //driver.close();
    }
}
