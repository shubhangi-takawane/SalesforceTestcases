package WebDriver_Commands;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RobotClass {
	
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		
		 driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/"); // sample url	
	        Robot robot = new Robot();	
	       
	        robot.mouseMove(630, 420); // move mouse point to specific location	
	        robot.delay(1500);// delay is to make code wait for mentioned milliseconds before executing next step	
	       
	        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click	
	        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click	
	        robot.delay(1500);	
	        
	        robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button	
	        Thread.sleep(2000);	
	        robot.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(5000);
}
}