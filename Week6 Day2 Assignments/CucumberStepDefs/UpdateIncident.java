package CucumberStepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpdateIncident extends BaseClass{
	
	@Given("Search for the Incident (.*)$")
	public void searchIncident(String IncidentNo) {
		driver.findElement(By.xpath("//div[text() = 'Incidents']")).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		//search for existing incident and click on it
		//driver.switchTo().frame("gsft_main");
				WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
				String IncNo = IncidentNo;
				searchField.sendKeys(IncidentNo);
				searchField.sendKeys(Keys.ENTER);
				
				
				WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
				wait.until(ExpectedConditions.textToBePresentInElement(searchRes, IncNo));
				searchRes.click();
				
				
	}
	@And("Update Incident Urgency and State")
	public void updateIncident() {
		//update Urgency and State
				WebElement urgency = driver.findElement(By.id("incident.urgency"));
				urgency.click();
				Select urgencyDropdown = new Select(urgency);
				urgencyDropdown.selectByVisibleText("1 - High");
				
				WebElement state = driver.findElement(By.id("incident.state"));
				state.click();
				Select stateDropdown = new Select(state);
				stateDropdown.selectByVisibleText("In Progress");
				
				driver.findElement(By.id("sysverb_update")).click();
				
		
	}
	@Then("Verify if Incident is updated")
	public void verifyIncident() {
		//verify if updated
		
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'linked formlink']"))).click();
				WebElement priority = driver.findElement(By.xpath("(//span[text()='Priority']/following::span)[1]"));
				String incidentPriority = priority.getText();
						
				WebElement state1 = driver.findElement(By.xpath("(//span[text()='Incident state']/following::span)[1]"));
				String incidentState = state1.getText();
				
				if(incidentPriority.contains("3 - Moderate") && incidentState.contains("In Progress")) {
					System.out.println("Incident is updated");
				}
	}

}
