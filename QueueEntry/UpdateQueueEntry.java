package week4Day2.QueueEntry;

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

public class UpdateQueueEntry {

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
				searchFilter.sendKeys("My Work");
				searchFilter.sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("(//div[text() = 'My Work'])[1]")).click();
				
				//select existing queue entry
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
				driver.findElement(By.xpath("(//input[@class = 'form-control'])[1]")).sendKeys("CHAT0010045",Keys.ENTER);
				driver.findElement(By.xpath("//a[@class = 'linked formlink']")).click();
				
				//update queue details
				//update state field
				WebElement stateDD = driver.findElement(By.id("chat_queue_entry.state"));
				Select state = new Select(stateDD);
				state.selectByVisibleText("Closed Abandoned");
				
				//update priority
				WebElement priorityDD = driver.findElement(By.id("chat_queue_entry.priority"));
				Select priority = new Select(priorityDD);
				priority.selectByVisibleText("1 - Critical");
				
				//update configuration item
				driver.findElement(By.id("sys_display.chat_queue_entry.cmdb_ci")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text() = 'PS Apache02']"))).click();
				
				driver.findElement(By.id("sysverb_update")).click();
				
				//verify if queue is updated
				String updatedPriority = driver.findElement(By.xpath("(//tr[@class = 'list_row list_odd']/td)[4]")).getText();
				String updatedState = driver.findElement(By.xpath("(//tr[@class = 'list_row list_odd']/td)[5]")).getText();
				String updatedconfigurationItem = driver.findElement(By.xpath("(//tr[@class = 'list_row list_odd']/td)[9]")).getText();
				
				if(updatedPriority.contains("1 - Critical") && updatedState.contains("Closed Abandoned") && updatedconfigurationItem.contains("PS Apache02")) {
					System.out.println("Queue entry is updated");
				}else {
					System.out.println("Queue entry is not updated");
				}
		/*
		 * if( updatedState.contains("Closed Abandoned") ) {
		 * System.out.println("Queue entry is updated"); }else {
		 * System.out.println("Queue entry is not updated"); }
		 * if(updatedconfigurationItem.contains("PS Apache02")) {
		 * System.out.println("Queue entry is updated"); }else {
		 * System.out.println("Queue entry is not updated"); }
		 */
				driver.close();
				}
}
