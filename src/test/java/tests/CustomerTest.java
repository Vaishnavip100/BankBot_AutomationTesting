package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EditCustomerPage;
import pages.LoginPage;
import pages.NewCustomerPage;

public class CustomerTest extends BaseTest {	
	
	//Create a new customer and verify
    @Test
    public void verifyCreateCustomer() {
        LoginPage login=new LoginPage(getDriver());
        login.login(config.getUsername(),config.getPassword());

        NewCustomerPage customer=new NewCustomerPage(getDriver());
        customer.navigateToNewCustomer();
        
    	String email="Vaishnavi" + System.currentTimeMillis() + "@test.com";
        customer.addNewCustomer("Vaishnavi","female","10-11-2004","KL rao Park","Vijayawada","Andhra Pradesh","520001","9876543210",email,"Password123");

        //Success message
        Assert.assertTrue(customer.isCustomerCreated(),"Customer should be created successfully");

        String custId=customer.getCustomerId();
        Assert.assertNotNull(custId,"Customer ID should be generated");
    }
    
    //Duplicate email
    @Test
    public void verifyDuplicateEmailError() {
        LoginPage login=new LoginPage(getDriver());
        login.login(config.getUsername(),config.getPassword());
        
        NewCustomerPage customer=new NewCustomerPage(getDriver());
        customer.navigateToNewCustomer();

        String email="user" + System.currentTimeMillis() + "@test.com";

        customer.addNewCustomer("Uday","male","01-01-1995","Tikle road","Hyderabad","Telengana","500001","9876543210",email,"Uday123");
        customer.navigateToNewCustomer();
        customer.addNewCustomer("Bhavana","female","04-06-1995","Kolan Street","Bangalore","Karnataka","560001","9876543210",email,"Bhav123");

        String alertText=customer.switchToAlert().getText();

        Assert.assertTrue(alertText.contains("Email Address Already Exist"),"Duplicate email error should appear");

        customer.switchToAlert().accept();
    }
    
    //Edit an existing customer's address and verify
    @Test
    public void verifyEditCustomer() {
        LoginPage login=new LoginPage(getDriver());
        login.login(config.getUsername(),config.getPassword());
        
        NewCustomerPage customer=new NewCustomerPage(getDriver());
        customer.navigateToNewCustomer();
    	String email="Vaishnavi" + System.currentTimeMillis() + "@test.com";
        customer.addNewCustomer("Haindhav","male","01-08-2001","Sanikya Colony", "Chennai", "Tamil Nadu","600001", "9876543210",email, "Haindhav123");

        String custId=customer.getCustomerId();
        
        EditCustomerPage edit=new EditCustomerPage(getDriver());
        edit.navigateToEditCustomer();
        edit.loadCustomer(custId);
        edit.updateAddress("Updated Address");

        Assert.assertTrue(edit.isUpdateSuccessful(),"Customer should be updated");
    }
}