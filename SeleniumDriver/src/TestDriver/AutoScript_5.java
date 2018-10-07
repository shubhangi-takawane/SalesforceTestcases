package TestDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestScirpt.ReusableMethods;

public class AutoScript_5 {
	static WebDriver driver;
	public static void CreateNewContact_TC25() throws InterruptedException{
		
//lauch browser and salesforce
				driver=ReusableMethods.launchBrowser("firefox");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver, 40);
				driver=ReusableMethods.Login_toSalesforce(driver);
				Thread.sleep(6000);	
//open the contacts
				driver.findElement(By.xpath(".//*[@id='Account_Tab']/a")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='tryLexDialogX']")).click();
				String ContactHome=driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1")).getText();
				if(ContactHome.contains("Contacts")) {
					System.out.println("Contact home page is displayed");
				}else {
					System.out.println("Contact home page is not displayed");

				}
				driver.findElement(By.name("new")).click();
				String NewAccount=driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")).getText();
				if(NewAccount.contains("New Account")) {
					System.out.println("New Account is displayed");
				}else {
					System.out.println("New Account is displayed");
				}
				driver.findElement(By.id("acc2")).sendKeys("Abcs");
				driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]")).click();
				String SaveContact=driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[1]/div")).getText();
				if(SaveContact.contains("Abcs")) {
					System.out.println("New Account is created");
				}else {
					System.out.println("New Account is not created");
				}
				driver.close();
	}
	public static void main(String[] args) throws InterruptedException {
		CreateNewContact_TC25();
	}
}
