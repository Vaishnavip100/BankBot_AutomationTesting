package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FundTransferPage extends BasePage {
    private By fundTransferLink=By.linkText("Fund Transfer");

    private By payerAccount=By.name("payersaccount");
    private By payeeAccount=By.name("payeeaccount");
    private By amount=By.name("ammount");
    private By description=By.name("desc");
    private By submitBtn=By.name("AccSubmit");

    private By successMsg=By.xpath("//p[@class='heading3']");
    
    public FundTransferPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToFundTransfer() {
        WebElement element=waitForVisibility(fundTransferLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void transferFund(String fromAcc,String toAcc,String amt,String descText) {
        type(payerAccount,fromAcc);
        type(payeeAccount,toAcc);
        type(amount,amt);
        type(description,descText);
        click(submitBtn);
    }

    public boolean isTransferSuccessful() {
        return getText(successMsg).contains("Fund Transfer Details");
    }
}