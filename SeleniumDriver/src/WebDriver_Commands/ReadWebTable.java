package WebDriver_Commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadWebTable {

	
	public static void main(String[] args) {
		
		WebDriver driver;
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//driver.manage().window().maximize();
		
		WebElement table=driver.findElement(By.xpath("//*[@id='main']/div[3]/div"));
		List <WebElement> rows=table.findElements(By.tagName("tr"));
		
		for(int rnum=0; rnum<rows.size(); rnum++){
			List<WebElement > header= rows.get(rnum).findElements(By.tagName("th"));
	
		for(int head=0; head<header.size(); head++){
			System.out.print(header.get(head).getText()+" ");
		}
		header= rows.get(rnum).findElements(By.tagName("td"));
		
		for(int head=0; head<header.size(); head++){
			System.out.print(header.get(head).getText()+" ");
			}
		System.out.println();
		}
		
	}

}
