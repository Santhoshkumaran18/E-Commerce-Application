package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private static WebElement register_Account;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private static WebElement first_Name;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private static WebElement last_Name;
	
	@FindBy(xpath = "//input[@name='email']")
	private static WebElement email;
	
	@FindBy(xpath = "//input[@name='telephone']")
	private static WebElement telePhone;
	
	@FindBy(xpath = "//input[@name='password']")
	private static WebElement password;
	
	@FindBy(xpath = "//input[@name='confirm']")
	private static WebElement pwd_confirm;
	
	@FindBy(xpath = "(//label[@class='radio-inline']/input[@type='radio'])[1]")
	private static WebElement newsletter_yes;
	
	@FindBy(xpath = "(//label[@class='radio-inline']/input[@type='radio'])[2]")
	private static WebElement newsletter_no;
	
	@FindBy(xpath = "//input[@name='agree']")
	private static WebElement terms_and_Conditions;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private static WebElement continue_btn;
	
	public void setfirstName(String firstname) {
		first_Name.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		last_Name.sendKeys(lastname);
	}
	
	public void setEmail(String e_mail) {
		email.sendKeys(e_mail);
	}
	
	public void setTelephone(String tele_phone) {
		telePhone.sendKeys(tele_phone);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void confirm_password(String pwd) {
		pwd_confirm.sendKeys(pwd);
	}
	
	public void clickNewLetterYes() {
		newsletter_yes.click();
	}
	
	public void clickNewsLetterNo() {
		newsletter_no.click();
	}
	
	public void checkTermsAndConditions() {
		terms_and_Conditions.click();
	}
	
	public void clickContinuebtn() {
		continue_btn.click();
		
		/*
		 * Actions a=new Actions(driver);
		 * a.moveToElement(continue_btn).build().perform();
		 */
		
		/*
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();",continue_btn);
		 */
		
		/*
		 * WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.elementToBeClickable(continue_btn));
		 */
		
		
	}
	
	
	
	
	
}
