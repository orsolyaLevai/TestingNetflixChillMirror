package pagefactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigProperties;

public class Login {

    @FindBy(id = "username-login")
    protected WebElement loginUserName;

    @FindBy(id = "password-login")
    protected WebElement loginPassword;

    @FindBy(xpath = "//button[@type='submit' and contains(., 'Login')]")
    protected WebElement loginButton;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigProperties configProperties;
    protected Navbar navbar;
    protected final static String webAddress = "http://localhost:4200/";

    public Login(WebDriver driver) {
        this.configProperties = new ConfigProperties();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        navbar = new Navbar(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        driver.get(webAddress);
        navbar.clickLoginInTheHeader();
    }

    public void fillUserName(String userName) {
        loginUserName.sendKeys(userName);
        wait.until(ExpectedConditions.textToBePresentInElementValue(loginUserName, loginUserName.getText()));
    }

    public void fillPassword(String password) {
        loginPassword.sendKeys(password);
        wait.until(ExpectedConditions.textToBePresentInElementValue(loginPassword, loginPassword.getText()));
    }

    public void clickOnLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    public boolean isLoginButtonDisplayedOnTheForm() {
        return navbar.isLogoutButtonAvailableInTheHeader();
    }

}
