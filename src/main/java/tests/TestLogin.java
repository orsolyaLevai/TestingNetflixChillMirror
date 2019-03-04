package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import pagefactories.Login;
import util.RunEnvironment;
import util.Utils;

public class TestLogin {

    protected Login login;
    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        Utils.setup();
        driver = RunEnvironment.getWebDriver();
        login = new Login(driver);
        driver.manage().window().maximize();
    }





    @AfterEach
    public void tearDown() {
        Utils.tearDown();
    }
}
