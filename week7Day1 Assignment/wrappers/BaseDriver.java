package wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver implements Browser, Element, Select, TargetLocator {

	public static RemoteWebDriver driver;

	@Override
	public boolean startApp(String browser, String url) {

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser "+browser+" is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
			return true;

		} catch (Exception e) {
			System.err.println("The browser "+browser+" could not be launched");
			return false;
		}

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> allWindows = new ArrayList<>(windowHandles);
			String windowHandle = allWindows.get(index);
			driver.switchTo().window(windowHandle);
			System.out.println("The control is switched to the window of index "+index);
		} catch (Exception e) {
			System.err.println("The control is switched to the window of index "+index);
		}
	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			System.out.println("Control is switched to the Frame");
		} catch (Exception e) {
			System.err.println("Control is not switched to the Frame");
		}

	}

	@Override
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("Alert accepted");
		} catch (Exception e) {
			System.out.println("Alert not accepted");
		}

	}

	@Override
	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			System.out.println("Alert dismissed");
		} catch (Exception e) {
			System.out.println("Alert is not dismissed");
		}

	}

	@Override
	public String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert text is "+alertText);
		} catch (Exception e) {
			System.out.println("Alert text could not be captured");
		}
		return null;
	}

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value) {		
		try {
			org.openqa.selenium.support.ui.Select dd = new org.openqa.selenium.support.ui.Select(ele);
			dd.selectByVisibleText(value);
			System.out.println("Option is selected with visible text "+value);
		} catch (Exception e) {
			System.out.println("Option could not be selected with visible text "+value);
		}
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			org.openqa.selenium.support.ui.Select dd = new org.openqa.selenium.support.ui.Select(ele);
			dd.selectByValue(value);
			System.out.println("Option is selected with given value "+value);
		} catch (Exception e) {
			System.out.println("Option is not selected with given value"+value);
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			org.openqa.selenium.support.ui.Select dd = new org.openqa.selenium.support.ui.Select(ele);
			dd.selectByIndex(index);
			System.out.println("Option is selected with given index "+index);
		} catch (Exception e) {
			System.out.println("Option is not selected with given value "+index);
		}

	}

	@Override
	public void type(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element "+ele+" is typed with the value "+ele);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+ele);
		}

	}

	@Override
	public void click(WebElement ele) {	
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be clicked");
		}

	}

	@Override
	public String getText(WebElement ele) {
		try {
			String textOfElement = ele.getText();
			System.out.println("The element text is "+textOfElement);
		} catch (Exception e) {
			System.out.println("The element text could not be retrived");
		}	
		return null;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			String textOfElement = ele.getText();
			if(textOfElement.equals(expectedText)) {
				System.out.println("Text matches");
			}
		} catch (Exception e) {
			System.out.println("Text does not match");
		}

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			String textOfElement = ele.getText();
			if(textOfElement.contains(expectedText)) {
				System.out.println("Text matches");
			}
		} catch (Exception e) {
			System.out.println("Text does not match");
		}

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String value1 = ele.getAttribute(value);
			if(value.equals(value1)) {
				System.out.println("Attribute Matches");
			}
		} catch (Exception e) {
			System.out.println("Attributes does not match");
		}

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String value1 = ele.getAttribute(value);
			if(value.contains(value1)) {
				System.out.println("Attribute Matches partially");
			}
		} catch (Exception e) {
			System.out.println("Attributes does not match");
		}
	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			boolean selected = ele.isSelected();
			if(selected) {
				System.out.println("Element is selected");
			}
		} catch (Exception e) {
			System.err.println("Element is not selected");
		}

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			boolean displayed = ele.isDisplayed();
			if(displayed) {
				System.out.println("Element is displayed");
			}
		} catch (Exception e) {
			System.err.println("Element is not displayed");
		}

	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator.toLowerCase()) {
			case "id": return driver.findElement(By.id(locValue));
			case "name": return driver.findElement(By.name(locValue));
			case "link": return driver.findElement(By.linkText(locValue));
			case "class": return driver.findElement(By.className(locValue));
			case "tag": return driver.findElement(By.tagName(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "css": return driver.findElement(By.cssSelector(locValue));
			case "partial": return driver.findElement(By.partialLinkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator "+locator+" with value "+locValue);
		}
		return null;

	}

	@Override
	public boolean verifyExactTitle(String expectedTitle) {
		try {
			String title = driver.getTitle();
			if(title.equals(expectedTitle)) {
				System.out.println("Title matches");
			}
		} catch (Exception e) {
			System.err.println("Title does not match");
		}
		return false;
	}

	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		try {
			String title = driver.getTitle();
			if(title.contains(expectedTitle)) {
				System.out.println("Title matches partially");
			}
		} catch (Exception e) {
			System.err.println("Title does not match");
		}
		return false;
	}

	@Override
	public void closeActiveBrowser() {
		try {
			driver.close();
			System.out.println("Active Browser is closed");
		} catch (Exception e) {
			System.err.println("Active Browser is not closed");
		}

	}

	@Override
	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("All Browsers are closed");
		} catch (Exception e) {
			System.out.println("All Browsers are not closed");
		}

	}
}
