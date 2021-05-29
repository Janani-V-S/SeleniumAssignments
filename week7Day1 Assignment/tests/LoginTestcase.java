package tests;

import org.testng.annotations.Test;

import hooks.TestNGHooks;
import pages.Login;

public class LoginTestcase extends TestNGHooks {
	
	@Test(dataProvider = "FetchExcelData")
	public void LoginLeafTaps(String Username, String Password,String companyName, String firstName,String lastName) {
		new Login()
		.typeUsername(Username)
		.typePassword(Password)
		.clickLogin()
		.clickCRMSFA()
		.clickCreateLead()
		.enterCompanyName(companyName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.clickSubmit()
		.verifyIfLeadIsCreated();
	}

}
