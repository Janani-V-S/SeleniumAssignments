package CucumberStepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteIncident extends BaseClass{

	@Given("Search for the incident to be deleted (.*)$")
	public void deleteExistingIncident(String IncidentNo) {
				//click Open
				driver.findElement(By.xpath("//div[text() = 'Open']")).click();
				
				//search for existing incident and click on the incident
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
				WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
				//String IncNo = "INC0010914";
				searchField.sendKeys(IncidentNo);
				searchField.sendKeys(Keys.ENTER);
				
				WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
				wait.until(ExpectedConditions.textToBePresentInElement(searchRes, IncidentNo));
				searchRes.click();
				
	}
	@And("Delete the Incident")
	public void deleteIncident() {
		//delete incident
				driver.findElement(By.id("sysverb_delete")).click();
				driver.findElement(By.id("ok_button")).click();
				
				driver.switchTo().defaultContent();
				driver.findElement(By.xpath("//div[text() = 'Open']")).click();
				
	}
	@Then("Verify if Incident is deleted (.*)$")
	public void verifyIncidentDeletion(String IncidentNo) {
		//search for deleted incident 
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class = 'form-control']")));
				driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys(IncidentNo,Keys.ENTER);
				
				WebElement delIncident = driver.findElement(By.xpath("//td[text() = 'No records to display']"));
				boolean isIncidentDisplayed = delIncident.isDisplayed();
				
				if(isIncidentDisplayed){
					System.out.println("Incident is deleted");
				}
				else
				{
					System.out.println("Incident is not deleted");
				}
	}

}
