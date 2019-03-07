package pagefactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigProperties;

public class Registration {

    public static final String WEBADDRESS = "http://localhost:4200/";

    @FindBy(id = "username-join")
    protected WebElement registerUserName;

    @FindBy(id = "password-join")
    protected WebElement registerPassword;

    @FindBy(id = "password-confirm")
    protected WebElement registerConfirmPassword;

    @FindBy(id = "email")
    protected WebElement email;

    @FindBy(xpath = "//button[@type='submit' and contains(., 'Join')]")
    protected WebElement joinButton;

    //@FindBy(xpath = "xpath = //div[@id='toast-container']//div[@role='alertdialog'][contains(text(), 'already!')]")
    @FindBy(css = "#toast-container > div.toast-error.toast.ng-trigger.ng-trigger-flyInOut > div")
    protected WebElement alertUserExists;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigProperties configProperties;
    protected Navbar navbar;


    public Registration(WebDriver driver) {
        this.configProperties = new ConfigProperties();
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
        navbar = new Navbar(this.driver);
    }

    public void goToTheRegisterPage() {
        driver.get(WEBADDRESS);
        navbar.clickJoinInHeader();
    }

    public void fillUserNameField(String userName) {
        registerUserName.clear();
        registerUserName.sendKeys(userName);
        wait.until(ExpectedConditions.textToBePresentInElementValue(registerUserName, registerUserName.getText()));
    }

    public void fillPasswordField(String password) {
        registerPassword.clear();
        registerPassword.sendKeys(password);
        wait.until(ExpectedConditions.textToBePresentInElementValue(registerPassword, registerPassword.getText()));
    }

    public void fillConfirmPasswordField(String confirmPassword) {
        registerConfirmPassword.clear();
        registerConfirmPassword.sendKeys(confirmPassword);
        wait.until(ExpectedConditions.textToBePresentInElementValue(registerConfirmPassword, registerConfirmPassword.getText()));
    }

    public void fillEmailField(String emailAddress) {
        email.clear();
        email.sendKeys(emailAddress);
        wait.until(ExpectedConditions.textToBePresentInElementValue(email, email.getText()));
    }

    public void clickOnJoinButton() {
        wait.until(ExpectedConditions.visibilityOf(joinButton)).click();
    }

    public boolean isJoinButtonAvailable() {
        return wait.until(ExpectedConditions.visibilityOf(joinButton)).isEnabled();
    }
}
