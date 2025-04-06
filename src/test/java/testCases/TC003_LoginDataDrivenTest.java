package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.AccountCreationSuccessfulPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseTest{
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = {"Regression","Sanity","DataDriven"})
	public void loginData(String email,String pwd,String expectedType) {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmailAddress(email);
		lp.enterPassword(pwd);
		
		lp.clickLogin_btn();
		
		MyAccountPage myaccpage=new MyAccountPage(driver);
		String myAccounText=myaccpage.getAccountText();
		boolean myAccount=myAccounText.equals("My Account");
		Assert.assertEquals(myAccounText, "My Account");
		
		AccountCreationSuccessfulPage ap=new AccountCreationSuccessfulPage(driver);
		if(expectedType.equalsIgnoreCase("valid")) {
			if(myAccount==true) {
				Assert.assertTrue(true);				
				hp.clickMyAccount();
				ap.click_logoutBtn();
			}else {
				Assert.assertTrue(false);
			}
			
		}
		if(expectedType.equalsIgnoreCase("invalid")) {
			if(myAccount==true) {
				hp.clickMyAccount();
				ap.click_logoutBtn();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
	
		
	}
}
