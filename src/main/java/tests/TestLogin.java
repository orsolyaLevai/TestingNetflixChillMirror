package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pagefactories.Login;
import pagefactories.Registration;
import util.ConfigProperties;
import util.RunEnvironment;
import util.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin {

    protected static Login login;
    protected static WebDriver driver;
    protected static ConfigProperties configProperties;
    protected static Registration registration;

    @BeforeAll
    public static void registerUser() {
        //Read the user's properties from file
        configProperties = new ConfigProperties();
        registration = new Registration(driver);

        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();
        String email = configProperties.getEmail();

        registration.fillUserNameField(userName);
        registration.fillPasswordField(password);
        registration.fillConfirmPasswordField(password);
        registration.fillEmailField(email);

        registration.clickOnJoinButton();
    }

    @BeforeEach
    public void setup() {
        Utils.setup();
        driver = RunEnvironment.getWebDriver();
        login = new Login(driver);
        driver.manage().window().maximize();
    }


    @Test
    public void testLoginForValidCredentials() {
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();

        login.goToLoginPage();
        login.fillUserName(userName);
        login.fillPassword(password);

        assertEquals(0, login.clickOnLoginButton(),
                    "Login: something went wrong with login. Please check the credentials!");

    }


    @AfterEach
    public void tearDown() {
        //Utils.tearDown();
    }

}
