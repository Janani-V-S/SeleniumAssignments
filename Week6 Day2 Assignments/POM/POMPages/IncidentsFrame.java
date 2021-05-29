package week6Day2Assignments.POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import week6Day2Assignments.POMHooks.LaunchCloseBrowser;

public class IncidentsFrame extends LaunchCloseBrowser{
	

	public NewIncidentPage clickNew() {
		driver.findElement(By.xpath("//div[text() = 'Create New']")).click();
		driver.switchTo().frame("gsft_main");
		return new NewIncidentPage();
				
	}
	
	public IncidentsFrame enterIncidentNo() throws InterruptedException {
System.out.println("Incident number - "+incidentNo);
		
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[text() = 'Incidents']")).click();
		driver.switchTo().frame("gsft_main");
		WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control']"));
		searchField.sendKeys(incidentNo);
		searchField.sendKeys(Keys.ENTER);
		return this;
	}
	
	public IncidentsFrame verifyNewIncident() {
		WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
		System.out.println(searchRes.getText());
		wait.until(ExpectedConditions.textToBePresentInElement(searchRes, incidentNo));
		String compStr = searchRes.getText();
		
		if(incidentNo.equals(compStr)) {
			System.out.println("New incident is created");
		}
		else{
			System.out.println("New incident is not created");
		}
	return this;	
	}
	
	public UpdateIncident clickSearchedIncident() {
		WebElement searchRes = driver.findElement(By.xpath("//a[@class = 'linked formlink']"));
		wait.until(ExpectedConditions.textToBePresentInElement(searchRes, incidentNo));
		searchRes.click();
		return new UpdateIncident();
	}
	
}
