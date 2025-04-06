package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreationSuccessfulPage extends BasePage {

	public AccountCreationSuccessfulPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='content']/h1")
	private static WebElement account_creation_message;

	@FindBy(xpath = "//div[@id='content']/p[1]")
	private static WebElement congratulations_msg;

	@FindBy(xpath = "//div[@class='pull-right']/a")
	private static WebElement acc_continue_btn;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-menu-right')]/li/a[text()='My Account']")
	private static WebElement my_Account;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-menu-right')]/li/a[text()='Order History']")
	private static WebElement order_History;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-menu-right')]/li/a[text()='Downloads']")
	private static WebElement downloads;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-menu-right')]/li/a[text()='Transactions']")
	private static WebElement transactions;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-menu-right')]/li/a[text()='Logout']")
	private static WebElement logout;

	public void clickContinuebtn() {
		acc_continue_btn.click();

		/*
		 * Actions a=new Actions(driver);
		 * a.moveToElement(acc_continue_btn).build().perform();
		 */

		/*
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();",acc_continue_btn);
		 */

		/*
		 * WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.elementToBeClickable(acc_continue_btn));
		 */

	}

	public String getConfirmationMsg() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement acc_creation_message = wait.until(ExpectedConditions.visibilityOf(account_creation_message));
			return (acc_creation_message.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

	public String getCongratulationmsg() {
		try {
			return (congratulations_msg.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
	
	public void click_logoutBtn() {
		logout.click();
	}

}
