package week4Day2Assignments.RequestManagement;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CancelRequest {

	public static void main(String[] args) throws InterruptedException {
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
				searchFilter.sendKeys("My Work");
				searchFilter.sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("(//div[text() = 'My Work'])[1]")).click();
				
				//create new request
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
				
				//search existing request
				driver.findElement(By.xpath("(//input[@class = 'form-control'])[1]")).sendKeys("REQ0010093",Keys.ENTER);
				driver.findElement(By.xpath("(//a[@class = 'linked formlink'])[1]")).click();
				
				//cancel req
				driver.findElement(By.xpath("//button[text() = 'Cancel Request']")).click();
				
				//verify if req is cancelled
				WebElement cancelledMsg = driver.findElement(By.xpath("//td[text() = 'No records to display']"));
				
				if(cancelledMsg.isDisplayed()) {
				System.out.println("Request is cancelled"); }else {
				System.out.println("Request is not cancelled"); }
				driver.close();
				
				
	}
}
