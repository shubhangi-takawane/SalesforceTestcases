package SeleniumTest;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTestScript_2 {
	
		public static WebDriver driver;
		
		public static void SignUpForFreeTrail_TC02() throws InterruptedException, AWTException{
			
			driver=ReusableMethode.launchBrowser("chrome");
			
			driver.get("https://www.xero.com/us/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String applicationTitle=driver.getTitle();
			if(applicationTitle.contains("Xero"))
				System.out.println("Xero application page is displayed");
			else
				System.out.println("Xero application page is not displayed");

//click on free trial icon
			driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click();
			String actualText=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText();
			String expString="30 day free trial";
			
			if(actualText.equalsIgnoreCase(expString))
				System.out.println("30 day free trial page is displayed");
			else
				System.out.println("30 day free trial page is not displayed");
}		
		public static void SignUpToXDC_TC02A() throws InterruptedException, AWTException{
			
			String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
			System.setProperty("webdriver.gecko.driver",driverPath );
			
			driver=new FirefoxDriver();
			driver.get("https://www.xero.com/us/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String applicationTitle=driver.getTitle();
			if(applicationTitle.contains("Xero"))
				System.out.println("Xero application page is displayed");
			else
				System.out.println("Xero application page is not displayed");

//click on free trial icon
			driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click();
			String actualText=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText();
			String expString="30 day free trial";
			
			if(actualText.equalsIgnoreCase(expString))
				System.out.println("30 day free trial page is displayed");
			else
				System.out.println("30 day free trial page is not displayed");
			
//Enter the informaton
		
			driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input")).sendKeys("shubhangi");
			
			driver.findElement(By.name("LastName")).sendKeys("Takawane");
			
			driver.findElement(By.name("EmailAddress")).sendKeys("shubhangi.takawane@gmail.com");
			
			driver.findElement(By.name("PhoneNumber")).sendKeys("6503347628");
			

			WebElement selectMenu = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[6]/label/span/select"));
			Thread.sleep(8000);
			
			Select select=new Select(selectMenu);
			
			select.selectByVisibleText("United States");
			
			Thread.sleep(2000);
			
//check terms and policy
			driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/input")).click();
			
			System.out.println("cannot automate captcha in selenium");
			
			driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button")).click();

			driver.close();
}

		public static void SignUpToXDC_TC02B() throws InterruptedException, AWTException{
			
			driver=ReusableMethode.launchBrowser("chrome");
			
			driver.get("https://www.xero.com/us/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String applicationTitle=driver.getTitle();
			if(applicationTitle.contains("Xero"))
				System.out.println("Xero application page is displayed");
			else
				System.out.println("Xero application page is not displayed");

//click on free trial icon
			driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click();
		
			String actualText=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText();
			String expString="30 day free trial";
			
			if(actualText.equalsIgnoreCase(expString))
				System.out.println("30 day free trial page is displayed");
			else
				System.out.println("30 day free trial page is not displayed");
			
//getstarted
			Thread.sleep(3000);
			WebElement getStart= driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button"));
		
			
			if(getStart.isEnabled()) {
			    System.out.println("Enabled");
			    getStart.click();
			}

			Thread.sleep(2000);
			List<WebElement> list=(List<WebElement>) driver.findElement(By.className("form-error-message"));
			
			String[] options= new String[] {"First name can't be empty","Last name can't be empty","Email address can't be empty","Phone number can't be empty"};
			
			List<String> expList=new ArrayList<String>(Arrays.asList(options));
			
			ArrayList<String> actData =new ArrayList<String>();
			for(WebElement ele: list){
				actData.add(ele.getText().trim());
			}
			
			System.out.println(actData);
			
			if(actData.equals(expList))
				System.out.println("Error message is displayed");
			else
				System.out.println("Error message is not displayed");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input")).sendKeys("abc");
		
			String email=driver.findElement(By.xpath("//*[@id='signup-form-error-message-4']")).getText();
		
			if(email.contains("Email address is invalid"))
			System.out.println("Email id is invalid");
			else
			System.out.println("Email id is vaild");
		
			Thread.sleep(3000);	
			driver.close();
			
		}
		
		public static void SignUpToXDC_TC02C() throws InterruptedException, AWTException{
			
			SignUpForFreeTrail_TC02();
			
			driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[1]")).click();

			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}

			driver.findElement(By.xpath("html/body/main/nav/div/div/ul/li[3]/a")).click();
			
			String name=driver.findElement(By.xpath("html/body/main/div[2]/div/div/div[1]/h2")).getText();
			
			if(name.contains("Privacy Policy"))
				System.out.println("A new Privacy policy web page is opened");
			else
				System.out.println("A new Privacy policy web page is not opened");
			
			driver.close();
}
	
		public static void SignUpToXDC_TC02D() throws InterruptedException, AWTException{
	
			SignUpForFreeTrail_TC02();
			Thread.sleep(2000);
	
			driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[3]")).click();
			Thread.sleep(3000);
			
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			String name=driver.findElement(By.xpath("html/body/div[6]/main/div/div[1]/div/div/h1")).getText();
	
			if(name.contains("Offer details"))
				System.out.println("A new offer details web page is opened");
			else
				System.out.println("offer web page is not opened");
	
	
			driver.close();
	
}	

		public static void SignUpToXDC_TC02E() throws InterruptedException, AWTException{
	
	SignUpForFreeTrail_TC02();
	Thread.sleep(2000);

	driver.findElement(By.xpath("html/body/div[6]/main/div[2]/div/div/div/p/a")).click();
	Thread.sleep(3000);

	String name=driver.findElement(By.xpath("html/body/div[6]/main/div/div[1]/div/div/h2")).getText();

	if(name.contains("Let’s get started"))
		System.out.println(" partnership web page is opened");
	else
		System.out.println(" partnership web page is not opened");


	driver.close();

}	
		public static void main(String[] args) throws InterruptedException, AWTException {
		//	SignUpToXDC_TC02();
			//SignUpToXDC_TC02A();
			//SignUpToXDC_TC02B();
			//SignUpToXDC_TC02D();
			//SignUpToXDC_TC02E();
	}
}
