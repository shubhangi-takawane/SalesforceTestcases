package WebDriver_Commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxAccess {

	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		
		/*WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
		username.sendKeys("shubhangi.takawane@gmail.com");
		
		WebElement passwd = driver.findElement(By.xpath("//*[@id='password']"));
		passwd.sendKeys("gondukanha12");
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='Login']"));
		loginButton.click();*/
		
        Thread.sleep(5000);
		
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        
		System.out.println(links.size());
 
		for (int i = 1; i<=links.size(); i=i+1)
 
		{
 
			System.out.println(links.get(i).getText());
 
		}

	}

}
