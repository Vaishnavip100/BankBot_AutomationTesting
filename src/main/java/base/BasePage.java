package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.ConfigReader;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigReader config;

    public BasePage(WebDriver driver) {
        this.driver=driver;
        this.config=new ConfigReader();
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(config.getTimeout()));
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element=waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public Alert switchToAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void selectByVisibleText(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }
    
    public String getAlertText() {
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }
}