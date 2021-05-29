package pages;

import hooks.TestNGHooks;
import io.cucumber.java.en.And;

public class Home extends TestNGHooks{
	@And("Click CRMSFA") 
	public MyHome clickCRMSFA() {
	click(locateElement("link", "CRM/SFA"));
	return new MyHome();
	}
	

}
