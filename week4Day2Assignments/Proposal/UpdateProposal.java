package week4Day2Assignments.Proposal;

import java.time.Duration;
import java.util.List;
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

public class UpdateProposal {

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
		searchFilter.sendKeys("Proposal");
		searchFilter.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text() = 'My Proposals']")).click();
		
		//search proposal
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys("STDCHG0001182",Keys.ENTER);
		
		//update proposal
		driver.findElement(By.xpath("//a[@class = 'linked formlink']")).click();
		
		//change state
		WebElement stateDD = driver.findElement(By.id("std_change_proposal.state"));
		Select state = new Select(stateDD);
		state.selectByVisibleText("In Progress");
		
		//change category
		driver.findElement(By.xpath("//input[@id = 'sys_display.std_change_proposal.category']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text() = 'Template Management']"))).click();
		
		//change risk impact
		driver.findElement(By.xpath("(//span[text() = 'Change Request values'])[1]")).click();
		
		driver.findElement(By.xpath("(//td[@id = 'field']/div)[1]")).click();;
		driver.findElement(By.xpath("//div[text() = 'Risk and impact analysis']")).click();
		
		List<WebElement> requestValues = driver.findElements(By.xpath("(//textarea[@class = 'filerTableInput form-control'])"));
		for (WebElement reqValues : requestValues) {
			reqValues.clear();
			reqValues.sendKeys("test");
		}
		
		//update short desc
		driver.findElement(By.xpath("(//input[@class = 'filerTableInput form-control'])[1]")).sendKeys("test");
		
		//update Assignment group
		driver.findElement(By.xpath("(//input[@title = 'Input value'])[2]")).sendKeys("Software");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'ac_dropdown']//span"))).click();
		
		driver.findElement(By.id("sysverb_update")).click();
		
		if(driver.findElement(By.xpath("(//a[@class = 'linked'])[2]")).getText().contains("Template")) {
			System.out.println("Proposal details are updated");
		}else {
			System.out.println("Proposal details are not updated");
		}
		driver.close();
	}
}
