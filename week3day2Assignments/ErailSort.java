package week3.week3day2Assignments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		WebElement sourceStation = driver.findElement(By.id("txtStationFrom"));
		sourceStation.clear();
		sourceStation.sendKeys("Salem");
		sourceStation.sendKeys(Keys.TAB);
		
		WebElement destStation = driver.findElement(By.id("txtStationTo"));
		destStation.clear();
		destStation.sendKeys("Mdu");
		destStation.sendKeys(Keys.TAB);
		
		WebElement table = driver.findElement(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
		
		List<WebElement> trainNames = table.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//tr/td[2]"));
		List<String> sortedTrainNames = new ArrayList<String>();
		
		for (int i = 0; i < trainNames.size(); i++) {
			sortedTrainNames.add(i,trainNames.get(i).getText());
		}
		Collections.sort(sortedTrainNames);
		System.out.println(sortedTrainNames);
		

	}

}
