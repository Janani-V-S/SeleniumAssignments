package CucumberStepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ResolveIncident extends BaseClass{
	
	@Given("Search for an existing Incident that has to be resolved (.*)$")
	public void searchForResolvingIncident(String IncidentNo) throws InterruptedException {
				//click Open
				driver.findElement(By.xpath("//div[text() = 'Open']")).click();
				
				//search for existing incident and click on the incident
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
				WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
				//String IncNo = IncidentNo;
				Thread.sleep(4000);
				searchField.sendKeys(IncidentNo);
				searchField.sendKeys(Keys.ENTER);
				
				WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
				wait.until(ExpectedConditions.textToBePresentInElement(searchRes, IncidentNo));
				searchRes.click();
				
	}
	@And("Update Incident resolution details")
	public void updateResolutionDetails() {
		//update state & resolution details
				WebElement state = driver.findElement(By.id("incident.state"));
				Select stateDropdown = new Select(state);
				stateDropdown.selectByVisibleText("Resolved");
				
				driver.findElement(By.xpath("//span[text() = 'Resolution Information']")).click();
				WebElement resCode = driver.findElement(By.id("incident.close_code"));
				Select resolutionCode = new Select(resCode);
				resolutionCode.selectByVisibleText("Solved (Permanently)");
				
				driver.findElement(By.id("incident.close_notes")).sendKeys("Incident Resolved");
				
				driver.findElement(By.id("resolve_incident")).click();
				
	}
	@Then("Verify if Incident is Resolved")
	public void verifyIncidentResolved() {
		//verify if incident is resolved
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'linked formlink']")));
		String incidentState = driver.findElement(By.xpath("(//tr[@class = 'list_row list_odd']//td)[8]")).getText();		
		if(incidentState.contains("Resolved")) {
			System.out.println("Incident is resolved");
		}
		else {
			System.out.println("Incident is not resolved");
		}
	}

}
