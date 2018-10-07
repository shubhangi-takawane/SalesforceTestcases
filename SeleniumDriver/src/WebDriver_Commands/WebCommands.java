package WebDriver_Commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebCommands {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		
		//driver.get("https://www.keynotesupport.com/websites/contact-form-example-radio-buttons.shtml");
		//driver.manage().window().maximize();
		
//radio commands
		// was able to fix it. debug as java application then this exception is no longer there.
		
		List<WebElement>radio_button =driver.findElements(By.name("software"));
		
		boolean bvalue;
		
		bvalue=radio_button.get(0).isSelected();
		
		if(bvalue==false){
			
			radio_button.get(1).click();
		}else{
		System.out.println("It is already selected, select other options");
		}
		
//select
		
		driver.get("https://www.amazon.com/");
		//driver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement selectMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
		Thread.sleep(8000);
		
		Select select=new Select(selectMenu);
		
		
		//select.selectByVisibleText("Baby");
		//select.selectByValue("Books");
		//select.selectByValue("search-a");
		//select.selectByIndex(2);
		
//mouse hover
	/*	
		driver.get("https://www.amazon.com/");
		//driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement account = driver.findElement(By.xpath("///*[@id='nav-signin-tooltip']/a/span"));
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(account).build().perform();*/
	/*	driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id='nav']/ul/li[2]/span/span/span/a"));
		Actions action = new Actions(driver);

		Thread.sleep(5000);
		action.moveToElement(element).build().perform();
					
				
		Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='nav']/ul/li[2]/ul/li/ul/li[2]/a/span")).click();*/
}
}