package week3.week3day2Assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("Salem");
		fromStation.sendKeys(Keys.TAB);
		
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("Mdu");
		toStation.sendKeys(Keys.TAB);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Map<String,String> tableData = new LinkedHashMap<String,String>();
		
		WebElement table = driver.findElement(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
		//List<WebElement> tableCol = new ArrayList<WebElement>();
		List<WebElement> tableRows = table.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//tr"));
		for (WebElement webElement : tableRows) {
			List<WebElement> tableCol = driver.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//tr/td"));
			for (WebElement webElement2 : tableCol) {
				if(webElement2.getText().startsWith("S")) {
					tableData.put(webElement2.getText(), webElement2.getText());
				}
			}
		}
			System.out.println(tableData);
		}
		
	}


