package WebDriver_Commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeybordOpertion {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
	String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
	System.setProperty("webdriver.gecko.driver",driverPath );
	driver=new FirefoxDriver();
	
	driver.get("https://login.salesforce.com/");
	
	//driver.manage().window().maximize();
	
	WebElement Username= driver.findElement(By.id("username"));
	
	//Keyboard keyboard= ((HasInputDevices)driver).
}
}