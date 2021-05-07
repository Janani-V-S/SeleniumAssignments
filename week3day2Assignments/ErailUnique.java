package week3.week3day2Assignments;

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

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement sourceStation = driver.findElement(By.id("txtStationFrom"));
		sourceStation.clear();
		sourceStation.sendKeys("Salem");
		sourceStation.sendKeys(Keys.TAB);
		
		WebElement destStation = driver.findElement(By.id("txtStationTo"));
		destStation.clear();
		destStation.sendKeys("Mdu");
		destStation.sendKeys(Keys.TAB);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		Map<Integer,String> trainNamesMap = new LinkedHashMap<Integer,String>();
		//Thread.sleep(500);
		WebElement table = driver.findElement(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
		
		//Thread.sleep(200);
		
		List<WebElement> trainNames = table.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//tr/td[2]"));
		
		int sizeoftrainNames = trainNames.size();
		
		for (int i = 0; i < sizeoftrainNames; i++) {
			trainNamesMap.put(i+1, trainNames.get(i).getText());
			
		}
		System.out.println("Map size - "+trainNamesMap.size());
		System.out.println(trainNamesMap);

	}

}
