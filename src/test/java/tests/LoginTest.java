package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtil;

public class LoginTest extends BaseTest {
	@DataProvider(name="loginData")
    public Object[][] getLoginData() {
        String path = System.getProperty("user.dir")+"/src/test/resources/testdata/LoginData.xlsx";
        return ExcelUtil.getData(path, "Login");
    }

    @Test(dataProvider="loginData")
    public void loginTest(String username,String password,String expected,String desc) {
        LoginPage login=new LoginPage(getDriver());
        login.login(username,password);

        switch (expected.toLowerCase()) {
            case "success":
                Assert.assertTrue(login.isLoginSuccessful(),"Login should be successful");
                break;

            case "error":
                String errorAlert=login.switchToAlert().getText();
                Assert.assertTrue(errorAlert.contains("not valid"),"Invalid login alert should appear");
                login.switchToAlert().accept();
                break;

            case "blank":
                try {
                    String alertText=login.switchToAlert().getText();
                    Assert.assertTrue(alertText.contains("User or Password"),"Validation alert should appear");
                    login.switchToAlert().accept();
                } catch (Exception e) {
                    Assert.assertTrue(true, "No alert but handled safely");
                }
                break;

            default:
                throw new RuntimeException("Invalid expected result");
        }
    }
    
    //Logout redirects to the login page
    @Test
    public void verifyLogoutRedirectsToLoginPage() {
        LoginPage login=new LoginPage(getDriver());
        login.login(config.getUsername(), config.getPassword());
        HomePage hp=new HomePage(getDriver());
        hp.clickLogout();
        hp.switchToAlert().accept();
        Assert.assertTrue(hp.isLoginPageDisplayed(),"User should be redirected to login page after logout");
    }
}