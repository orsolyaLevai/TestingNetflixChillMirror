package pagefactories;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigProperties;
import util.RunEnvironment;
import util.Utils;

import javax.rmi.CORBA.Util;

public class LoginPage {

    //@FindBy(linkText = "Join")
    @FindBy(css = "a[href*='/login']")
    protected WebElement loginButtonInHeader;

    @FindBy(id = "username-login")
    protected WebElement loginUserName;

    @FindBy(id = "password-login")
    protected WebElement loginPassword;

    @FindBy(xpath = "//button[@type='submit' and contains(., 'LoginPage')]")
    protected WebElement loginButton;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigProperties configProperties;
    protected Navbar navbar;
    protected String webAddress = "http://localhost:4200/";

    public LoginPage() {
        configProperties = new ConfigProperties();
        driver = RunEnvironment.getWebDriver();
        wait = new WebDriverWait(driver, 5);
        navbar = new Navbar();
        PageFactory.initElements(driver, this);
    }

    /**
     * It has the user logged and return if it was successful or not.
     * @return int
     *          -1, if there isn't any Logout button
     *          0, if Logout button exists
     */
    /*public int loginWithProperties() {
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();

        return login(userName, password);

        *//*wait.until(ExpectedConditions.elementToBeClickable(loginButtonInHeader)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginUserName));
        loginUserName.sendKeys(userName);
        wait.until(ExpectedConditions.elementToBeClickable(loginPassword));
        loginPassword.sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();

        if (wait.until(ExpectedConditions.visibilityOf(alertDialogDiv)) != null) return -1;
        else return 0;*//*
    }*/

    public void goToLoginPage() {
        driver.get(webAddress);
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonInHeader)).click();
        //navbar.clickLoginInTheHeader();
    }

    public void fillUserName(String userName) {
        //wait.until(ExpectedConditions.elementToBeClickable(loginUserName));
        loginUserName.sendKeys(userName);
        wait.until(ExpectedConditions.textToBePresentInElementValue(loginUserName, loginUserName.getText()));
    }

    public void fillPassword(String password) {
        //wait.until(ExpectedConditions.elementToBeClickable(loginPassword));
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
