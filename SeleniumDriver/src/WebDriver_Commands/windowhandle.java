package WebDriver_Commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class windowhandle {

	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		driver.get("http://www.naukri.com/");
		
		 String mainWindow=driver.getWindowHandle();
		 
		Set<String> set =driver.getWindowHandles();
		
		ArrayList<String>child=new ArrayList<>(set);
		
		WebDriver window1= driver.switchTo().window(child.get(1));
		
		System.out.println(window1.getTitle());
		
		 driver.switchTo().window(mainWindow);
		 
		 for(String cw:driver.getWindowHandles()) {
			 driver.switchTo().window(cw);
			 
		 }
	}

}
