package week6Day2Assignments.POMHooks;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchCloseBrowser {
	public static ChromeDriver driver;
	public static WebDriverWait wait;
	public static String incidentNo;
	@BeforeMethod
	public void setup() {
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://dev103117.service-now.com/");
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.switchTo().frame("gsft_main");		
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
}
