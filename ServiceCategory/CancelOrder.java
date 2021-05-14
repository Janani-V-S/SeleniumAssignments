package week4Day2.ServiceCategory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CancelOrder {

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
				searchFilter.sendKeys("Service Catalog");
				searchFilter.sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("//div[text() = 'Service Catalog']")).click();
				
				//search for request
				driver.findElement(By.xpath("//div[text()  = 'Requests']")).click();
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
				driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys("REQ0010073",Keys.ENTER);
				
				//select req num
				driver.findElement(By.xpath("//a[@class = 'linked formlink']")).click();
				
				//update approval & request state fields
				WebElement approvalDD = driver.findElement(By.id("sc_request.approval"));
				Select approval = new Select(approvalDD);
				approval.selectByVisibleText("Rejected");
				
				WebElement requestedStateDD = driver.findElement(By.id("sc_request.request_state"));
				Select requestedState = new Select(requestedStateDD);
				requestedState.selectByVisibleText("Closed Cancelled");
				
				//cancel
				driver.findElement(By.xpath("//button[text() = 'Cancel Request']")).click();
				
				//verify if order is cancelled
				String status = driver.findElement(By.xpath("//tbody[@class = 'list2_body']//td")).getText();
				
				//verify if order is placed
				if(status.contains("No records")) {
					System.out.println("Order is cancelled");
									}else {
					System.out.println("Order is not cancelled");
				}
				//driver.close();				
	}
}
