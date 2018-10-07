package SeleniumTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


	public class SeleniumTestScript_1 {
		public static WebDriver driver;
		
		public static void NavigateToXERO_TC01() throws InterruptedException{
			
			String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
			System.setProperty("webdriver.gecko.driver",driverPath );
			
			driver=new FirefoxDriver();
			driver.get("https://login.xero.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String applicationTitle=driver.getTitle();
			if(applicationTitle.contains("Xero"))
				System.out.println("Xero application page is displayed");
			else
				System.out.println("Xero application page is not displayed");
			
			driver.findElement(By.id("email")).sendKeys("shubhangi.takawane@gmail.com");
			driver.findElement(By.id("password")).sendKeys("shubhangi1");
			driver.findElement(By.id("submitButton")).click();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String actualText=driver.findElement(By.xpath(".//*[@id='root']/div/div/div[1]/div[1]/div[1]/div/div[1]/div")).getText();
			String expString="Welcome to Xero";
			
			if(actualText.equalsIgnoreCase(expString))
				System.out.println("User's Home Page is displayed");
			else
				System.out.println("eUser's Home Page is not displayed");
			
			driver.close();
		}
		
		public static void 	IncorrectPassword_01B() throws InterruptedException{
					
			String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
			System.setProperty("webdriver.gecko.driver",driverPath );
			
			driver=new FirefoxDriver();
			driver.get("https://login.xero.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String applicationTitle=driver.getTitle();
			if(applicationTitle.contains("Xero"))
				System.out.println("Xero application page is displayed");
			else
				System.out.println("Xero application page is not displayed");
			
			driver.findElement(By.id("email")).sendKeys("shubhangi.takawane@gmail.com");
			driver.findElement(By.id("password")).sendKeys("abc");
			driver.findElement(By.id("submitButton")).click();
			
			String actualText=driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText();
			String expString="Your email or password is incorrect";
			
			if(actualText.equalsIgnoreCase(expString))
				System.out.println("error message 'Your Email or Password is incorrect'");
			else
				System.out.println("error message is not verified...testcase failed");
			driver.close();
			
		}

		public static void 	IncorrectEmail_01C() throws InterruptedException{
			
			String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
			System.setProperty("webdriver.gecko.driver",driverPath );
			
			driver=new FirefoxDriver();
			driver.get("https://login.xero.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String applicationTitle=driver.getTitle();
			if(applicationTitle.contains("Xero"))
				System.out.println("Xero application page is displayed");
			else
				System.out.println("Xero application page is not displayed");
			
			driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
			driver.findElement(By.id("password")).sendKeys("abc");
			driver.findElement(By.id("submitButton")).click();
			
			String actualText=driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText();
			String expString="Please activate your account by following the instructions emailed to you.";
			
			if(actualText.equalsIgnoreCase(expString))
				System.out.println("error message is verified");
			else
				System.out.println("error message is not verified...testcase failed");
			driver.close();
			
		}

		public static void NavigateToXERO_01D() throws InterruptedException{
			
			String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
			System.setProperty("webdriver.gecko.driver",driverPath );
			
			driver=new FirefoxDriver();
			driver.get("https://login.xero.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String applicationTitle=driver.getTitle();
			if(applicationTitle.contains("Xero"))
				System.out.println("Xero application page is displayed");
			else
				System.out.println("Xero application page is not displayed");
			
			driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/a")).click();
			
			String actualText=driver.findElement(By.xpath(".//*[@id='contentTop']/div[1]/p")).getText();
			String expString="To reset your password, enter the email address you use to login to Xero. A link will be emailed to this address which will let you reset your password.";
			
			if(actualText.equalsIgnoreCase(expString))
				System.out.println("Password reset message page is displayed");
			else
				System.out.println("Password reset message page is not displayed");
			driver.close();
			
		}

	
	public static void main(String[] args) throws InterruptedException {
		//NavigateToXERO_TC01();
		//IncorrectPassword_01B();
		//IncorrectEmail_01C();
		//NavigateToXERO_01D();
	}

}
