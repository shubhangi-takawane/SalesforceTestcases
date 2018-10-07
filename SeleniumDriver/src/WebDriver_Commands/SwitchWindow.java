package WebDriver_Commands;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

public class SwitchWindow {


	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriver driver;
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		
		driver=new FirefoxDriver();
		
		//driver.get("https://html5demos.com/drag/#");
		
	/*	WebElement btn=driver.findElement(By.id("button1"));
		btn.click();
		
		String oldWindow= driver.getWindowHandle();
		
		Set<String >getAllowWindow = driver.getWindowHandles();
		
	//	String[] getWindow = getAllowWindow.toArray(new String[getAllowWindow.])*/
		
// Load app
driver.get("http://www.naukri.com/");
 
// It will return the parent window name as a String
String parent=driver.getWindowHandle();
 
String mainwindow=driver.getWindowHandle(); //get parent(current) window name
for(String popup :driver.getWindowHandles()) //iterating on child windows
{
driver.switchTo().window(popup);
System.out.println("Popup values: "+popup);
// Perform any operations on child window
}
driver.switchTo().window(mainwindow); //switch back to main window & continue further execution
}

	}

