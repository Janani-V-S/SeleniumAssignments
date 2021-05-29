package hooks;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ReadExcelData;
import wrappers.BaseDriver;

public class TestNGHooks extends BaseDriver{
	
	@BeforeMethod
	public void launchBrowser() {
		startApp("chrome", "http://leaftaps.com/opentaps/control/login");
	}
	@AfterMethod
	public void closeBrowser() {
		closeActiveBrowser();
	}
	@DataProvider(name="FetchExcelData")
	public Object[][] readExcelData(){
		try {
			return ReadExcelData.readExcel("Create Lead");
		} catch (InvalidFormatException e) {
			System.err.println("The excel is in invalid format. Looks corrupted");
		} catch (IOException e) {
			System.err.println("The file does not exist");
		}
		return null;
	}

}
