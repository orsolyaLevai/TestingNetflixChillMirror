package pagefactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigProperties;

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

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigProperties configProperties;


    public Login(WebDriver driver) {
        configProperties = new ConfigProperties();
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void login() {
        driver.navigate().to("http://localhost:4200/");
        System.err.println(configProperties.getUserName());
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonInHeader)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginUserName));
        loginUserName.sendKeys(configProperties.getUserName());
        wait.until(ExpectedConditions.elementToBeClickable(loginPassword));
        loginPassword.sendKeys(configProperties.getUserName());

        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

}
