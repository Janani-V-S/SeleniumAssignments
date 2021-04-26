package week2.week2Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		
		
		// 1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//2	Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
				  
		//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
						
		//4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
						
		//5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
						
		//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
					
		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(5000);
		
		// 8	Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Janani");
		
		//10	Click find leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		Thread.sleep(4000);
				
		//12	Click First Resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		
		// 11 Verify title of the page
		String title = driver.getTitle();
		if(title.contains("View Lead"))
			System.out.println("Lead is viewed");
		else
			System.out.println("Lead is not viewed");
		String oldCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String comp1 = oldCompanyName.replaceAll("[^a-zA-Z]", "");
		System.out.println("Company Name-"+comp1);
		
		// 12 Click Edit
		driver.findElement(By.xpath("//a[text() = 'Edit']")).click();
		
		// 13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Acc");
		
		// 14 Click Update
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
		
		// 15 Confirm the changed name appears
		String newCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String comp2 = newCompanyName.replaceAll("[^a-zA-Z]", "");
		System.out.println("Updated Company Name-"+comp2);
		
		if(comp1.equals(comp2))
			System.out.println("Lead edit is not done");
		else
			System.out.println("Lead Edit is done");
		
		// 16 Close the browser (Do not log out)
		driver.close();

	}

}
