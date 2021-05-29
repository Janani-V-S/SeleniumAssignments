package pages;

import hooks.TestNGHooks;
import io.cucumber.java.en.And;

public class Login extends TestNGHooks{
	
	@And("Enter the username {string}")
	public Login typeUsername(String Username) {
		type(locateElement("id", "username"), Username);
		return this;
	}
	
	@And("Enter the password {string}")
	public Login typePassword(String password) {
		type(locateElement("id", "password"), password);
		return this;
	}
	@And("Click Login button")
	public Home clickLogin() {
		click(locateElement("class", "decorativeSubmit"));
		return new Home();
	}
		  
}
