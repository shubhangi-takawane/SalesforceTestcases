package SeleniumAss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Links {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000); 
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
 
		System.out.println(links.size());
 
		for (int i = 1; i<=links.size(); i=i++)
 
		{
 
			System.out.println(links.get(i).getText());//print the all links available in webpage
 
		}

		/*for (int i = 1; i<=links.size(); i=i++)
 
		{
 
			links.get(i).click();//print the all links available in webpage
			driver.navigate().back();
			break;
		}*/
	}
}
