package week4Day2.Caller;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewCaller {

	public static void main(String[] args) {
		//Login to ServiceNow Application
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();		
				driver.get("https://dev103117.service-now.com");
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
				
				driver.switchTo().frame("gsft_main");
						
				//Login with credentials
				driver.findElement(By.id("user_name")).sendKeys("admin");
				driver.findElement(By.id("user_password")).sendKeys("India@123");
				driver.findElement(By.id("sysverb_login")).click();
				
				//enter change in filter
				WebElement searchFilter = driver.findElement(By.id("filter"));
				searchFilter.sendKeys("Callers");
				searchFilter.sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("//div[text() = 'Callers']")).click();
				
				//create caller
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
				driver.findElement(By.id("sysverb_new")).click();
				
				//Enter call details
				driver.findElement(By.id("sys_user.first_name")).sendKeys("TestFirstName");
				
				driver.findElement(By.id("sys_user.last_name")).sendKeys("TestLastName");
				
				driver.findElement(By.id("sys_user.email")).sendKeys("abc@gmail.com");
				
				driver.findElement(By.id("sys_user.phone")).sendKeys("12345");
				
				driver.findElement(By.id("sys_user.title")).sendKeys("Test");
				
				driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("12345");
				
				driver.findElement(By.id("sysverb_insert")).click();
				
				//verify if caller is created
				driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys("TestFirstName",Keys.ENTER);
				String result = driver.findElement(By.xpath("//a[@class = 'linked formlink']")).getText();
				
				if(result.contains("TestLastName")) {
					System.out.println("New Caller is created");
				}else {
					System.out.println("New Caller is not created");
				}
				driver.close();
	}

}
