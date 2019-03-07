package pagefactories;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navbar {
    //@FindBy(css = "body > app-root > app-navbar > nav > ul.navbar-nav.navbar-right > li:nth-child(2) > a[href*='/join']")
    @FindBy(xpath = "//nav//a[@href='/join']/..")
    private WebElement joinButton;

    @FindBy(xpath = "//nav//a[contains(text(), 'Logout')]/..")
    private WebElement logoutButton;

    //@FindBy(css = "a[href*='/login']")
    @FindBy(xpath = "//nav//a[contains(text(), 'Login')]")
    private WebElement loginButtonInHeader;

    @FindBy(css="a[href*='/user-page']")
    private WebElement myPageButton;

    @FindBy(xpath = "//i[contains(@class, 'fa-search')]/..")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[contains(@class, search-field)]")
    private WebElement searchField;

    private WebDriver driver;
    private WebDriverWait wait;

    public Navbar(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        PageFactory.initElements(this.driver, this);
    }

    public void search(String searchStr){
        searchIcon.click();
        searchField.sendKeys(searchStr + Keys.ENTER);
    }

    public void clickLoginInTheHeader() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonInHeader)).click();
    }

    public void clickLogoutInHeader() {
        driver.navigate().refresh();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
    }

    public boolean isLogoutButtonAvailableInTheHeader() {
        try {
            wait.until(ExpectedConditions.visibilityOf(logoutButton));
        } catch (TimeoutException e) {
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }

        return true;
    }
}
