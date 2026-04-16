package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountPage extends BasePage {
    private By editAccountLink=By.linkText("Edit Account");
    private By accountIdField=By.name("accountno");
    private By submitBtn=By.name("AccSubmit");

    private By accountType=By.name("selaccount");
    private By submitUpdate=By.name("sub");

    private By successMsg=By.xpath("//p[@class='heading3']");

    public EditAccountPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateToEditAccount() {
        click(editAccountLink);
    }

    public void loadAccount(String accId) {
        type(accountIdField,accId);
        click(submitBtn);
        waitForVisibility(accountType);
    }

    public void updateAccountType(String newType) {
        selectByVisibleText(accountType,newType);
        click(submitUpdate);
    }

    public boolean isUpdateSuccessful() {
        return getText(successMsg).contains("Account details updated Successfully");
    }
}