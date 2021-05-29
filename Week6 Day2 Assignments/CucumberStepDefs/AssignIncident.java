package CucumberStepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AssignIncident extends BaseClass{
	
	@Given("Click Open and Search for an existing incident and open it (.*)$")
	public void searchExistingIncident(String IncidentNo) {
				//click Open
				driver.findElement(By.xpath("//div[text() = 'Open']")).click();
				
				//search for existing incident and click on the incident
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
				WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
				//String IncNo = IncidentNo;
				searchField.sendKeys(IncidentNo);
				searchField.sendKeys(Keys.ENTER);
				
				WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
				wait.until(ExpectedConditions.textToBePresentInElement(searchRes, IncidentNo));
				searchRes.click();
				
	}
	@And("Assign Incident and Update Worknotes")
	public void updateAssignmentDetails() {
				//update Assignment Group & Assigned to
				WebElement assignmentGroup = driver.findElement(By.id("sys_display.incident.assignment_group"));
				
				assignmentGroup.clear();
				assignmentGroup.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Recent selections']/following::span[text() = 'Software']"))).click();
						
				WebElement assignedTo = driver.findElement(By.id("sys_display.incident.assigned_to"));
				
				assignedTo.clear();
				assignedTo.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text() = 'ITIL User']"))).click();
				
				driver.findElement(By.id("activity-stream-textarea")).sendKeys("In progress");
				
				driver.findElement(By.id("sysverb_update")).click();
				
				
	}
	@Then("Verify if Incident is assigned")
	public void verifyIncidentAssignment() {
		//verify if assigned to and assignment group are updated
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'linked formlink']")));
				WebElement updatedAssignmentGrp = driver.findElement(By.xpath("(//a[@class = 'linked'])[2]"));
				
				WebElement updatedAssignedTo = driver.findElement(By.xpath("(//a[@class = 'linked'])[3]"));
				
				if((updatedAssignmentGrp.getText()).equals("Software") && (updatedAssignedTo.getText()).equals("ITIL User")){
					System.out.println("Assignment Group & Assigned To details are updated");
				}
				else
				{
					System.out.println("Assignment Group & Assigned To details are not updated");
				}
	}

}
