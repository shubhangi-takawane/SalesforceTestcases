package TestDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestScirpt.ReusableMethods;

public class AutoScript_4 {
	
	static WebDriver driver;
public static void checkLeadsTabLink_TC20() throws InterruptedException{
	
//lauch browser and salesforce
		driver=ReusableMethods.launchBrowser("firefox");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver=ReusableMethods.Login_toSalesforce(driver);
		Thread.sleep(6000);	
//open leads
		driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a")).click();
		String HomePage=driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")).getText();
		if(HomePage.equals("Home")) {
			System.out.println("Leads Home page is displayed");
		}else {
			System.out.println("Leads Home page is not displayed");
		}
		//driver.close();
}
public static void ValidateViewDropDownListContents_TC21() throws InterruptedException{
	
//lauch browser and salesforce
			driver=ReusableMethods.launchBrowser("firefox");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			driver=ReusableMethods.Login_toSalesforce(driver);
			Thread.sleep(6000);	
//open leads
			driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a")).click();
			String HomePage=driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")).getText();
			if(HomePage.equals("Home")) {
				System.out.println("Leads Home page is displayed");
			}else {
				System.out.println("Leads Home page is not displayed");
			}
			
//select drop down
			
			driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
			driver.findElement(By.id("fcf")).click();
			Thread.sleep(3000);
			String MenuList= driver.findElement(By.id("fcf")).getText();
			//String list[]= {" My Unread Leads","Recently Viewed Leads","Today's Leads","View-Custom 1","View-Custom 2"};
			if(MenuList.contains("My Unread Leads")) {
				System.out.println("Drop drown list is displayed");
			}else {
				System.out.println("Drop drown list is not displayed");
			}
			driver.close();
	}
public static void FunctionalityOfTheGoButton_TC22() throws InterruptedException{
	
	//lauch browser and salesforce
				driver=ReusableMethods.launchBrowser("firefox");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver, 40);
				driver=ReusableMethods.Login_toSalesforce(driver);
				Thread.sleep(6000);	
	//open leads
				driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a")).click();
				String HomePage=driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")).getText();
				if(HomePage.equals("Home")) {
					System.out.println("Leads Home page is displayed");
				}else {
					System.out.println("Leads Home page is not displayed");
				}
//select Today's list
				WebElement selectMenu = driver.findElement(By.id("fcf"));
				Thread.sleep(3000);
				
				Select select=new Select(selectMenu);				
				select.selectByVisibleText("Today's Leads");
//login to salesforce again and display home page
				checkLeadsTabLink_TC20();
				Thread.sleep(6000);
				driver.findElement(By.xpath(".//*[@id='filter_element']/div/span/span[1]/input")).click();
				String Page=driver.findElement(By.xpath(".//*[@id='00B6A000005YC2u_listSelect']")).getText();
				if(Page.contains("Today's Leads")){
					System.out.println("Today's Leads view is displayed");
				}else {
					System.out.println("Today's Leads view is not displayed");
				}
				driver.close();
}
public static void ListItemTodaysLeadsWork_TC23() throws InterruptedException{
	
//lauch browser and salesforce
				driver=ReusableMethods.launchBrowser("firefox");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver, 40);
				driver=ReusableMethods.Login_toSalesforce(driver);
				Thread.sleep(6000);	
//open leads
				driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a")).click();
				String HomePage=driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")).getText();
				if(HomePage.equals("Home")) {
					System.out.println("Leads Home page is displayed");
				}else {
					System.out.println("Leads Home page is not displayed");
				}
//select Today's list
				WebElement selectMenu = driver.findElement(By.id("fcf"));
				Thread.sleep(3000);
				
				Select select=new Select(selectMenu);				
				select.selectByVisibleText("Today's Leads");
				String TodayLeads=driver.findElement(By.xpath(".//*[@id='fcf']")).getText();
				if(TodayLeads.contains("Today's Leads")) {
					System.out.println("Today's Leads is selected");
				}else {
					System.out.println("Today's Leads is not selected");
				}
				driver.close();
}
public static void CheckNewButtonOnLeadsHome_TC24() throws InterruptedException{
	
					checkLeadsTabLink_TC20();
					Thread.sleep(3000);
					driver.findElement(By.name("new")).click();
					driver.findElement(By.xpath(".//*[@id='name_lastlea2']")).sendKeys("ABCD");
					driver.findElement(By.xpath(".//*[@id='lea3']")).sendKeys("ABCD");
					driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]")).click();
					
}
	public static void main(String[] args) throws InterruptedException {
		
		//checkLeadsTabLink_TC20();
		//ValidateViewDropDownListContents_TC21();
		//FunctionalityOfTheGoButton_TC22();
		//ListItemTodaysLeadsWork_TC23();
		CheckNewButtonOnLeadsHome_TC24();
	}

}
