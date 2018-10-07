package TestDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestScirpt.ReusableMethods;

public class PhotoUpload {

	static WebDriver driver;
public static void RePhoto() throws InterruptedException{
	driver=ReusableMethods.launchBrowser("firefox");
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 40);
	driver=ReusableMethods.Login_toSalesforce(driver);
	Thread.sleep(6000);
				
	driver.findElement(By.xpath("//*[@id='userNavButton']")).click();
	
	driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[1]")).click();
	
	driver.findElement(By.xpath("//*[@id='uploadLink']")).click();
	driver.switchTo().frame("UploadPhotoContentId");
	driver.findElement(By.xpath(".//*[@id='j_id0:uploadFileForm:uploadInputFile']")).sendKeys("/home/shubhangi/image.png");
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
