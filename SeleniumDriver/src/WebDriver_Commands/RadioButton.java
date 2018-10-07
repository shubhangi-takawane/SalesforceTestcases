package WebDriver_Commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		
		
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		
		List<WebElement> radio = driver.findElements(By.name("group1"));
		
		System.out.println(radio.get(0).getAttribute("Value") + " -- " + radio.get(0).getAttribute("checked"));
		Thread.sleep(5000);
	System.out.println(radio.get(1).getAttribute("Value") + " -- " + radio.get(1).getAttribute("checked"));
		System.out.println(radio.get(2).getAttribute("Value") + " -- " + radio.get(2).getAttribute("checked"));
				
		Thread.sleep(5000);
		radio.get(0).click();
		
		System.out.println("********************************");
		
		System.out.println(radio.get(0).getAttribute("Value") + " -- " + radio.get(0).getAttribute("checked"));
		System.out.println(radio.get(1).getAttribute("Value") + " -- " + radio.get(1).getAttribute("checked"));
		System.out.println(radio.get(2).getAttribute("Value") + " -- " + radio.get(2).getAttribute("checked"));
		
			
	
	
	}

}
