package week4Day2.ChangeManagement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateChange {

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
		searchFilter.sendKeys("Change");
		searchFilter.sendKeys(Keys.ENTER);
		
		//Click create new change
		driver.findElement(By.xpath("(//div[text() = 'Create New'])[3]")).click();
		
		//click Normal change
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		driver.findElement(By.xpath("//span[text() = 'Normal']")).click();
		
		//capture change req id
		String changeReqID = driver.findElement(By.id("change_request.number")).getAttribute("value");
		
		//click submit
		driver.findElement(By.id("sysverb_insert")).click();
		
		//click open
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("(//div[text() = 'Open'])[3]")).click();
		
		//enter change number
		driver.switchTo().frame("gsft_main");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class = 'form-control']")));
		WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
		searchField.sendKeys(changeReqID);
		searchField.sendKeys(Keys.ENTER);
		
		//verify change req is created
		String chID = driver.findElement(By.xpath("//a[@class = 'linked formlink']")).getText();
		
		if(changeReqID.equals(chID)) {
			System.out.println("Change Request is created");
		}
			else
			{
				System.out.println("Change Request is not created");
			}
		driver.close();
	}
}
