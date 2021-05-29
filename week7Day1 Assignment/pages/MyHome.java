package pages;

import hooks.TestNGHooks;
import io.cucumber.java.en.And;

public class MyHome extends TestNGHooks{
	
	  
	@And("Click Create Leads") 
	public CreateLead clickCreateLead() {
	click(locateElement("link", "Create Lead"));
	return new CreateLead();
	}

}
