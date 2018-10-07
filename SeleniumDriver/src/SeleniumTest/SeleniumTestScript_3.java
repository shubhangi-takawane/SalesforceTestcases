package SeleniumTest;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import SeleniumTest.ReusableMethode;


public class SeleniumTestScript_3 {

public static WebDriver driver;

	public static void TestAllTabsPage_TC03() throws InterruptedException{

		driver=ReusableMethode.launchBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver=ReusableMethode.Login_toXerox(driver);
		Thread.sleep(6000);
		
		driver.findElement(By.xpath(".//*[@id='Dashboard']")).click();
		
		driver.findElement(By.id("Accounts")).click();
		
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li[1]/a")).click();
		
		String actualText= driver.findElement(By.xpath(".//*[@id='title']")).getText();

		if(actualText.contains("Bank Accounts"))
			System.out.println("Bank Accounts page is displayed");
		else
			System.out.println("Bank Accounts page is not displayed");
		
		driver.findElement(By.id("Reports")).click();
		
		String textpage= driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[4]/ul/li[1]/a")).getText();
		
		if(textpage.contains("All Reports"))
			System.out.println("Reports drop down page is displayed");
		else
			System.out.println("Reports drop drown page is not displayed");
		
		driver.findElement(By.id("Contacts")).click();
		Thread.sleep(3000);
		
		String accountPage= driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[5]/ul/li[2]/a")).getText();
		
		if(accountPage.contains("Customers"))
			System.out.println("Contacts drop down page is displayed");
		else
			System.out.println("Contacts drop drown page is not displayed");
		
//setting
		driver.findElement(By.id("Settings")).click();
		
		String SettingText=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[6]/ul/li[1]/a")).getText();
		
		if(SettingText.contains("General Settings"))
			System.out.println("Settings drop down page is displayed");
		else
			System.out.println("Settings drop drown page is not displayed");
		
//+
		driver.findElement(By.xpath(".//*[@id='quicklaunchTab']")).click();
//files
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a")).click();
		
		// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
				}
		
		String files=driver.findElement(By.xpath(".//*[@id='page_title']/div/h1[1]")).getText();
	
		if(files.contains("Files"))
			System.out.println("files page is displayed");
		else
			System.out.println("files page is not displayed");
		
		Thread.sleep(3000);
//notification
		
		WebElement x= driver.findElement(By.className("notifications"));
		x.click();
		
		Thread.sleep(3000);
//search
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a")).click();
		
		Thread.sleep(1000);
		
//help
		driver.findElement(By.className("help")).click();
	
		// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
				}
		driver.findElement(By.xpath(".//*[@id='rt']/ul/li[1]/a")).click();
		Thread.sleep(3000);
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);
		}
		
		String help=driver.findElement(By.xpath("html/body/div[1]/div/div/div[1]/div[1]/ul[1]/li/h1/a")).getText();
		
		if(help.contains("Xero Business Help Center"))
			System.out.println("Help Business menu is opened");
		else
			System.out.println("Help window is not displayed");
	
		Thread.sleep(3000);
		
		driver=ReusableMethode.closeBrowser(driver);	
}

	public static void TestLogoutFunctionality_TC04() throws InterruptedException{

		driver=ReusableMethode.launchBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver=ReusableMethode.Login_toXerox(driver);
		Thread.sleep(6000);
		
		WebElement x = driver.findElement(By.xpath("//*[@id='xero-nav']/div[2]/div[1]/div[2]/a"));
		x.click();

// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);
		}
		
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[3]/a")).click();
		
		Thread.sleep(3000);
		String welcome= driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/h2")).getText();
	
		if(welcome.contains("Welcome to Xero"))
			System.out.println("welcome page is displayed");
		else
			System.out.println("welcome page is not displayed");
		Thread.sleep(3000);
		driver.close();
		
	}
	public static void main(String[] args) throws InterruptedException, AWTException {
	
	//TestAllTabsPage_TC03();
	//TestLogoutFunctionality_TC04();
}
}