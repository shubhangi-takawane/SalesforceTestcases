package SeleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumTestScript_4 {

	public static WebDriver driver;
		
		public static void AddAnotherOrganizationTrailversion_TC08A() throws InterruptedException{
			
			driver=ReusableMethode.launchBrowser("firefox");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver=ReusableMethode.Login_toXerox(driver);
			Thread.sleep(6000);
			
			driver.findElement(By.className("org-name")).click();
			
	// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
			}
			
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div/a")).click();//myXero
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("ext-gen1043")).click();//Add organisation
			
			driver.findElement(By.id("text-1022-inputEl")).sendKeys("ST7");
			
			
			driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Engineering");
		
			driver.findElement(By.id("combo-1029-inputEl")).click();

			driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[1]")).click();
			
			driver.findElement(By.xpath(".//*[@id='simplebutton-1035']")).click();
		
			Thread.sleep(3000);
			
			String findText=driver.findElement(By.xpath(".//*[@id='root']/div/div/header/div/h1")).getText();
			
			if(findText.contains("ST7"))
				System.out.println("New Organisation is added");
			else
				System.out.println("Organisation is not displayed");
			
			driver.close();
		
		}

		public static void AddAnotherOrganizationTrailversion_TC08B() throws InterruptedException{

			driver=ReusableMethode.launchBrowser("firefox");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver=ReusableMethode.Login_toXerox(driver);
			Thread.sleep(6000);
			
			driver.findElement(By.className("org-name")).click();
			
	// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
			}
			
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div/a")).click();
			
			Thread.sleep(4000);
			
			driver.findElement(By.id("ext-gen1043")).click();//Add organisation
			
			driver.findElement(By.id("text-1022-inputEl")).sendKeys("ST3");
			
			
			driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Engineering");
		
			driver.findElement(By.id("combo-1029-inputEl")).click();

			driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[1]")).click();
			
			driver.findElement(By.xpath(".//*[@id='simplebutton-1036']")).click();//Buy now
		
			Thread.sleep(5000);
			
			String findText=driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/header/div/h1")).getText();
			
			if(findText.contains("ST3"))
				System.out.println("Organisation navigate to Subscription and Billing page");
			else
				System.out.println("Organisation is not added properly");
			
			driver.close();
		
		}

		public static void AddAnotherOrganizationTrailversion_TC08C() throws InterruptedException{

			driver=ReusableMethode.launchBrowser("firefox");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver=ReusableMethode.Login_toXerox(driver);
			Thread.sleep(6000);
			
			driver.findElement(By.className("org-name")).click();
			
	// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
			}
			
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div/a")).click();
			
			Thread.sleep(4000);
			
			driver.findElement(By.id("ext-gen1043")).click();//Add organisation
			
			driver.findElement(By.id("text-1022-inputEl")).sendKeys("ST3");
			
			
			driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Engineering");
		
			driver.findElement(By.id("combo-1029-inputEl")).click();

			driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[1]")).click();
			
			driver.findElement(By.xpath(".//*[@id='simplebutton-1036']")).click();//Buy now
		
			Thread.sleep(5000);
			
			String findText=driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/header/div/h1")).getText();
			
			if(findText.contains("ST3"))
				System.out.println("Organisation navigate to Subscription and Billing page");
			else
				System.out.println("Organisation is not added properly");
			
//Substription&Billing
			
			driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/SOLO']/div[1]/label")).click();
			
			driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button")).click();
			
//create account
			driver.findElement(By.id("POAddress")).sendKeys("3450 granada ave");
			
			driver.findElement(By.id("POCity")).sendKeys("Santa clara");
			
			driver.findElement(By.id("PORegionDropdown")).sendKeys("CA");
			
			driver.findElement(By.id("POPostalCode")).sendKeys("95051");
			
			driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button")).click();
			Thread.sleep(3000);
			
//payment details
			driver.findElement(By.id("card-element")).sendKeys("12345678");
			Thread.sleep(1000);
			
			driver.findElement(By.id("card-expiry")).sendKeys("02/19");
			Thread.sleep(1000);
			
			driver.findElement(By.id("card-cvc")).sendKeys("345");
			
			driver.findElement(By.id("cardholder-name")).sendKeys("BOA");
			Thread.sleep(3000);
			
			driver.close();
		
		}

	public static void CheckSubscription_TC10() throws InterruptedException{

			driver=ReusableMethode.launchBrowser("firefox");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver=ReusableMethode.Login_toXerox(driver);
			Thread.sleep(6000);
//account
			driver.findElement(By.id("Accounts")).click();
			
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li[3]/a")).click();			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(".//*[@id='ext-gen1035']/span")).click();//arrow
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(".//*[@id='ext-gen1034']/li[1]/a")).click();//bill
			
			String bill=driver.findElement(By.xpath(".//*[@id='frmMain']/div[1]/div/h1")).getText();
			
			if(bill.contains("New Bill"))
				System.out.println("Bill page is opened");
			else
				System.out.println("Bill page is not opened");
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(".//*[@id='frmMain']/div[1]/div/span/a[1]")).click();
			Thread.sleep(2000);
//repeating			
			
			driver.findElement(By.xpath(".//*[@id='ext-gen1035']/span")).click();
			
			driver.findElement(By.xpath(".//*[@id='ext-gen1034']/li[2]/a")).click();
			Thread.sleep(3000);
			
			String repeatingBill=driver.findElement(By.xpath(".//*[@id='bodyContainer']/div[1]/div/h1")).getText();
			
			if(repeatingBill.contains("New Repeating Bill"))
				System.out.println("RepeatingBill page is opened");
			else
				System.out.println("RepeatingBill page is not opened");
			
			Thread.sleep(3000);
	
			driver.close();
	
	}

public static void main(String[] args) throws InterruptedException {
	//AddAnotherOrganizationTrailversion_TC08A();
	//AddAnotherOrganizationTrailversion_TC08B();
	//AddAnotherOrganizationTrailversion_TC08C();
	//CheckSubscription_TC10();
}
}