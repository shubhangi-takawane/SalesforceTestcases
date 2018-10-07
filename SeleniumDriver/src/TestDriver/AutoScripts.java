package TestDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestScirpt.ReusableMethods;

	public class AutoScripts {
		public static WebDriver driver;
		
		public static void LoginErrorMessage_01() throws InterruptedException{
			String expString="Please enter your password.";
			String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
			System.setProperty("webdriver.gecko.driver",driverPath );
			driver=new FirefoxDriver();
			driver.get("https://login.salesforce.com/");
			String applicationTitle=driver.getTitle();
			if(applicationTitle.contains("Salesforce"))
				System.out.println("salesforce page is verified");
			else
				System.out.println("salesforce page is not verified");
			//
			driver.findElement(By.xpath("//*[@id='username']")).sendKeys("User@gmail.com");
			driver.findElement(By.xpath("//*[@id='password']")).clear();
			driver.findElement(By.xpath("//*[@id='Login']")).click();
			
			String actualText=driver.findElement(By.xpath("//*[@id='error']")).getText();
			if(actualText.equalsIgnoreCase(expString))
				System.out.println("error message verified");
			else
				System.out.println("error message is not verified...testcase failed");
			driver.close();
			
		}
	public static void LoginToSalesForce_2() throws InterruptedException {
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("shubhangi.takawane@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("abc");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		Thread.sleep(3000);
		
		String homepageTitle= driver.getTitle();
		if(homepageTitle.contains("Home Page"))
			System.out.println("Home page is verified");
		else
			System.out.println("Home page is not verified.");
		driver.close();
	}
	public static void CheckRemeberMe_3() throws InterruptedException {
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Salesforce"))
			System.out.println("salesforce page is verified");
		else
			System.out.println("salesforce page is not verified");
		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("shubhangi.takawane@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("gondukanha12");
		driver.findElement(By.xpath("//*[@id='login_form']/div[3]/label")).click();
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='userNav-arrow']")).click();
		driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]")).click();
		Thread.sleep(5000);
		
		String actID=driver.findElement(By.xpath("//*[@id='idcard-identity']")).getText();
		if(actID.equalsIgnoreCase("shubhangi.takawane@gmail.com"))
			System.out.println("email id verified");
		else
			System.out.println("email id not verified");
		driver.close();
		
	}
	
	
	public static void ForgotPassword_4A() throws InterruptedException{
		
		String expString="We’ve sent you an email with a link to finish resetting your password.";
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Salesforce"))
			System.out.println("salesforce page is verified");
		else
			System.out.println("salesforce page is not verified");
		driver.findElement(By.xpath("//a[text()='Forgot Your Password?']")).click();
		Thread.sleep(6000);
		if(driver.getTitle().contains("Forgot Your Password"))
			System.out.println("forgot password page is verified");
		else
			System.out.println("forgot password page is not verified");
		
		
		driver.findElement(By.xpath(".//*[@id='un']")).sendKeys("shubhangi.takawane@gmail.com");
		driver.findElement(By.xpath(".//*[@id='continue']")).click();
		Thread.sleep(2000);
		String actText=driver.findElement(By.xpath("//*[@id='forgotPassForm']/div/p[1]")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("reset message verified");
		else
			System.out.println("reset message is not verified");
		driver.close();
	}
	
	
	public static void ForgotPassword_4B() throws InterruptedException{
		String expString="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("user@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("gondukanha12");
		driver.findElement(By.xpath("//*[@id='login_form']/div[3]/label")).click();
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		Thread.sleep(5000);
		
		String actText=driver.findElement(By.xpath(".//*[@id='error']")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("test Case verified");
		else
			System.out.println("test Case is not verified");
		driver.close();
		
	}
	
	public static void userMenu_DropDown() throws InterruptedException{
		String[] options=new String[]{"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};
		
		List<String> expList=new ArrayList<String>(Arrays.asList(options));
		driver=ReusableMethods.launchBrowser("firefox");
		driver=ReusableMethods.Login_toSalesforce(driver);
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//*[@id='userNav-arrow']")).click();
		List<WebElement> list=driver.findElements(By.xpath("//*[@id='userNav-menuItems']/a"));
		Thread.sleep(5000);
		//System.out.println(list);
		
		ArrayList<String> actData=new ArrayList<String>();
		for(WebElement ele: list){
			actData.add(ele.getText().trim());
		}
		
		System.out.println(actData);
		
		if(actData.equals(expList))
			System.out.println("usermenu verified");
		else
			System.out.println("user menu is not verified");
		
		
		driver.close();
		
	}
	
	public static void EditPostFileImage() throws InterruptedException{
		WebDriver driver;
		
		driver=ReusableMethods.launchBrowser("firefox");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver=ReusableMethods.Login_toSalesforce(driver);
		Thread.sleep(6000);
					
		driver.findElement(By.xpath("//*[@id='userNavButton']")).click();
		
		driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[1]")).click();
		
		WebElement edit=driver.findElement(By.xpath("//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		edit.click();
				
		driver.switchTo().frame("contactInfoContentId");	//go to frame
//About
		WebElement about=driver.findElement(By.xpath("//*[@id='aboutTab']/a"));
		about.click();
		
		WebElement lastName=driver.findElement(By.xpath("//*[@id='lastName']"));
		lastName.clear();
		lastName.sendKeys("Java feb");
		
		WebElement saveAll=driver.findElement(By.xpath("//*[@id='TabPanel']/div/div[2]/form/div/input[1]"));
		saveAll.click();
		driver.switchTo().defaultContent();
		System.out.println("Clicked on saveAll  and back to default window");
		Thread.sleep(4000);
		
//For Post
	/*	Thread.sleep(10000);
		
		WebElement post=driver.findElement(By.xpath(".//*[@id='publisherAttachTextPost']/span[1]"));
		post.click();
		Thread.sleep(4000);
		
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.switchTo().frame(frame);
		System.out.println("switched");
		Thread.sleep(10000);
		
		System.out.println("tag html?  "+driver.findElements(By.xpath("//html/body")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body")));
		WebElement postMessage=driver.findElement(By.xpath("/html/body"));
		postMessage.sendKeys("This is using Automation");
//come out from frame and press share button
		driver.switchTo().defaultContent();
		WebElement shareButton=driver.findElement(By.xpath(".//*[@id='publishersharebutton']"));
		shareButton.click();
		
		Thread.sleep(2000);
//For File
		
		WebElement file=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='publisherAttachContentPost']/span[1]")));
		file.click();
		System.out.println("clicked on file");
		
		WebElement upload=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chatterUploadFileAction']")));
		upload.click();
		System.out.println("clicked on upload");
		
		WebElement browse=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chatterFile']")));
		browse.sendKeys("/home/shubhangi/Untitled Document 1.txt");
		
		WebElement share=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='publishersharebutton']")));
		share.click();
		Thread.sleep(5000);*/
//Add photo
		
		Actions mousehoover=new Actions(driver);
		mousehoover.moveToElement(driver.findElement(By.xpath("//*[text()='Moderator']"))).perform();
		WebElement addPhoto=driver.findElement(By.xpath(".//*[@id='uploadLink']"));
		addPhoto.click();
		Thread.sleep(5000);
		
		WebElement photoframe=driver.findElement(By.id("uploadPhotoContentId"));
		driver.switchTo().frame(photoframe);
		WebElement browsePhoto=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='j_id0:uploadFileForm:uploadInputFile']")));
	
		browsePhoto.sendKeys("I.png");
	
		WebElement savePhoto=driver.findElement(By.xpath(".//*[@id='j_id0:uploadFileForm:uploadBtn']"));
		savePhoto.click();
		
		Actions action=new Actions(driver); 
		action.dragAndDropBy(driver.findElement(By.xpath(".//*[@id='j_id0:outer']/div[1]/div/div/div/div[6]")), 100, 20);
		driver.findElement(By.xpath(".//*[@id='j_id0:j_id7:save']")).click(); 
		
		driver.switchTo().defaultContent();
		driver.quit();
	}
	
	public static void MySetting_TC07() throws InterruptedException{
		driver=ReusableMethods.launchBrowser("firefox");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver=ReusableMethods.Login_toSalesforce(driver);
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//*[@id='userNav-arrow']")).click();
		WebElement selectSetting = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[2]"));
		selectSetting.click();
		Thread.sleep(5000);
		
		String expString= "My Settings";
		String actText=driver.findElement(By.xpath("//*[@id='PersonalSetup_font']")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("My setting is displayed");
		else
		System.out.println("My setting is not displayed");
		
//personal	
		/*driver.findElement(By.xpath(".//*[@id='PersonalInfo']/a/span[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='LoginHistory_font']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='RelatedUserLoginHistoryList_body']/div/a"));*/
		
//display and logout		
	/*	String ChatterTitle= driver.findElement(By.xpath(".//*[@id='tabBar']")).getText();
		if(ChatterTitle.contains("Chatter"))
			System.out.println("chatter is verified");
		else{	
		driver.findElement(By.xpath(".//*[@id='DisplayAndLayout']/a")).click();
		driver.findElement(By.xpath(".//*[@id='CustomizeTabs_font']")).click();
		
		WebElement frame=driver.findElement(By.xpath(".//*[@id='duel_select_0']"));
		Thread.sleep(5000);
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		driver.findElement(By.xpath("..//*[@id='duel_select_0']/option[39]")).click();
		driver.findElement(By.xpath(".//*[@id='duel_select_0_right']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]")).click();
		String Title=driver.getTitle();
		
		if(Title.contains("Chatter"))
			System.out.println("chatter is verified");
		else
			System.out.println("chatter case is not verified");
		}
	
//Click on Email link and click on my email settings link under that
		
		
		
		driver.findElement(By.xpath("//*[@id='EmailSetup_font']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='EmailSettings_font']")).click();
		Thread.sleep(3000);
		WebElement MyMail = driver.findElement(By.xpath("//*[@id='sender_email']"));
		MyMail.clear();
		Thread.sleep(3000);
		MyMail.sendKeys("shubhangi.takawane@gmail.com");
		
		driver.findElement(By.xpath(".//*[@id='auto_bcc1']")).click();
		driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]")).click();
		
		String sucess="Your settings have been successfully saved.";
		String getText=driver.findElement(By.xpath(".//*[@id='meSaveCompleteMessage']/table/tbody/tr/td[2]/div")).getText();
		if(getText.equalsIgnoreCase(sucess))
			System.out.println("setting sucessful ");
		else
			System.out.println("setting is not sucessful");*/
		
//Click on Calendar & Remainders
		driver.findElement(By.xpath(".//*[@id='CalendarAndReminders_font']")).click();
		driver.findElement(By.xpath(".//*[@id='Reminders_font']")).click();
		driver.findElement(By.xpath(".//*[@id='testbtn']")).click();
		
		String popWindow=driver.switchTo().alert().getText();
		System.out.println(popWindow);
	/*	String popText="  Sample Event.";
		Thread.sleep(3000);
		if(popWindow.equalsIgnoreCase(popText))
			System.out.println("Popup window is displayed ");
		else
			System.out.println("Popup window is not displayed");
		
		driver.switchTo().frame(".//*[@id='bodyCell']");
		driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]")).click();*/
		
		driver.close();
	}
	
	public static void developerConsole_TC08() throws InterruptedException{
		driver=ReusableMethods.launchBrowser("firefox");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver=ReusableMethods.Login_toSalesforce(driver);
		Thread.sleep(6000);
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNavButton']"));
		usermenu.click();
		String[] a=new String[3];
		int i=0;
		
		WebElement developerConsole=driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"));
		developerConsole.click();
		
		for(String window:driver.getWindowHandles()){
			a[i]=window.toString();
			i++;
		}
		Thread.sleep(3000);
		
		driver.switchTo().window(a[1]);
		String title=driver.getTitle();
		if(title.contains("Developer Console"))
			System.out.println("devloper window verified");
		else
			System.out.println("failed to verify");
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(a[0]);
		ReusableMethods.closeBrowser(driver);
	}
	
	public static void SelectLogoutFromUserMenu_9() throws InterruptedException {

		driver=ReusableMethods.launchBrowser("firefox");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver=ReusableMethods.Login_toSalesforce(driver);
		Thread.sleep(6000);
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNavButton']"));
		usermenu.click();
		
		WebElement logoutUserMenu=driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		logoutUserMenu.click();
		Thread.sleep(5000);
		String url=driver.getCurrentUrl();
		if(url.equals("https://login.salesforce.com/"))
			System.out.println("passed");
		else
			System.out.println("not verified login url");
		//ReusableMethods.closeBrowser(driver);
		
		
}
	
	public static void main(String[] args) throws InterruptedException {
		//LoginErrorMessage_01();
		//LoginToSalesForce_2() ;
		//MySetting_TC07();
		//SelectLogoutFromUserMenu_9();
	//	developerConsole_TC08();
		EditPostFileImage(); 
	}

}
