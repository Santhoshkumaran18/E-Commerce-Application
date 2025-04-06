package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import baseTest.BaseTest;
import pageObjects.AccountCreationSuccessfulPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;

public class TC002_LoginPageTest extends BaseTest {

	@Test (groups = {"Sanity","Master"})

	public void verify_account_registration() throws InterruptedException {
		try {
			logger.info("Starting the Login Page Test");
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			logger.info("Enter the login credentials details");
			LoginPage lp=new LoginPage(driver);
			lp.enterEmailAddress(properties.getProperty("email"));
			lp.enterPassword(properties.getProperty("password"));
			
			logger.info("Clicking the login button");
			lp.clickLogin_btn();
			
			
			//Validating the myaccount page 
			logger.info("Validating the my account text");
			MyAccountPage myaccpage=new MyAccountPage(driver);
			String myAccounText=myaccpage.getAccountText();
			Assert.assertEquals(myAccounText, "My Account");
			
			myaccpage.enter_Search_box("iphone");
			Thread.sleep(5000);
			logger.info("Test Completed successfully");
			
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		
	}

}
