package InterviewP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaleforeceLogin {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/chromedriver";
		System.setProperty("webdriver.chrome.driver",driverPath );
		driver=new ChromeDriver();
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://login.salesforce.com");
	
		 
		 List<WebElement> list= driver.findElements(By.tagName("a"));
		
		 System.out.println(list.size());
		/* 
		 for(int i=0; i<list.size(); i++) {
			 
			 System.out.println("i= "+i+list.get(i).getText());
		 }*/
		 
		/*for(int i=2; i<list.size(); ) {
			
			list.get(i).click();
			if(driver.getTitle().equals("notWorkingUrlTitle")) {
				System.out.println("url is working");
			}else {
				System.out.println("Not working");
			}
			Thread.sleep(1000);
			driver.navigate().back();
		}	*/ 
		 /*
		 List<String> hrefs = new ArrayList<String>();
		 List<WebElement> anchors = driver.findElements(By.tagName("a"));
		 for ( WebElement anchor : anchors ) {
		     hrefs.add(anchor.getAttribute("href"));
		 }
		 for ( String href : hrefs ) {
		     driver.get(href);           
		 }
		*/
		
		
	}

}
