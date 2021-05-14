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

public class CreateNewWork {

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
				driver.findElement(By.id("sysverb_new")).click();
				
				//select task type
				driver.findElement(By.xpath("//form[@name='wizard']/div[23]/a[1]")).click();
				
				//save req no
				String reqID = driver.findElement(By.id("sc_request.number")).getAttribute("value");
				System.out.println(reqID);
				
				//submit req
				driver.findElement(By.id("sysverb_insert")).click();
				
				//verify if req is created
				boolean requestDisplayed = false;
				List<WebElement> reqIDs = driver.findElements(By.xpath("//a[@class = 'linked formlink']"));
				for (WebElement requestID : reqIDs) {
					if(requestID.getText().contains(reqID)) {
						System.out.println("New Request is created");
						requestDisplayed = true;
					}
					if(requestDisplayed) {
						break;
					}
				}
				if(!requestDisplayed) {
					System.out.println("New Request is not created");
				}
				driver.close();
	}
}
