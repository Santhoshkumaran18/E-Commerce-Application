package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private static WebElement myAccount;
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-menu-right')]")
	private static WebElement myAccount_dropdown_element;
	
	@FindBy(xpath = "//a[text()='Register']")
	private static WebElement register;
	
	@FindBy(xpath = "//a[text()='Login']")
	private static WebElement login;
	
	public void clickMyAccount() {
		 myAccount.click();
	}
	
	public void clickRegister() {
		WebElement register_btn=elementTobeClickable(register);
		register_btn.click();
		
	}
	
	public void clickLogin() {
		WebElement login_btn=elementTobeClickable(login);
		login_btn.click();
	}
}
