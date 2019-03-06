package pagefactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {

    @FindBy(css = "a[href*='/join']")
    protected WebElement joinButton;

    @FindBy(id = "username-join")
    protected WebElement registerUserName;

    @FindBy(id = "password-join")
    protected WebElement registerPassword;

    @FindBy(id = "password-confirm")
    protected WebElement registerConfirmPassword;

    @FindBy(id = "email")
    protected WebElement email;

    protected WebDriver driver;
    protected WebDriverWait wait;

    Registration(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void register() {
        driver.navigate().to("http://localhost:4200/");
        wait.until(ExpectedConditions.elementToBeClickable(joinButton)).click();


    }
}
