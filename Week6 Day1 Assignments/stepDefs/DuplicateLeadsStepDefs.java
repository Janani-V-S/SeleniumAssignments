package stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLeadsStepDefs {

	ChromeDriver driver;
	String LeadName;
	
	@Given("DuplicateLead-Launch Chrome Browser")
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@When("DuplicateLead-Load the URL {string}")
	public void loadURL(String URL) {
		driver.get(URL);
	}

	@And("DuplicateLead-Enter the username {string}")
	public void enterUsername(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);
	}
	
	@And("DuplicateLead-Enter the password {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	
	@And("DuplicateLead-Click Login button")
	public void ClickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@And("DuplicateLead-Click CRMSFA")
	public void clickLeads() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@And("Click Leads link")
	public void ClickLeadsLink() {
	driver.findElement(By.linkText("Leads")).click();
	}
			
	@And("Click Find leads")
	public void ClickFindLeads() {
	driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@And("Click on Email")
	public void clickEmail() {
		driver.findElement(By.xpath("//span[text() = 'Email']")).click();
	}
		
	@And("Enter Email as (.*)$")
	public void enterEmail(String Email) {
		driver.findElement(By.name("emailAddress")).sendKeys(Email);
	}
		
	@And("Click find leads button")
	public void clickFindLeadsButton() {	
	driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
	}
		
	@And("Capture name of First Resulting lead")
	public void captureFirstLeadName() {	
	 LeadName = driver.findElement(By.xpath("//div[@class= 'x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
	}
		
	@And("Click First Resulting lead")
	public void clickFirstResult() {
		driver.findElement(By.xpath("//div[@class= 'x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
	}
		
	@And("Click Duplicate Lead")
	public void  clickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	
	}
		
	@And("Verify the title as Duplicate Lead")
	public void verifyTitle () {
		String title = driver.getTitle();
		if(title.contains("Duplicate Lead"))
			System.out.println("Navigated to Duplicate Lead Page");
		else
			System.out.println("Not Navigated to Duplicate Lead Page");
	}
		
	@And("Click Create Lead")
	public void clickCreateLeadButton () {
		driver.findElement(By.xpath("//input[@value = 'Create Lead']")).click();
	
	}
		
	@And("Confirm the duplicated lead name is same as captured name")
	public void confirmIfLeadIsDuplicated () {
		String DupLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(LeadName.equals(DupLeadName))
			System.out.println("Lead Duplicated");
		else
			System.out.println("Lead not Duplicated");
	}
		
	@And("Close the browser")
	public void closeBrowser () {
		driver.close();
}
}
