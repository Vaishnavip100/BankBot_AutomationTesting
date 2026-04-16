package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BalanceEnquiryPage extends BasePage {
    private By balanceLink=By.linkText("Balance Enquiry");
    private By accountNo=By.name("accountno");
    private By submitBtn=By.name("AccSubmit");

    private By balanceValue=By.xpath("//td[text()='Balance']/following-sibling::td");
    
    public BalanceEnquiryPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToBalance() {
        click(balanceLink);
    }

    public String getBalance(String accId) {
        type(accountNo, accId);
        click(submitBtn);
        return getText(balanceValue);
    }
}