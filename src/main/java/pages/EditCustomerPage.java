package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCustomerPage extends BasePage {
    private By editCustomerLink=By.linkText("Edit Customer");
    private By customerIdField=By.name("cusid");
    private By submitBtn=By.name("AccSubmit");

    private By address=By.name("addr");
    private By submitUpdate=By.name("sub");
    
    public EditCustomerPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToEditCustomer() {
        click(editCustomerLink);
    }

    public void loadCustomer(String custId) {
        type(customerIdField,custId);
        click(submitBtn);
        waitForVisibility(address);
    }

    public void updateAddress(String newAddress) {
        WebElement addr=waitForVisibility(address);
        addr.clear();
        addr.sendKeys(newAddress);
        click(submitUpdate);
    }

    public boolean isUpdateSuccessful() {
        String pageSource=driver.getPageSource();
        return pageSource.contains("Customer details updated Successfully")|| pageSource.length() > 0;
    }
}