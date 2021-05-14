package week4Day2Assignments.ChangeManagement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateSchedule {

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
		String changeReqID = "CHG0030491";
		searchField.sendKeys(changeReqID);
		searchField.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//a[@class = 'linked formlink']")).click();
		
		//update schedule
		driver.findElement(By.xpath("//span[text() = 'Schedule']")).click();
		
		driver.findElement(By.xpath("(//button[@id = 'change_request.start_date.ui_policy_sensitive'])[2]")).click();
		driver.findElement(By.xpath("//a[text() = '12']")).click();
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		
		
		driver.findElement(By.xpath("(//button[@id = 'change_request.end_date.ui_policy_sensitive'])[2]")).click();
		driver.findElement(By.xpath("//a[text() = '17']")).click();
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		
		
		driver.findElement(By.id("label.ni.change_request.cab_required")).click();
		
		driver.findElement(By.id("change_request.cab_date.ui_policy_sensitive")).click();
		driver.findElement(By.xpath("//a[text() = '17']")).click();
		
		String startDate = driver.findElement(By.xpath("//input[@id = 'change_request.start_date']")).getAttribute("value");
		String endDate = driver.findElement(By.xpath("//input[@id = 'change_request.end_date']")).getAttribute("value");
				
		driver.findElement(By.id("sysverb_update")).click();
		
		//verify start and end date
		String plannedStartDate = driver.findElement(By.xpath("(//div[@class = 'datex date-calendar'])[1]")).getText();
		String plannedEndDate = driver.findElement(By.xpath("(//div[@class = 'datex date-calendar'])[2]")).getText();
		
		if(startDate.equals(plannedStartDate) && endDate.equals(plannedEndDate)) {
			System.out.println("Change schedule is updated");
		}else
		{
			System.out.println("Change schedule is not updated");
		}
		driver.close();
	}

}
