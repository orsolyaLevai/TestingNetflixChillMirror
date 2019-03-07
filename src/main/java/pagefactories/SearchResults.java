package pagefactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.RunEnvironment;
import util.WaitFor;

import java.util.List;

public class SearchResults {

    @FindBy(css="div.search-item")
    List<WebElement> titles;

    private WebDriver driver;
    private WebDriverWait wait;
    private WaitFor wf;

    public SearchResults() {
        driver = RunEnvironment.getWebDriver();
        wait = new WebDriverWait(driver, 10);
        wf = new WaitFor(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void clickOnTitle(String title){
        for(WebElement el: titles){
            if (el.getText().toLowerCase().contains(title.toLowerCase())){
                el.click();
            }
        }
    }

}
