package util;

import org.openqa.selenium.WebDriver;
import pagefactories.LoginPage;
import pagefactories.Navbar;

public class Keywords {

    public static void login(){
        LoginPage loginPage = new LoginPage();
        ConfigProperties configProperties = new ConfigProperties();
        String userName = configProperties.getUserName();
        String password = configProperties.getPassword();

        loginPage.goToLoginPage();
        loginPage.fillUserName(userName);
        loginPage.fillPassword(password);

        loginPage.clickOnLoginButton();
    }
}
