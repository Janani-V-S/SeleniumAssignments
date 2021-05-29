package week6Day2Assignments.POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import week6Day2Assignments.POMHooks.LaunchCloseBrowser;

public class ServiceNowPage extends LaunchCloseBrowser{
	WebElement searchFilter;
	public ServiceNowPage typeIncident() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text() = 'Homepage'])[1]")));
		 searchFilter = driver.findElement(By.id("filter"));
		searchFilter.sendKeys("Incident");
		return this;
	}
	public IncidentsFrame clickEnter() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[text() = 'Homepage'])[1]")));
		searchFilter.sendKeys(Keys.ENTER);
		return new IncidentsFrame();
	}

}
