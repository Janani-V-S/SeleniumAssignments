package week6Day2Assignments.POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import week6Day2Assignments.POMHooks.LaunchCloseBrowser;

public class NewIncidentPage extends LaunchCloseBrowser{
	public NewIncidentPage captureIncidentID() {
		WebElement incidentNum = driver.findElement(By.xpath("//input[@id = 'sys_original.incident.number']"));
		
		incidentNo = incidentNum.getAttribute("value");
		System.out.println("Incident number - "+incidentNo);
		return this;
	}
	public NewIncidentPage clickCaller() {
		WebElement caller = driver.findElement(By.id("sys_display.incident.caller_id"));
		caller.click();
		return this;
	}
	public NewIncidentPage clickSysAdmin() {
		WebElement systemAdministrator = driver.findElement(By.xpath("//td[text() = 'System Administrator']"));
		systemAdministrator.click();
		return this;
	}
	public NewIncidentPage enterShortDesc() {
		driver.findElement(By.id("incident.short_description")).sendKeys("test");
		return this;
	}
	public IncidentsFrame clickSubmit() {
		
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
		return new IncidentsFrame();
	}

}
