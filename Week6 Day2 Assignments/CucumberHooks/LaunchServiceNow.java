package CucumberHooks;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CucumberStepDefs.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LaunchServiceNow extends BaseClass{
	
	@Before
	public void launchServicenNow() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev103117.service-now.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame("gsft_main");
		
		
		//Login with credentials
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		
		//Enter incident in search filter and press enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text() = 'Homepage'])[1]")));
		WebElement searchFilter = driver.findElement(By.id("filter"));
		searchFilter.sendKeys("Incident");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[text() = 'Homepage'])[1]")));
		searchFilter.sendKeys(Keys.ENTER);
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}
}
