package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage extends BasePage {
    private By newCustomerLink=By.linkText("New Customer");

    private By customerName=By.name("name");
    private By genderMale=By.xpath("//input[@value='m']");
    private By genderFemale=By.xpath("//input[@value='f']");    
    private By dob=By.name("dob");
    private By address=By.name("addr");
    private By city=By.name("city");
    private By state=By.name("state");
    private By pin=By.name("pinno");
    private By mobile=By.name("telephoneno");
    private By email=By.name("emailid");
    private By password=By.name("password");
    private By submitBtn=By.name("sub");

    private By successMsg=By.xpath("//p[@class='heading3']");
    private By customerId=By.xpath("//td[text()='Customer ID']/following-sibling::td");
    
    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToNewCustomer() {
        click(newCustomerLink);
    }

    public void addNewCustomer(String name,String gender,String dobValue,String addr,String cityValue,String stateValue,String pinValue,
    		String mobileValue,String emailValue, String passwordValue) {
	type(customerName,name);
	
	if (gender.equalsIgnoreCase("male")) {
		click(genderMale);
	} else if (gender.equalsIgnoreCase("female")) {
		click(genderFemale);
	} else {
		throw new RuntimeException("Invalid gender: " + gender);
	}
	
	type(dob,dobValue);
	type(address,addr);
	type(city,cityValue);
	type(state,stateValue);
	type(pin,pinValue);
	type(mobile,mobileValue);
	type(email,emailValue);
	type(password,passwordValue);
	
	click(submitBtn);
}

    public boolean isCustomerCreated() {
        return getText(successMsg).contains("Customer Registered Successfully");
    }

    public String getCustomerId() {
        return getText(customerId);
    }
    
    
    //Validation
    private By nameError=By.id("message");  
    private By cityError=By.id("message4");  
    private By stateError=By.id("message5");  
    private By pinError=By.id("message6");  
    private By mobileError=By.id("message7");

    public String getNameError() {
        return getText(nameError);
    }

    public String getCityError() {
        return getText(cityError);
    }
    
    public String getStateError() {
        return getText(stateError);
    }

    public String getPinError() {
        return getText(pinError);
    }

    public String getMobileError() {
        return getText(mobileError);
    }
    
    public void clickSubmit() {
        click(submitBtn);
    }

    public void typePin(String value) {
        type(pin, value);
    }

    public void typeMobile(String value) {
        type(mobile, value);
    }

    public void enterDOB(String value) {
        type(dob, value);
    }
    
    public void clickOutside() {
        driver.findElement(By.tagName("body")).click();
    }
}