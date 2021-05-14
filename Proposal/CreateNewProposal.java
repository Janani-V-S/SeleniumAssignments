package week4Day2.Proposal;

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

public class CreateNewProposal {

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
		
		//create proposal
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		driver.findElement(By.id("sysverb_new")).click();
		
		String proposalNumber = driver.findElement(By.id("std_change_proposal.number")).getAttribute("value");
		
		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys("test");
		
		//driver.findElement(By.xpath("(//input[@class = 'filerTableInput form-control'])[1]")).sendKeys("test");
		
		driver.findElement(By.xpath("(//span[text() = 'Change Request values'])[1]")).click();
		
		driver.findElement(By.xpath("(//td[@id = 'field']/div)[1]")).click();;
		driver.findElement(By.xpath("//div[text() = 'Risk and impact analysis']")).click();
		
		driver.findElement(By.xpath("(//textarea[@class = 'filerTableInput form-control'])[1]")).sendKeys("test");
		
		driver.findElement(By.id("sysverb_insert")).click();
		
		//verify if proposal is created
		driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys(proposalNumber,Keys.ENTER);
		String createdProposal = driver.findElement(By.xpath("//a[@class = 'linked formlink']")).getText();
		
		if(proposalNumber.equals(createdProposal)) {
			System.out.println("New proposal "+proposalNumber+" is created");
		}else {
			System.out.println("New proposal is not created");
		}
		driver.close();
	}

}
