package TestDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestScirpt.ReusableMethods;

public class AutoScript3 {
	static WebDriver driver;
	
	public static void UserName_TC15() throws InterruptedException{
//lauch browser and salesforce
	driver=ReusableMethods.launchBrowser("firefox");
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 40);
	driver=ReusableMethods.Login_toSalesforce(driver);
	Thread.sleep(6000);
	
//Opportunity home page displayed
	
	driver.findElement(By.xpath("//*[@id='AllTab_Tab']/a/img")).click();
	driver.findElement(By.xpath("//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[6]/td[2]/a")).click();
	String HomePage= driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]")).getText();
	//System.out.println(HomePage);
	if(HomePage.contains("Home")){
		System.out.println("Opty Home page is displayed");
	}else{
		System.out.println("Opty Home page is not displayed");
	}
//opty dropDown displayed all tabs
	
	String[] actList= new String[]{"All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities", "New Last Week", "New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities", "Won" };
	ArrayList<String> expList=new ArrayList<String>(Arrays.asList(actList));
	
	driver.findElement(By.xpath(".//*[@id='fcf']")).click(); //.//*[@id='fcf']/option[3]
	
	List<WebElement> list=driver.findElements(By.xpath("//*[@id='fcf']/option"));
	Thread.sleep(5000);
	//System.out.println(list);
	
	ArrayList<String> actData=new ArrayList<String>();
	
	for(WebElement ele: list){
		actData.add(ele.getText().trim());
	}
	System.out.println(actData);
	
	if(actData.equals(expList)){
		System.out.println("All tabs is displayed");
	}else{
		System.out.println("Failed");
	}
	
	driver.close();
	}
	
	public static void CreateNewOpty_TC16() throws InterruptedException{
		
//lauch browser and salesforce
		driver=ReusableMethods.launchBrowser("firefox");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver=ReusableMethods.Login_toSalesforce(driver);
		Thread.sleep(6000);
		
	//Opportunity home page displayed
		driver=ReusableMethods.LoginToOpty();
		Thread.sleep(6000);
		
		
//send info in new opty
		driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();
		
		WebElement AccountName= driver.findElement(By.xpath(".//*[@id='opp3']"));
		AccountName.sendKeys("marketingg");
		driver.findElement(By.xpath(".//*[@id='opp4']")).sendKeys("*Opportunity Iden");
		driver.findElement(By.xpath(".//*[@id='opp5']")).click();
		driver.findElement(By.xpath(".//*[@id='opp5']/option[2]")).click();
		driver.findElement(By.xpath(".//*[@id='opp6']")).click();
		driver.findElement(By.xpath(".//*[@id='opp6']/option[2]")).click();
		driver.findElement(By.xpath(".//*[@id='opp9']")).sendKeys("3/16/2018");
		driver.findElement(By.xpath(".//*[@id='opp11']")).click();
		driver.findElement(By.xpath(".//*[@id='opp11']/option[3]")).click();
		driver.findElement(By.xpath(".//*[@id='opp12']")).sendKeys("0");
		
//click on save button
		driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]")).click();
//verify the page
		String AccountInfo=driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[1]/div")).getText();
		
		if(AccountInfo.contains("marketingg")){
			System.out.println("New opty is saved and displayed in frame");
		}else{
			System.out.println("Test case is not failed");
		}
		//driver.close();
	}
	public static void OpportunityPipelineReport_TC17() throws InterruptedException{
		
//lauch browser and salesforce
		driver=ReusableMethods.launchBrowser("firefox");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver=ReusableMethods.Login_toSalesforce(driver);
		Thread.sleep(6000);
				
//Opportunity home page displayed

		driver=ReusableMethods.LoginToOpty();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath(".//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")).click();
		String optyPipeline=driver.findElement(By.xpath(".//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1")).getText();
		if(optyPipeline.contains("Opportunity Pipeline")) {
			System.out.println("report page with pipeline opty is displayed");
		}else {
			System.out.println("pipeline opty is not displayed");
		}
		driver.close();
	}
	public static void TestStuckOpportunitiesReport_TC18() throws InterruptedException{
		
		//lauch browser and salesforce
			driver=ReusableMethods.launchBrowser("firefox");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			driver=ReusableMethods.Login_toSalesforce(driver);
			Thread.sleep(6000);
						
			driver=ReusableMethods.LoginToOpty();
			Thread.sleep(6000);
		//stuck opty page
			
			driver.findElement(By.xpath(".//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a")).click();
			Thread.sleep(3000);
			String StuckOpty=driver.findElement(By.xpath(".//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1")).getText();
			if(StuckOpty.contains("Stuck Opportunities")) {
				System.out.println("Stuck opty page is displayed");
			}else {
				System.out.println("Stuck opty page is not displayed");
			}
			driver.close();
		}	
		public static void TestQuarterlySummaryReport_TC19() throws InterruptedException{
			
			//lauch browser and salesforce
				driver=ReusableMethods.launchBrowser("firefox");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver, 40);
				driver=ReusableMethods.Login_toSalesforce(driver);
				Thread.sleep(6000);
							
				driver=ReusableMethods.LoginToOpty();
				Thread.sleep(6000);
		//Test QuarterlySummary
				WebElement selectMenu = driver.findElement(By.xpath("//*[@id='quarter_q']"));
				Thread.sleep(3000);
				
				Select select=new Select(selectMenu);
				
				
				select.selectByVisibleText("Current and Next FQ");
				Thread.sleep(3000);
				driver.findElement(By.xpath(".//*[@id='lead_summary']/table/tbody/tr[3]/td/input")).click();
				Thread.sleep(2000);
				String ReportPage=driver.findElement(By.xpath(".//*[@id='report']/div[1]/div[1]/div[1]/table/tbody/tr/td[2]/fieldset")).getText();
				if(ReportPage.contains("Current and Next FQ")) {
					System.out.println("Search criteria is displayed");
				}
				else {
					System.out.println("Search criteria is not displayed");
				}
		}
	public static void main(String[] args) throws InterruptedException {
		
		//UserName_TC15();
		//CreateNewOpty_TC16();
		//OpportunityPipelineReport_TC17();
		//	TestStuckOpportunitiesReport_TC18();
		TestQuarterlySummaryReport_TC19();
	}

}
