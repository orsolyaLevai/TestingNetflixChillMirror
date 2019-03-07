package pagefactories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WaitFor;

import java.util.List;

public class MyPage {

    @FindBy(css="div.watchlist")
    WebElement watchListBtn;

    @FindBy(css="div.favourites")
    WebElement favoritesBtn;

    @FindBy(css="div.watched")
    WebElement watchedBtn;

    By favTitles = By.cssSelector("div.series-title");


    private WebDriver driver;
    private WebDriverWait wait;
    private WaitFor wf;

    public MyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        wf = new WaitFor(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToWatchList(){
        wf.clickable(watchListBtn).click();
    }

    public void goToFavorites(){
        wf.clickable(favoritesBtn).click();
    }

    public void goToMyShows(){
        wf.clickable(watchedBtn).click();
    }

    public List<String> getFavoriteSeries(){
        wf.presence(favTitles);
        return null;
    }
}
