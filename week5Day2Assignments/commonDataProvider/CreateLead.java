package week5Day2Assignments.commonDataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {

	@DataProvider(name = "Testdata")
	public Object [][] fetchData(){
		String[][] data = new String[2][3];
		
		data[0][0] = "Accenture";
		data[0][1] = "Janani";
		data[0][2] = "VS";
		
		data[1][0] = "TestLeaf";
		data[1][1] = "TestUserFN";
		data[1][2] = "TestUserLN";
		
		return data;
	}
	
	@Test(dataProvider = "Testdata")
	public void NewLead(String companyName, String firstName, String lastName) throws InterruptedException {
				//CLick Create Lead
				driver.findElement(By.linkText("Create Lead")).click();
				
				//Enter company name, first name, last name
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
								
				//Click Create Lead button
				driver.findElement(By.name("submitButton")).click();
				
				//Verify company name
				String text2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
				String comp = text2.replaceAll("[^a-zA-Z]", "");
				
				if(comp.equals("Accenture"))
				{
					System.out.println(" New Lead is created");
				}
				else
				{
					System.out.println("New Lead is not created");
				}
		 
	}

}
