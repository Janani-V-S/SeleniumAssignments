package week4Day2Assignments.IncidentManagement;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewIncident {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		driver.get("https://dev103117.service-now.com/");
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
				
		//click create new & fill mandatory details
		driver.findElement(By.xpath("//div[text() = 'Create New']")).click();
		driver.switchTo().frame("gsft_main");
		
		WebElement incidentNum = driver.findElement(By.xpath("//input[@id = 'sys_original.incident.number']"));
		
		String incidentNo = incidentNum.getAttribute("value");
		System.out.println("Incident number - "+incidentNo);
		
		WebElement caller = driver.findElement(By.id("sys_display.incident.caller_id"));
		caller.click();
		WebElement systemAdministrator = driver.findElement(By.xpath("//td[text() = 'System Administrator']"));
		systemAdministrator.click();
		driver.findElement(By.id("incident.short_description")).sendKeys("test");
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
		
		//verify if incident is created
		
		
		WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
		searchField.sendKeys(incidentNo);
		searchField.sendKeys(Keys.ENTER);
		
		WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
		wait.until(ExpectedConditions.textToBePresentInElement(searchRes, incidentNo));
		String compStr = searchRes.getText();
		
		if(incidentNo.equals(compStr)) {
			System.out.println("New incident is created");
		}
		else{
			System.out.println("New incident is not created");
		}
		driver.close();
	}

}
