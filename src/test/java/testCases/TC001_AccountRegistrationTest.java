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
import pageObjects.RegistrationPage;

public class TC001_AccountRegistrationTest extends BaseTest {
	
	@Test (priority = 1,groups = {"Regression","Master"})
	
	public void verify_account_registration() throws InterruptedException {
		logger.info("Starting the Account Registration Page Test");
		try {
			HomePage homepage=new HomePage(driver);
			homepage.clickMyAccount();
			
			logger.info("Clicking on Register button");
			homepage.clickRegister();
			
			//Registration page details
			logger.info("Enter the details in the registration page");
			RegistrationPage registrationpage=new RegistrationPage(driver);
			registrationpage.setfirstName(randomFirstname());
			registrationpage.setLastName(randomLastName());
			registrationpage.setEmail(randomemail());
			registrationpage.setTelephone(randomNumber());
			
			String password=randomPassword();
			registrationpage.setPassword(password);
			registrationpage.confirm_password(password);
			registrationpage.clickNewLetterYes();
			registrationpage.checkTermsAndConditions();
			
			logger.info("Click on continue button");
			registrationpage.clickContinuebtn();
			
			
			//Account registraction successfully
			logger.info("Validating the success message");
			AccountCreationSuccessfulPage acpage=new AccountCreationSuccessfulPage(driver);
			String confmsg=acpage.getConfirmationMsg();
			String confirm_message="Your Account Has Been Created!";
			Assert.assertEquals(confirm_message,confmsg);
		}catch (Exception e) {
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		
		logger.info("Test got completed Successfully");
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
