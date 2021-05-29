package week6Day2Assignments.POMPages;

import org.openqa.selenium.By;

import week6Day2Assignments.POMHooks.LaunchCloseBrowser;

public class LoginPage extends LaunchCloseBrowser{
	
	public LoginPage enterUsername() {
		driver.findElement(By.id("user_name")).sendKeys("admin");
		return this;
	}
	public LoginPage enterPassword() {
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		return this;
	}
	
	public ServiceNowPage clickogin() {
		driver.findElement(By.id("sysverb_login")).click();
		return new ServiceNowPage();
	}

}
