package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountPage extends BasePage {
    private By newAccountLink=By.linkText("New Account");
    private By customerIdField=By.name("cusid");
    private By accountType=By.name("selaccount");
    private By deposit=By.name("inideposit");
    private By submitBtn=By.name("button2");

    private By successMsg=By.xpath("//p[@class='heading3']");
    private By accountId=By.xpath("//td[text()='Account ID']/following-sibling::td");
    
    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToNewAccount() {
        click(newAccountLink);
    }

    public void createAccount(String custId,String accType,String amount) {
        type(customerIdField,custId);
        selectByVisibleText(accountType,accType);
        type(deposit,amount);
        click(submitBtn);
    }

    public boolean isAccountCreated() {
        return getText(successMsg).contains("Account Generated Successfully");
    }

    public String getAccountId() {
        return getText(accountId);
    }
}