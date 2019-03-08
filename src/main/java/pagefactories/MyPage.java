package pagefactories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.RunEnvironment;
import util.WaitFor;

import java.util.List;
import java.util.stream.Collectors;

public class MyPage {

    @FindBy(css="div.watchlist")
    WebElement watchListBtn;

    @FindBy(css="div.favourites")
    WebElement favoritesBtn;

    @FindBy(css="div.watched")
    WebElement watchedBtn;

    By favTitles = By.cssSelector("div.series-title");
    By watchedTitles = By.cssSelector("div.series >* div.h3");


    private WebDriver driver;
    private WebDriverWait wait;
    private WaitFor wf;

    public MyPage() {
        driver = RunEnvironment.getWebDriver();
        wait = new WebDriverWait(driver, 10);
        wf = new WaitFor(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToWatchList(){
        wf.clickable(watchListBtn).click();
    }

    public MyPage goToFavorites(){
        wf.clickable(favoritesBtn).click();
        return this;
    }

    public MyPage goToMyShows(){
        wf.clickable(watchedBtn).click();
        return this;
    }

    public List<String> getFavoriteTitles(){
        return wf.presenceOfAll(favTitles).stream().map((el) -> el.getText().trim()).collect(Collectors.toList());
    }

    public List<String> getWatchedTitles(){
        return wf.presenceOfAll(watchedTitles).stream().map((el) -> getCleanTitle(el.getText())).collect(Collectors.toList());
    }

    private String getCleanTitle(String text){
        return text.replace("(ended)", "").replace("(running)", "").trim();
    }
}
