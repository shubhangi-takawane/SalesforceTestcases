package WebDriver_Commands;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebBasedPopUp {
 
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		
		driver.get("https://seleniummaster.com/llc/");
		driver.findElement(By.xpath(".//*[@id='text-3']/div/div/a/img")).click();
		
		 String Parent_Window = driver.getWindowHandle();
		// driver.switchTo().frame();
	      // Switching from parent window to child window   
	     for (String Child_Window : driver.getWindowHandles())  
	     {  
	     driver.switchTo().window(Child_Window);  
	     // Performing actions on child window  
	     driver.findElement(By.id("dropdown_txt")).click();  
	     List  dropdownitems=driver.findElements(By.xpath("//div[@id='DropDownitems']//div"));  
	     int dropdownitems_Size=dropdownitems.size();  
	     System.out.println("Dropdown item size is:"+dropdownitems_Size);  
	     
	     driver.findElement(By.xpath("//*[@id='anotherItemDiv']")).click();  
	     }  
	     //Switching back to Parent Window  
	     driver.switchTo().window(Parent_Window);  
	     //Performing some actions on Parent Window  
	     driver.findElement(By.className("btn_style")).click();  
	     }  
	      public void close() {  
	      driver.quit();  
	      }   
	     }  
	


