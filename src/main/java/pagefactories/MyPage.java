package pagefactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyPage {

    @FindBy(css="div.watchlist")
    WebElement watchListBtn;

    @FindBy(css="div.favourites")
    WebElement favoritesBtn;

    @FindBy(css="div.watched")
    WebElement watchedBtn;

    private WebDriver driver;
    private WebDriverWait wait;

    public MyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }


}
