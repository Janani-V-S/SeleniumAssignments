package week2.week2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		//1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
			
		//2	Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			  
		//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
				
		//4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
				
		//5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
				
		//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
				
		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//8	Click on Email
		driver.findElement(By.xpath("//span[text() = 'Email']")).click();
		
		//9	Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("ccc@gmail.com");
		
		//10	Click find leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		Thread.sleep(4000);
		
		//11	Capture name of First Resulting lead
		String LeadName = driver.findElement(By.xpath("//div[@class= 'x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		
		//12	Click First Resulting lead
		driver.findElement(By.xpath("//div[@class= 'x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		Thread.sleep(4000);
		
		//13	Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(4000);
		
		//14	Verify the title as 'Duplicate Lead'
		String title = driver.getTitle();
		if(title.contains("Duplicate Lead"))
			System.out.println("Navigated to Duplicate Lead Page");
		else
			System.out.println("Not Navigated to Duplicate Lead Page");
		
		//15	Click Create Lead
		driver.findElement(By.xpath("//input[@value = 'Create Lead']")).click();
		Thread.sleep(4000);
		
		//16	Confirm the duplicated lead name is same as captured name
		String DupLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(LeadName.equals(DupLeadName))
			System.out.println("Lead Duplicated");
		else
			System.out.println("Lead not Duplicated");
		
		//17	Close the browser (Do not log out)
		driver.close();
	}

}
