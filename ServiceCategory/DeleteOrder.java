package week4Day2.ServiceCategory;

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

public class DeleteOrder {

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
				searchFilter.sendKeys("Service Catalog");
				searchFilter.sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("//div[text() = 'Service Catalog']")).click();
				
				//select mobiles
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
				driver.findElement(By.xpath("//a[text() = 'Mobiles']")).click();
				
				//select Apple iphone 6s
				driver.findElement(By.xpath("//strong[text() = 'Apple iPhone 6s']")).click();
				
				//update monthly allowance
				WebElement monthlyAllowance = driver.findElement(By.xpath("(//select[@class = 'form-control cat_item_option '])[1]"));
				Select monthlyDataAllowance = new Select(monthlyAllowance);
				monthlyDataAllowance.selectByVisibleText("Unlimited [add $3.00 Monthly]");
				
				//select color
				WebElement colorDD = driver.findElement(By.xpath("(//select[@class = 'form-control cat_item_option '])[2]"));
				Select color = new Select(colorDD);
				color.selectByVisibleText("Rose Gold");
				
				//select storage
				WebElement storageDD = driver.findElement(By.xpath("(//select[@class = 'form-control cat_item_option '])[3]"));
				Select storage = new Select(storageDD);
				storage.selectByVisibleText("128GB [add $50.00]");
				
				//click order now button
				driver.findElement(By.id("oi_order_now_button")).click();
				
				//delete order
				driver.findElement(By.id("requesturl")).click();
				driver.findElement(By.id("sysverb_delete")).click();
				driver.findElement(By.id("ok_button")).click();
				
				//verify if order is placed
				if(driver.findElement(By.xpath("//div[text() = 'Order: Empty']")).isDisplayed()) {
					System.out.println("Order is deleted");
					}else {
					System.out.println("Order is not deleted");
				}
				driver.close();				
	}

}
