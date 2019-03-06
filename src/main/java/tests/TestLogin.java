package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import pagefactories.Login;
import util.ConfigProperties;
import util.RunEnvironment;
import util.Utils;

import java.util.Properties;

public class TestLogin {

    protected Login login;
    protected WebDriver driver;
    protected static ConfigProperties configProperties;

    @BeforeAll
    public static void registerUser() {
        //Read the user's properties from file
        configProperties = new ConfigProperties();
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
        login.login();
    }


    @AfterEach
    public void tearDown() {
        //Utils.tearDown();
    }
}
