package week4.week4Day2Assignments;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateExistingIncident {

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
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		
		WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
		String IncNo = "INC0010922";
		searchField.sendKeys(IncNo);
		searchField.sendKeys(Keys.ENTER);
		
		
		WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
		wait.until(ExpectedConditions.textToBePresentInElement(searchRes, IncNo));
		searchRes.click();
		
		//update Urgency and State
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		urgency.click();
		Select urgencyDropdown = new Select(urgency);
		urgencyDropdown.selectByVisibleText("1 - High");
		
		WebElement state = driver.findElement(By.id("incident.state"));
		state.click();
		Select stateDropdown = new Select(state);
		stateDropdown.selectByVisibleText("In Progress");
		
		driver.findElement(By.id("sysverb_update")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'linked formlink']"))).click();
		WebElement priority = driver.findElement(By.xpath("(//span[text()='Priority']/following::span)[1]"));
		String incidentPriority = priority.getText();
				
		WebElement state1 = driver.findElement(By.xpath("(//span[text()='Incident state']/following::span)[1]"));
		String incidentState = state1.getText();
		
		if(incidentPriority.contains("3 - Moderate") && incidentState.contains("In Progress")) {
			System.out.println("Incident is updated");
		}
		else {
			System.out.println("Incident is not updated");
		}
		driver.close();
	}
}
