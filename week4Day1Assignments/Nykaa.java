package week4.week4Day1Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch Nykaa
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Mouseover on Brands and Mouseover on Popular
		driver.findElement(By.xpath("//a[text() = 'brands']")).click();
		driver.findElement(By.xpath("//a[text() = 'Popular']")).click();
		
		//Click L'Oreal Paris
		driver.findElement(By.xpath("(//div[@id = 'brandCont_Popular']//li)[5]")).click();
		
		//Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listwindowHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listwindowHandles.get(1));
		
		Thread.sleep(5000);
		String title = driver.getTitle();
		if (title.contains("L'Oreal Paris")) {
			System.out.println("Title contains 'L'oreal Paris'");
		}
		else {
			System.out.println("Title does not contain 'L'oreal Paris'");
		}
		
		//Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[@title = 'POPULARITY']")).click();
		driver.findElement(By.xpath("//span[text() = 'customer top rated']/following-sibling::div")).click();
		Thread.sleep(6000);
		
		//Click Category and click Shampoo
		driver.findElement(By.xpath("//div[text() = 'Category']")).click();
		driver.findElement(By.xpath("//span[text() = 'Hair']")).click();
		driver.findElement(By.xpath("//span[text() = 'Hair Care']")).click();
		driver.findElement(By.xpath("//span[text() = 'Shampoo']")).click();
		
		Thread.sleep(3000);
		//check whether the Filter is applied with Shampoo
		String filtersApplied = driver.findElement(By.xpath("//li[text() = 'Shampoo']")).getText();
		if (filtersApplied.contains("Shampoo")) {
			System.out.println("Shampoo filter is applied");
		}
		else {
			System.out.println("Shampoo filter is not applied");
		}
		
		//Click on L'Oreal Paris Colour Protect Shampoo	
		driver.findElement(By.xpath("//span[contains(text(), 'real Paris Colour Protect Shampoo')]")).click();
		
		//GO to the new window and select size as 175ml
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> listwindowHandles2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(listwindowHandles2.get(2));
		
		driver.findElement(By.xpath("//span[text() = '175ml']")).click();
		
		//Print the MRP of the product
		String mrp = driver.findElement(By.xpath("//div[@class = 'price-info']/span[2]")).getText();
		System.out.println("MRP of the product is "+mrp);
		
		//Click on ADD to BAG
		driver.findElement(By.xpath("//div[@class = 'pull-left']//button")).click();
		Thread.sleep(3000);
		
		//Go to Shopping Bag 
		driver.findElement(By.xpath("//div[@class = 'AddBagIcon']")).click();
		Thread.sleep(3000);
		
		//Print the Grand Total amount
        String grandTotal = driver.findElement(By.xpath("//div[@class = 'first-col']/div")).getText();
        String grandTot = grandTotal.replaceAll("[^0-9]", "");
        System.out.println("Grand total is "+grandTot);
        
        //Click Proceed
        driver.findElement(By.xpath("//span[text() = 'Proceed']")).click();
        //Thread.sleep(4000);
        
        //Click on Continue as Guest
        driver.findElement(By.xpath("//button[text() = 'CONTINUE AS GUEST']")).click();
        //Thread.sleep(2000);
        
        //Check if this grand total is the same in step 13
        String grandTotal1 = driver.findElement(By.xpath("//div[@class = 'payment-details-tbl grand-total-cell prl20']/div[@class = 'value']")).getText();
        String grandTot1 = grandTotal1.replaceAll("[^0-9]", "");
        
        
        if(grandTot.equals(grandTot1)) {
        	System.out.println("Grand Total matches");
        }
        else{
        	System.out.println("Grand Total does not match");
        }
        
        //Close all windows
        driver.quit();
	}

}
