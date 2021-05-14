package week4Day2.IncidentManagement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident {
 
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://dev103117.service-now.com/");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		driver.switchTo().frame("gsft_main");
		
		
		//Login with credentials
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		
		//Enter incident in search filter and press enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text() = 'Homepage'])[1]")));
		WebElement searchFilter = driver.findElement(By.id("filter"));
		searchFilter.sendKeys("Incident");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[text() = 'Homepage'])[1]")));
		searchFilter.sendKeys(Keys.ENTER);
		
		//click Open
		driver.findElement(By.xpath("//div[text() = 'Open']")).click();
		
		//search for existing incident and click on the incident
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
		String IncNo = "INC0010914";
		searchField.sendKeys(IncNo);
		searchField.sendKeys(Keys.ENTER);
		
		WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
		wait.until(ExpectedConditions.textToBePresentInElement(searchRes, IncNo));
		searchRes.click();
		
		//delete incident
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[text() = 'Open']")).click();
		  
		//search for deleted incident 
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class = 'form-control']")));
		driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys(IncNo,Keys.ENTER);
		
		WebElement delIncident = driver.findElement(By.xpath("//td[text() = 'No records to display']"));
		boolean isIncidentDisplayed = delIncident.isDisplayed();
		
		if(isIncidentDisplayed){
			System.out.println("Incident is deleted");
		}
		else
		{
			System.out.println("Incident is not deleted");
		}
		driver.close();
	}
}
