package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='content']/h2[text()='My Account']")
	private static WebElement myAccount_text;
	
	@FindBy(xpath="//input[@name='search']")
	private static WebElement search_box;
	
	
	public String getAccountText() {
		return myAccount_text.getText();
	}
	
	public void enter_Search_box(String value) {
		WebElement search=waitforElement(search_box);
		search.sendKeys(value + "\n");
	}
	
	
	
	
}
