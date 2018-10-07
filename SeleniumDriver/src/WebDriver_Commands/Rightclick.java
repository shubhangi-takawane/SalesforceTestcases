package WebDriver_Commands;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Rightclick {


		public static void main(String[] args) throws AWTException, InterruptedException {
			
			WebDriver driver;
			String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
			System.setProperty("webdriver.gecko.driver",driverPath );
			
			driver=new FirefoxDriver();
			
			driver.get("https://login.salesforce.com/");
			
			//driver.manage().window().maximize();
			
			WebElement right_click= driver.findElement(By.linkText("Forgot Your Password?"));
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			
			action.contextClick(right_click).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

//Robot Class
		/*	
			Robot r=new Robot();
			Thread.sleep(3000);
			
			driver.findElement(By.id("username")).sendKeys("abc");
			driver.findElement(By.id("password")).sendKeys("abc");
			Thread.sleep(3000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(3000);
			
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_T);*/
			
	}

}
