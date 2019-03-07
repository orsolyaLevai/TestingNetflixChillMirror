package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
    private WebDriverWait wait;

    public WaitFor(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement clickable(WebElement el){
        return wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    public WebElement presence(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
