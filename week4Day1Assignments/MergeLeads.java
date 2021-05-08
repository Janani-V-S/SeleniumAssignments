package week4.week4Day1Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeads {

	public static void main(String[] args) throws InterruptedException {
		
		 // Launch URL "http://leaftaps.com/opentaps/control/login"
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/login");
		  
		 // Enter UserName and Password Using Id Locator
		 driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		 
		 // Click on Login Button using Class Locator
		 driver.findElement(By.className("decorativeSubmit")).click();
		  
		 // Click on CRM/SFA Link
		 driver.findElement(By.linkText("CRM/SFA")).click();
		  
		 // Click on contacts Button
		 driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();
		 
		 // Click on Merge Contacts using Xpath Locator
		 driver.findElement(By.xpath("//a[text() = 'Merge Contacts']")).click();
		 
		 // Click on Widget of From Contact
		 driver.findElement(By.xpath("//span[text() = 'From Contact']/following::img")).click();
		 
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> listWindowHandles = new ArrayList<String>(windowHandles);
		 driver.switchTo().window(listWindowHandles.get(1));
		 
		 Thread.sleep(5000);
		 // Click on First Resulting Contact
		 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		  
		 driver.switchTo().window(listWindowHandles.get(0));
		 // Click on Widget of To Contact
		 driver.findElement(By.xpath("(//span[text() = 'From Contact']/following::img)[2]")).click();
		  
		 Set<String> windowHandles1 = driver.getWindowHandles();
		 List<String> listWindowHandles1 = new ArrayList<String>(windowHandles1);
		 driver.switchTo().window(listWindowHandles1.get(1));
		 
		 Thread.sleep(5000);
		 // Click on Second Resulting Contact
		 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		 
		 driver.switchTo().window(listWindowHandles.get(0));
		 // Click on Merge button using Xpath Locator
		 driver.findElement(By.xpath("//a[text() = 'Merge']")).click();
		  
		 // Accept the Alert
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		  
		 // Verify the title of the page
		 Thread.sleep(5000);
		 String title = driver.getTitle();
		 System.out.println(title);
	}

}
