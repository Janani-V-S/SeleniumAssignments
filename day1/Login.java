package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		
		//Enter LogiID
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		//Enter Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");;
		
		//Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Verify if logged in
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		
		//Click CRM SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//CLick Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter company name, first name, last name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Accenture");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Janani");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("VS");
		
		//Click Source as Partner
		WebElement dd = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select SourceDropdown = new Select(dd);
		SourceDropdown.selectByVisibleText("Partner");
		
		//Marketing Campaign
		WebElement dd7 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select camp = new Select(dd7);
		camp.selectByValue("9002");
		
		//First Name Local
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("test First Name Local");
		
		//Last Name Local
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("test lastname");
		
		//Salutation
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("MS");
		
		//Birth Date
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("06/26/94");
		
		//Title
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("test title");
		
		//Department
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("dept");
		
		//Annual Revenue
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("12345678");
		
		//Preferred Currency
		WebElement dd2 = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select prefCurr = new Select(dd2);
		prefCurr.selectByValue("ARA");
		
		//Industry
		WebElement dd3 = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select industry = new Select(dd3);
		industry.selectByIndex(1);
		
		//NoOfEmployees
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("4");
		
		//Ownership
		WebElement dd4 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownership = new Select(dd4);
		ownership.selectByVisibleText("LLC/LLP");
		
		//SIC Code
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("SIC Code test");
		
		//Ticker Symbol
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("Tick Sym");
		
		//Description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Desc");
		
		//Important note
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Notes");
		
		//Country Code
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("4");
		
		//Area code
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("44");
		
		//Phone number
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("123242342");
		
		//Extension
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("090");
		//Person to ask for
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("test person");
		
		//Email address
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Emailaddr@gmail.com");
		
		//Web URL
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("web URL test");
		
		//To Name
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Test to Name");
		
		//Attention Name
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Attn Name");
		
		//Address Line 1
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("add1");
		
		//Address Line 2
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("add2");
		
		//City
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("test city");
		
		//State/Province
		WebElement dd5 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select StateOrProvince = new Select(dd5);
		StateOrProvince.selectByVisibleText("Texas");
		
		//ZIP/Postal Code
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("232323");
		
		//Country
		WebElement dd6 = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select country = new Select(dd6);
		country.selectByVisibleText("Korea, Republic Of");
		
		//ZIP/Postal code extension
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("456");
		
		//Click Create Lead button
		driver.findElement(By.name("submitButton")).click();
		
		//Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//Change Company
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		
		//Click Create Lead button
		driver.findElement(By.name("submitButton")).click();
		
		//Verify company name
		String text2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String comp = text2.replaceAll("[^a-zA-Z]", "");
		System.out.println(comp);
		
		if(comp.equals("TCS"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		//Close driver
		driver.close();
	}
}
