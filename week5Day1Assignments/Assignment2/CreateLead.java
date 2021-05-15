package week5Day1Assignments.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {

	@Test
	public void NewLead() throws InterruptedException {
		//CLick Create Lead
				driver.findElement(By.linkText("Create Lead")).click();
				
				//Enter company name, first name, last name
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Accenture");
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Janani");
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("VS");
				
				
				
				//Click Create Lead button
				driver.findElement(By.name("submitButton")).click();
				
				
				
				//Verify company name
				String text2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
				String comp = text2.replaceAll("[^a-zA-Z]", "");
				
				if(comp.equals("Accenture"))
				{
					System.out.println("New Lead is created");
				}
				else
				{
					System.out.println("New Lead is not created");
				}
		 
	}

}
