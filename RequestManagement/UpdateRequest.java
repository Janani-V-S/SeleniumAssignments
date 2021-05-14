package week4Day2.RequestManagement;

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

public class UpdateRequest {

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
				driver.findElement(By.xpath("(//input[@class = 'form-control'])[1]")).sendKeys("REQ0010092",Keys.ENTER);
				driver.findElement(By.xpath("(//a[@class = 'linked formlink'])[1]")).click();
				
				//update req details
				WebElement location = driver.findElement(By.id("sys_display.sc_request.location"));
				location.clear();
				location.sendKeys("Rhode");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Rhode Island']"))).click();
				
				driver.findElement(By.xpath("(//button[@id = 'sc_request.due_date.ui_policy_sensitive'])[2]")).click();
				driver.findElement(By.xpath("(//a[@aria-selected='true']/following::a)[1]")).click();
				driver.findElement(By.id("GwtDateTimePicker_ok")).click();
				WebElement dateField = driver.findElement(By.xpath("//input[@id = 'sc_request.due_date']"));
				String selectedDate = dateField.getAttribute("value");
				driver.findElement(By.id("sysverb_update")).click();
				
				//verify updated details
				driver.findElement(By.xpath("(//a[@class = 'linked formlink'])[1]")).click();
				
				String modifiedLocation = driver.findElement(By.id("sys_display.sc_request.location")).getAttribute("value");
				System.out.println(modifiedLocation);
				String modifiedDate = driver.findElement(By.xpath("//input[@id = 'sc_request.due_date']")).getAttribute("value");
				System.out.println(modifiedDate);
		
				if(modifiedLocation.contains("Rhode") &&  modifiedDate.equals(selectedDate)) {
				System.out.println("Request is updated"); }else {
				System.out.println("Request is not updated"); }
				driver.close();
				
				
	}
}
