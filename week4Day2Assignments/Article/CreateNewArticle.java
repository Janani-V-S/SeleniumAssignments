package week4Day2Assignments.Article;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewArticle {

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
				
				//enter knowledge in filter
				WebElement searchFilter = driver.findElement(By.id("filter"));
				searchFilter.sendKeys("Knowledge");
				searchFilter.sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("(//div[text() = 'Create New'])[5]")).click();
				
				driver.switchTo().frame("gsft_main");
				
				//create new article
				String articleID = driver.findElement(By.id("sys_readonly.kb_knowledge.number")).getAttribute("value");
				System.out.println(articleID);
				driver.findElement(By.xpath("//input[@id = 'sys_display.kb_knowledge.kb_knowledge_base']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'IT']"))).click();
				
				//enter category
				wait.until(ExpectedConditions.elementToBeClickable(By.id("sys_display.kb_knowledge.kb_category"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text() = 'Java']"))).click();
				
				//enter desc
				driver.findElement(By.id("kb_knowledge.short_description")).sendKeys("test");
				
				//submit
				driver.findElement(By.id("sysverb_insert")).click();
				
				//verify if new article is created
				driver.findElement(By.xpath("(//input[@class = 'form-control'])[1]")).sendKeys(articleID,Keys.ENTER);
				String createdArticleID = driver.findElement(By.xpath("//a[@class = 'linked formlink']")).getText();
				
				if(articleID.equals(createdArticleID)) {
					System.out.println("New article is created");
				}else {
					System.out.println("New article is not created");
				}
				driver.close();
	}

}
