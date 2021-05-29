package pages;

import org.openqa.selenium.By;

import hooks.TestNGHooks;
import io.cucumber.java.en.And;

public class CreateLead extends TestNGHooks{
	
			  @And("Enter Company Name as (.*)$") 
			  public CreateLead enterCompanyName(String companyName) {
			  type(locateElement("id", "createLeadForm_companyName"), companyName);
			  return this;
			  }
			  
			  @And("Enter First Name as (.*)$") 
			  public CreateLead enterFirstName(String firstName) {
			  type(locateElement("id", "createLeadForm_firstName"), firstName);
			  return this;
			  }
			  
			  @And("Enter Last Name as (.*)$") 
			  public CreateLead enterLastName(String lastName) {
			  type(locateElement("id", "createLeadForm_lastName"), lastName);
			  return this;
			  }
			  
			  @And("Click Submit") 
			  public ViewLead clickSubmit() {
			  driver.findElement(By.name("submitButton")).click();
			  click(locateElement("name", "submitButton"));
			  return new ViewLead();
			  } 

}
