package TestDriver;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import TestScirpt.ReusableMethods;


	public class AutomationScripts extends ReusableMethods{
		static WebDriver driver;


		public static void main(String[] args) {
			Check_RemeberMe();
			Forgot_Password_A();
			ValidateLoginErrorMessage();
		}

		public static void Check_RemeberMe(){
			String driverPath = "C:/Users/Abhis_lw0caw1/Google Drive/QA Automation/Feb 12 2018/Read Only QA Automation Feb 12 2018_/Framework/Lib/geckodriver-v0.19.1-win64/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			System.out.println("Firefox browser is launched..");

			/*Launch URL*/
			driver.get("https://login.salesforce.com/");
			System.out.println("Salesforce application is launched..");

			/*Enter UN in user name field..*/
			WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
			enterText(un, "User@Gmail.com", "UserName");

			/*Enter PWD in password field..*/
			WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
			enterText(pwd, "Pass123", "Password");

			/*Select Check remember me */
			WebElement checkBox = driver.findElement(By.xpath("//input[@id='rememberUn']"));
			deSelectCheckBox(checkBox, "Remember me check box");



			/*Click login button*/
			WebElement loginButton = driver.findElement(By.xpath("//*[@id='Login']"));
			clickObj(loginButton, "Login Button");

			/*Check user name is displayed in user name field*/
			//		String getUN = driver.findElement(By.xpath("//*[@id='username']")).getAttribute("value");
			validateTextBoxContent(un, "user@gmail.com", "UserName");

			driver.close();
			System.out.println("Browser closed..");


		}

		

		public static void Forgot_Password_A(){

		}


		public static void ValidateLoginErrorMessage(){

		}
		
		


	}
