package SeleniumAss;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SalesforceContact {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/chromedriver";
		System.setProperty("webdriver.chrome.driver",driverPath );
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.id("username")).sendKeys("shubhangi.takawane@gmail.com");
		driver.findElement(By.id("password")).sendKeys("shubhangi1");
		
		/*driver.findElement(By.name("Login")).click();
		
		Thread.sleep(1000);
		
		//driver.findElement(By.id("Contact_Tab")).click();
*/		
	Actions action = new Actions(driver);
	/*//action.contextClick(driver.findElement(By.id("mydomainLink"))).sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ENTER).build().perform();*/
		
		
	WebElement source= driver.findElement(By.id("logo"));
	WebElement target= 	driver.findElement(By.id("password"));
	
	//action.dragAndDrop(source, target).build().perform();
	//action.clickAndHold(source).moveToElement(target).release().build().perform();
	
	
	
		
		
		//driver.close();
		
	}
	
}
