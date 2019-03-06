package pagefactories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    //@FindBy(linkText = "Join")
    @FindBy(css = "a[href*='/join']")
    WebElement joinButton;

    protected WebDriver driver;
    protected WebDriverWait wait;

    //@FindBy(id = "login-form-username")
    //WebElement userName;


    public Login(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void login() {
        driver.navigate().to("http://localhost:4200/");
        wait.until(ExpectedConditions.elementToBeClickable(joinButton)).click();
        //userName.sendKeys(System.getenv("username"));
        //password.sendKeys(System.getenv("password"));
        //loginBtn.click();
    }

}
