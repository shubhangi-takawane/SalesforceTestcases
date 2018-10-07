package ExtentReport;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import TestScirpt.ReusableMethods;


//import ReusableMethods;

public class TC1_LoginErrorMsg {
	public static WebDriver driver;
	public static ExtentTest logger;
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/NewReport.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host Name", "Tek Arch");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Divyashree");
		
		htmlReporter.config().setDocumentTitle("extent reports");
		htmlReporter.config().setReportName("functional testing reports");
		//start testcase 1 so create one test in report
		logger=extent.createTest("TC1_LoginErrorMsg");
		String expString="Please enter your password.";
		System.setProperty("webdriver.gecko.driver","./src/utility/geckodriver.exe");
		driver=new FirefoxDriver();
		logger.log(Status.INFO, "firefox browser opened");
		driver.get("https://login.salesforce.com/");
		logger.log(Status.INFO, "salesforce application opened");
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Salesforce")){
		
		logger.log(Status.INFO, "salesforce page is verified");
		}
		else{
			
			logger.log(Status.INFO, "salesforce page is not verified");
			}
		//
		WebElement user=driver.findElement(By.xpath("//*[@id='username']"));
		ReusableMethods.enterText(user,"User@gmail.com","username field");
		//user.sendKeys("User@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).clear();
		driver.findElement(By.xpath(".//*[@id='Login']")).click();
		String actualText=driver.findElement(By.xpath("//*[@id='error']")).getText();
		if(actualText.equalsIgnoreCase(expString)){
			logger.log(Status.INFO, "error message verified");
			
		}
		else{
			logger.log(Status.INFO, "error message is not verified...testcase failed");
		}
		File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		 FileUtils.copyFile(src, new File("./Screenshots/error.png"));

		
		
		logger.log(Status.PASS,MarkupHelper.createLabel("testcase passed",ExtentColor.GREEN));
		
		
		//start testcase 2 so create one more test in report
		 logger=extent.createTest("tc2 logi to salesforce");
		 logger.log(Status.INFO, "info about testcase 2");
			
	//	 logger.log(Status.FAIL,MarkupHelper.createLabel("testcase passed",ExtentColor.RED));
		
		//finally close the report to reflect changes in the report
		extent.flush();
		driver.close();
		
		
	}
}

