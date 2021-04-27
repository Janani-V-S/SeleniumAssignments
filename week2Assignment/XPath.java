package week2.week2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPath {

	public static void main(String[] args) {
		//1. Launch the URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//2. Enter the username based on its label
		//label[text() = 'Username']/following-sibling::input
		
		//3. Enter the password based on its label
		//label[text() = 'Password']/following-sibling::input
		
		//4. Click Login
		//form[@id = 'login']//input[@value = 'Login']
		
		//5. Click on CRMSFA link
		//div[@for = 'crmsfa']/a
		
		//6. Click on Leads link
		//a[text() = 'Leads']
		
		//7. Click on Merge Leads link
		//a[text() = 'Merge Leads']
		
		//8. Click the first img icon
		(//img[@src = '/images/fieldlookup.gif'])[1]
		
		//9. Select the first resulting lead
		//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a
		
		//10. Click the second img icon
		(//img[@src = '/images/fieldlookup.gif'])[2]
		
		//11. Select the second resulting lead
		(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a)[2]
		
		//12. Click on Merge Lead (submit) button
		//a[text() = 'Merge']
		
		//13. Get the company name text based on its label
		 driver.findElement(By.xpath("(//span[text() = 'Company Name']/following::span)[1]")).getText();

	}

}
