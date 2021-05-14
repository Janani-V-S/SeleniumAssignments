package week4Day2Assignments.QueueEntry;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatenewQueueEntry {

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
		
		//create new queue entry
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		driver.findElement(By.id("sysverb_new")).click();
		
		//select chat queue entry
		driver.findElement(By.xpath("//form[@name='wizard']/div[6]/a[1]")).click();
		
		//enter mandatory fields
		String queueID = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value");
		System.out.println(queueID);
		
		driver.findElement(By.id("sysverb_insert")).click();
		
		//verify if new queue entry is created
		driver.findElement(By.xpath("(//input[@class = 'form-control'])[1]")).sendKeys(queueID,Keys.ENTER);
		
		String createdQueueID = driver.findElement(By.xpath("//a[@class = 'linked formlink']")).getText();
		if(queueID.equals(createdQueueID)) {
			System.out.println("New queue entry is created");
		}else {
			System.out.println("New queue entry is not created");
		}
		driver.close();
	}
}
