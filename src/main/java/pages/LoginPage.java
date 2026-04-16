package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By username=By.name("uid");
    private By password=By.name("password");
    private By loginBtn=By.name("btnLogin");
    private By errorMsg=By.xpath("//span[@id='message23']");
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String user) {
        type(username,user);
    }

    public void enterPassword(String pass) {
        type(password,pass);
    }

    public void clickLogin() {
        click(loginBtn);
    }

    public void login(String user,String pass) {
        type(username,user);
        type(password,pass);
        click(loginBtn);
    }

    public boolean isLoginSuccessful() {
        return getPageTitle().contains("Guru99 Bank Manager HomePage");
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorMsg);
    }
}