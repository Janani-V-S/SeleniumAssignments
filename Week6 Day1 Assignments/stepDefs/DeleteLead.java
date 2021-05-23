package stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	ChromeDriver driver;
	String LeadID;
	@Given("DeleteLead-Launch Chrome Browser")
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@When("DeleteLead-Load the URL {string}")
	public void loadURL(String URL) {
		driver.get(URL);
	}

	@And("DeleteLead-Enter the username {string}")
	public void enterUsername(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);
	}
	
	@And("DeleteLead-Enter the password {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	
	@And("DeleteLead-Click Login button")
	public void ClickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@And("DeleteLead-Click CRMSFA")
	public void clickLeads() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@And("Click Leads Link")
	public void clickLeadsLink() {
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@And("Click Find Leads button")
	public void clickFindLeadsButton() {
		driver.findElement(By.linkText("Find Leads")).click();		
	}
	
	@And("Click on Phone")
	public void clickPhone() {
		driver.findElement(By.xpath("//span[text() = 'Phone']")).click();
	}
	
	@And("Enter Phone Number as (.*)$")
	public void enterPhoneNumber(String phoneNumber) {
		driver.findElement(By.name("phoneNumber")).sendKeys(phoneNumber);
	}
	
	@And("Click FindLeads button")
	public void findLeads() {
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
	}
	
	@And("Capture Lead ID of first result")
	public void captureLeadID() {
		 LeadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).getText();
	}
	
	@And("Click First Resulting Lead")
	public void clickFirstLead() {
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
	}
	
	@And("Click Delete")
	public void createDelete() {
		driver.findElement(By.xpath("//a[text() = 'Delete']")).click();
	}
	
	@And("Click FindLeads")
	public void clickFindLead() {
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@And("Enter captured Lead ID")
	public void entercapturedID() {
		driver.findElement(By.xpath("//input[@name = 'id']")).sendKeys(LeadID);
	}
	
	@And("Click find Leads option")
	public void clickFindLeadsOption() {
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
	}
	
	@And("Verify the message")
	public void verifyMessage() {
		boolean isElementDisplayed = driver.findElement(By.xpath("//div[text() = 'No records to display']")).isDisplayed();
		if(isElementDisplayed)
			System.out.println("Lead is deleted");
		else
			System.out.println("Lead is not deleted");
	}

}
