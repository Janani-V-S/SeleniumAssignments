package week6Day2Assignments.POMTests;

import org.testng.annotations.Test;

import week6.day1POM.LoginPage;
import week6Day2Assignments.POMHooks.LaunchCloseBrowser;

public class CreateNewIncident extends LaunchCloseBrowser {
	
	@Test
	public void CreateInc() throws InterruptedException {
		new week6Day2Assignments.POMPages.LoginPage().enterUsername().enterPassword().clickogin().typeIncident().clickEnter().clickNew().captureIncidentID().clickCaller().clickSysAdmin().enterShortDesc().clickSubmit().enterIncidentNo().verifyNewIncident();		
	}

}
