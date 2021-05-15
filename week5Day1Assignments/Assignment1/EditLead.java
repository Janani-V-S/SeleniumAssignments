package week5Day1Assignments.Assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseClass{

	@Test
	public void EditExistingLead() throws InterruptedException {
							
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
		}

}
