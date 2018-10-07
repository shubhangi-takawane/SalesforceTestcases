package TestDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestScirpt.ReusableMethods;

public class AutoScripts_2 {
	
	public static WebDriver driver;
	
	public static void AccountOpen() throws InterruptedException{

		driver=ReusableMethods.launchBrowser("firefox");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver=ReusableMethods.Login_toSalesforce(driver);
		Thread.sleep(6000);
//click on account	
			WebElement accountTab=driver.findElement(By.xpath(".//*[@id='Account_Tab']/a"));		
			accountTab.click();
			driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
//check account page			
			String accountText=driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1")).getText();
			if(accountText.equalsIgnoreCase("Accounts"))
			System.out.println("account page is verified");
			else
				System.out.println("account page is not present");
			Thread.sleep(2000);
			
	}
	
	public static void CreateAccount_TC10() throws InterruptedException {
		     AccountOpen();
		     Thread.sleep(3000);
//create new account
			WebElement newAccount=driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input"));		
			newAccount.click();
			Thread.sleep(5000);
//create account with name and save			
			driver.findElement(By.xpath("//*[@id='acc2']")).sendKeys("wellsFeb");
			driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]")).click();
			
			String newAccountText=driver.findElement(By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2")).getText();
			if(newAccountText.equalsIgnoreCase("wellsFeb"))
				System.out.println("new account verified");
			else
				System.out.println("couldnt verify new account");
			
			ReusableMethods.closeBrowser(driver);
					
	}
	public static void Createnewview_TC11() throws InterruptedException{
		AccountOpen();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[2]/a[2]")).click();
		driver.findElement(By.xpath("//*[@id='fname']")).sendKeys("A111");
		driver.findElement(By.xpath("//*[@id='devname']")).sendKeys("s111");
		driver.findElement(By.xpath("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]")).click();
		Thread.sleep(3000);
		
//view the added name
		WebElement t=driver.findElement(By.xpath(".//*[@id='filter_element']/div"));
		driver.switchTo().frame(t);
		
		String EditName=driver.findElement(By.xpath(".//*[@id='fcf']")).getText();
		System.out.println(EditName);
		if(EditName.equalsIgnoreCase("A111"))
			System.out.println("newly added account is displayed");
		else
			System.out.println("newly added account is not displayed");
			
		ReusableMethods.closeBrowser(driver);
		
	}

	public static void Editview_TC12() throws InterruptedException{
		AccountOpen();
		Thread.sleep(3000);
		/*WebElement selectMenu=driver.findElement(By.xpath(".//*[@id='00B6A000005VdA2_listSelect']"));
		
		Select select=new Select(selectMenu);
		Thread.sleep(5000);
		
		select.selectByVisibleText("T");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='00B6A000005VdA2_filterLinks']/a[1]")).click();*/
		driver.findElement(By.xpath("//*[@id='00B6A000005VdA2_filterLinks']/a[1]")).click();
		/*String Editview=driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")).getText();
		System.out.println(Editview);
		if(Editview.contains("Edit View"))
			System.out.println("Edit page is displayed");
		else
			System.out.println("Edit page is not displayed");
			
*/
	} 

	public static void main(String[] args) throws InterruptedException {
		//AccountOpen();
		//CreateAccount_TC10();
		Createnewview_TC11();
		//Editview_TC12() ;
	}

}
