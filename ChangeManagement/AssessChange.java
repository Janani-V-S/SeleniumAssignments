package week4Day2.ChangeManagement;

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

public class AssessChange {

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
				String changeReqID = "CHG0030432";
				searchField.sendKeys(changeReqID);
				searchField.sendKeys(Keys.ENTER);
				
				//assess change request
				driver.findElement(By.xpath("//a[@class = 'linked formlink']")).click();
				
				//update state
				WebElement state = driver.findElement(By.id("change_request.state"));
				Select changeReqState = new Select(state);
				changeReqState.selectByVisibleText("Assess");
				
				//update Assignment Group & Assigned to
				WebElement assignmentGroup = driver.findElement(By.id("sys_display.change_request.assignment_group"));
				assignmentGroup.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Recent selections']/following::span[text() = 'Software']"))).click();
						
				WebElement assignedTo = driver.findElement(By.id("sys_display.change_request.assigned_to"));
				assignedTo.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text() = 'ITIL User']"))).click();
				
				//click update
				driver.findElement(By.id("sysverb_update")).click();
				
				//verify state and assigned to
				String changeState = driver.findElement(By.xpath("(//tr[@class ='list_row list_odd']//td)[6]")).getText();
				
				String changeAssignedTo = driver.findElement(By.xpath("(//a[@class = 'linked'])[2]")).getText();
				
				if(changeState.contains("Assess") && changeAssignedTo.contains("ITIL User")){
					System.out.println("Change state and assignment details are updated");
				}
				else {
					System.out.println("Change state and assignment details are not updated");
				}
				driver.close();
	}

}
