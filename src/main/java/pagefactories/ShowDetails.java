package pagefactories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.RunEnvironment;
import util.WaitFor;

import java.util.List;

public class ShowDetails {

    @FindBy(css="i.plus")
    WebElement addToWatchedIcon;

    @FindBy(css="i.heart")
    WebElement addToFavoritesIcon;

    @FindBy(css="i.list")
    WebElement addToWatchListIcon;

    private WebDriver driver;
    private WebDriverWait wait;
    private WaitFor wf;

    public ShowDetails() {
        driver = RunEnvironment.getWebDriver();
        wait = new WebDriverWait(driver, 10);
        wf = new WaitFor(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void addToWatchList(){
        addToWatchListIcon.click();
    }

    public void addToFavorites(){
        addToFavoritesIcon.click();
    }

    public void addToMyShows(){
        addToWatchedIcon.click();
    }
}
