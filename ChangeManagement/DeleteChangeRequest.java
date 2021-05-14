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

public class DeleteChangeRequest {

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
		
		//click open
		driver.findElement(By.xpath("(//div[text() = 'Open'])[3]")).click();
		
		//enter change number
		driver.switchTo().frame("gsft_main");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class = 'form-control']")));
		WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
		String changeReqID = "CHG0030500";
		searchField.sendKeys(changeReqID);
		searchField.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//a[@class = 'linked formlink']")).click();
		
		//delete change request
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		
		String text = driver.findElement(By.xpath("//tr[@class = 'list2_no_records']/td")).getText();
		if(text.contains("No records")) {
			System.out.println("Change request is deleted");
		}
		else {
			System.out.println("Change request is not deleted");
		}
		
		driver.close();
	}

}
