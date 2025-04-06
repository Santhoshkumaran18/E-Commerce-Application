package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@name='email']")
	private static WebElement email_address;
	
	@FindBy(xpath = "//input[@name='password']")
	private static WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private static WebElement login_btn;
	
	public void enterEmailAddress(String email) {
		WebElement ele=waitforElement(email_address);
		ele.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		WebElement pw=waitforElement(password);
		pw.sendKeys(pwd);
	}
	
	public void clickLogin_btn() {
		WebElement lgn_btn=waitforElement(login_btn);
		lgn_btn.click();
	}
	
	
	
	
}
