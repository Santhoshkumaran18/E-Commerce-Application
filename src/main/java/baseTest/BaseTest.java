package baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	Faker faker = new Faker();
	public Logger logger;
	public Properties properties;

	@Parameters({ "browser" })
	@BeforeClass(groups = {"Master","Sanity"})
	public void setup(String browswer) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		File file=new File(System.getProperty("user.dir") + "./src/main/resources/config.properties");
		FileInputStream fis=new FileInputStream(file);
		properties=new Properties();
		properties.load(fis);
		
	

		switch (browswer.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
//			driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
			driver.get(properties.getProperty("app_url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			
			break;
		default:
			System.out.println("Invalid Browser name");
			return;
		}
	}

	@AfterClass (groups = {"Master","Sanity","DataDriven"})
	public void tearDown() {
		driver.quit();
	}

	public String randomFirstname() {
		return faker.name().firstName();
	}

	public String randomLastName() {
		return faker.name().lastName();
	}

	public String randomemail() {
		return faker.internet().emailAddress();
	}

	public String randomNumber() {
		return faker.number().digits(10);
	}

	public String randomPassword() {
		return faker.internet().password();
	}
	
	public String CaptureScreen(String tname) throws IOException {
		String timestamp=new SimpleDateFormat("yyyy.dd.MM.hh.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath =System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timestamp;
		File targetFile=new File(targetFilePath);
		src.renameTo(targetFile);
		return targetFilePath;
		
	}

}
