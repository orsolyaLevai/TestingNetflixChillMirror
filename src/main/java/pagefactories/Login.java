package pagefactories;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigProperties;
import util.Utils;

public class Login {

    //@FindBy(linkText = "Join")
    @FindBy(css = "a[href*='/login']")
    protected WebElement loginButtonInHeader;

    @FindBy(id = "username-login")
    protected WebElement loginUserName;

    @FindBy(id = "password-login")
    protected WebElement loginPassword;

    @FindBy(xpath = "//button[@type='submit' and contains(., 'Login')]")
    protected WebElement loginButton;

    //@FindBy(xpath = "//div[@id='toast-container']//div[@role='alertdialog'][contains(text(), 'incorrect!')]")
    //@FindBy(css = "//div[@id='toast-container']//div[@role='alertdialog'][contains(text(), 'incorrect!')]")
    //protected WebElement alertDialogDiv;
    ///html/body/app-root/app-navbar/nav/ul[2]/li[4]/a
    @FindBy(xpath = "//nav//a[contains(text(), 'Logout')]")
    //@FindBy(css = "#toast-container > div.toast-error.toast.ng-trigger.ng-trigger-flyInOut > div")
    protected WebElement logoutButton;


    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigProperties configProperties;
    protected String webAddress = "http://localhost:4200/";


    public Login(WebDriver driver) {
        this.configProperties = new ConfigProperties();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 2);
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
        driver.navigate().to(webAddress);
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonInHeader)).click();
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

    public int clickOnLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();

        try {
            if(wait.until(ExpectedConditions.visibilityOf(logoutButton)).isDisplayed()) return 0;

        } catch (TimeoutException exception) {
            return -1;
        }
        return 0;
        /*if (wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).isDisplayed()) return 0;
        else return -1;*/
    }

}
