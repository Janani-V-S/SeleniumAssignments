package week4Day2Assignments.IncidentManagement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident {
 
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://dev103117.service-now.com/");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
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
		String IncNo = "INC0010918";
		searchField.sendKeys(IncNo);
		searchField.sendKeys(Keys.ENTER);
		
		WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
		wait.until(ExpectedConditions.textToBePresentInElement(searchRes, IncNo));
		searchRes.click();
		
		//update Assignment Group & Assigned to
		WebElement assignmentGroup = driver.findElement(By.id("sys_display.incident.assignment_group"));
		
		assignmentGroup.clear();
		assignmentGroup.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Recent selections']/following::span[text() = 'Software']"))).click();
				
		WebElement assignedTo = driver.findElement(By.id("sys_display.incident.assigned_to"));
		
		assignedTo.clear();
		assignedTo.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text() = 'ITIL User']"))).click();
		
		driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("In progress");
		
		driver.findElement(By.id("sysverb_update")).click();
		
		//verify if assigned to and assignment group are updated
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'linked formlink']")));
		WebElement updatedAssignmentGrp = driver.findElement(By.xpath("(//a[@class = 'linked'])[2]"));
		
		WebElement updatedAssignedTo = driver.findElement(By.xpath("(//a[@class = 'linked'])[3]"));
		
		if((updatedAssignmentGrp.getText()).equals("Software") && (updatedAssignedTo.getText()).equals("ITIL User")){
			System.out.println("Assignment Group & Assigned To details are updated");
		}
		else
		{
			System.out.println("Assignment Group & Assigned To details are not updated");
		}
		driver.close();
	}
}
