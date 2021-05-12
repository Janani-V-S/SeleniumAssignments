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

public class ResolveIncident {

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
		
		driver.findElement(By.xpath("//div[text() = 'Open']")).click();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		
		WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
		String IncNo = "INC0010922";
		searchField.sendKeys(IncNo);
		searchField.sendKeys(Keys.ENTER);
		
		
		WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
		wait.until(ExpectedConditions.textToBePresentInElement(searchRes, IncNo));
		searchRes.click();
		
		//update state & resolution details
		WebElement state = driver.findElement(By.id("incident.state"));
		Select stateDropdown = new Select(state);
		stateDropdown.selectByVisibleText("Resolved");
		
		driver.findElement(By.xpath("//span[text() = 'Resolution Information']")).click();
		WebElement resCode = driver.findElement(By.id("incident.close_code"));
		Select resolutionCode = new Select(resCode);
		resolutionCode.selectByVisibleText("Solved (Permanently)");
		
		driver.findElement(By.id("incident.close_notes")).sendKeys("Incident Resolved");
		
		driver.findElement(By.id("resolve_incident")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'linked formlink']")));
		String incidentState = driver.findElement(By.xpath("(//tr[@class = 'list_row list_odd']//td)[8]")).getText();		
		if(incidentState.contains("Resolved")) {
			System.out.println("Incident is resolved");
		}
		else {
			System.out.println("Incident is not resolved");
		}
		driver.close();
	}
}
