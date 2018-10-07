package WebDriver_Commands;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DragDrop {


	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriver driver;
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		
		driver=new FirefoxDriver();
		
	/*	driver.get("https://html5demos.com/drag/#");
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		WebElement from = driver.findElement(By.xpath("//*[@id='one']"));
		WebElement to = driver.findElement(By.xpath("//*[@id='bin']"));
		
		Thread.sleep(2000);
		
		Actions action = new Actions (driver);
		action.clickAndHold(from).moveToElement(to).release(to).build().perform();*/
//alert
		/*driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
		WebElement alertbox = driver.findElement(By.id("alert"));
		alertbox.click();
		
		Alert alert = driver.switchTo().alert();
		String alertText= alert.getText();
		System.out.println(alertText);
		Thread.sleep(4000);
		alert.accept();*/
//iframe
		driver.get("http://toolsqa.com/iframe-practice-page/");
		//driver.switchTo().frame(0);
	//	System.out.println("I am inside frame");
		
		//driver.switchTo().frame("iframe1");
		//driver.switchTo().frame("IF1");
	//	WebElement myframe=driver.findElement(By.xpath("//*[@id='IF1']"));
		//driver.switchTo().frame(myframe);
		//System.out.println("I am inside frame1");
		
		java.util.List<WebElement> myframe = driver.findElements(By.tagName("iframe"));
		
		System.out.println("frame size"+myframe.size());
		driver.switchTo().frame(0);
		System.out.println("iside frame");
		driver.switchTo().defaultContent();
		System.out.println("Outside frame");
		Thread.sleep(3000);
		driver.quit();
		
	}

}
