package ExtentReport;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.gargoylesoftware.htmlunit.WebConsole.Logger;

public class TC_LoginToPage {

	public static WebDriver driver;
	public static ExtentTest logger;
	public static void main(String[] args) throws InterruptedException, IOException {
		
		ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/NewReport.html");
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Java", "tekArch");
		extent.setSystemInfo("selenium", "Auto");
		extent.setSystemInfo("functional", "Regrational");
		
		htmlReporter.config().setDocumentTitle("Document extent");
		htmlReporter.config().setReportName("Selenium webDriver testing");
		logger= extent.createTest("TC_LoginToPage");
		
		String expString="Please enter your password.";
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Salesforce")) {
			//System.out.println("salesforce page is verified");
			logger.log(Status.INFO, "salesforce page is verified");
		}else {
		logger.log(Status.INFO, "salesforce page is not verified");
		}
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("User@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).clear();
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		
		String actualText=driver.findElement(By.xpath("//*[@id='error']")).getText();
		if(actualText.equalsIgnoreCase(expString)) {
			//System.out.println("error message verified");
		logger.log(Status.INFO, "error message verified");
		}else {
			logger.log(Status.INFO, "error message not verified");
		}
	//take a screenshot	
		File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("./Screenshots/error.png"));
		
	//attach screen shot to extent report	
		ExtentTest imagePath = logger.addScreenCaptureFromPath("/home/shubhangi/workspace/SeleniumDriver/Screenshots/error.png");
		logger.log(Status.FAIL, "Verify test"+imagePath);
		
		
	//	logger.log(Status.PASS,MarkupHelper.createLabel("testcase passed",ExtentColor.GREEN));
	//logger.log(Status.FAIL, MarkupHelper.createLabel("test case fail", ExtentColor.RED));
		extent.flush();
		driver.close();
		
	}

}
