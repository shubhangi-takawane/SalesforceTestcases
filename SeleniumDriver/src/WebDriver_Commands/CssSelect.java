package WebDriver_Commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CssSelect {

	public static void main(String[] args) {
		
		WebDriver driver;
	
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		
		driver.get("https://www.salesforce.com");
		driver.manage().window().maximize();
	}

}
