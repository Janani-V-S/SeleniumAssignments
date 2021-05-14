package week4Day2Assignments.ServiceCategory;

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

public class UpdateExistingOrder {

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
				driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys("REQ0010070",Keys.ENTER);
				
				//select req num
				driver.findElement(By.xpath("//a[@class = 'linked formlink']")).click();
				
				//update approval & request state fields
				WebElement approvalDD = driver.findElement(By.id("sc_request.approval"));
				Select approval = new Select(approvalDD);
				approval.selectByVisibleText("Requested");
				
				WebElement requestedStateDD = driver.findElement(By.id("sc_request.request_state"));
				Select requestedState = new Select(requestedStateDD);
				requestedState.selectByVisibleText("Pending Approval");
				
				//update other fields
				driver.findElement(By.id("sc_request.description")).sendKeys("test");
				driver.findElement(By.id("sc_request.short_description")).sendKeys("test");
				driver.findElement(By.id("sc_request.special_instructions")).sendKeys("test");
				
				//update
				driver.findElement(By.id("sysverb_update")).click();
				
				//verify if order is updated
				String updatedApprovalState = driver.findElement(By.xpath("(//tr[@class = 'list_row list_odd']/td)[6]")).getText();
				
				//verify if order is placed
				if(updatedApprovalState.contains("Pending")) {
					System.out.println("Order is updated");
									}else {
					System.out.println("Order is not updated");
				}
				driver.close();				
	}
}
