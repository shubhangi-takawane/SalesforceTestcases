package TestScirpt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Account {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		
		WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
		username.sendKeys("shubhangi.takawane@gmail.com");
		
		WebElement passwd = driver.findElement(By.xpath("//*[@id='password']"));
		passwd.sendKeys("gondukanha12");
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='Login']"));
		loginButton.click();
		
        Thread.sleep(5000);
		
        WebElement AccountButton = driver.findElement(By.xpath("//*[@id='Account_Tab']/a"));
        AccountButton.click();
        
      
        Thread.sleep(5000);
        
        WebElement PopupButton = driver.findElement(By.xpath("//*[@id='tryLexDialogX']"));
        PopupButton.click();
        
        
       WebElement NewAccountButton = driver.findElement(By.xpath("//*[@id='createNewLabel']"));
      NewAccountButton.click();
        
      Thread.sleep(5000);
        
        WebElement selectAccount = driver.findElement(By.xpath("//*[@id='createNewMenu']/a[4]"));
		selectAccount.click();
        
	/*	Select select=new Select(selectAccount);
		 Thread.sleep(3000);
		select.selectByVisibleText("Account");
      
		/*Close the Browser*/
		//driver.quit();
//*******//
       /* WebElement NewViewButton = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[2]/a[2]"));
    		NewViewButton .click();
          
    		WebElement ViewName = driver.findElement(By.xpath("//*[@id='fname']"));
    		ViewName.sendKeys("shubhangi takawane");
    		
    /*		WebElement ViewUniqueName = driver.findElement(By.xpath("//*[@id='devname']"));
    		ViewUniqueName.sendKeys("JAVA");
    		
    		WebElement SaveButton = driver.findElement(By.xpath("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]"));
            SaveButton.click();*/
  //***//
    	/*	WebElement EditButton = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[2]/a[1]"));
    		EditButton .click();
          
    		WebElement FieldButton = driver.findElement(By.xpath("//*[@id='fcol1']"));
    		FieldButton .click();
    		Thread.sleep(3000);*/

    		//Select select=new Select(FieldButton);
    		//Thread.sleep(3000);
    		//select.selectByVisibleText("Account Name");
    		//select.selectByIndex(1);
 
    	/*(	Select select=new Select(FieldButton);
    		Thread.sleep(3000);
    		//select.selectByVisibleText("Account Name");
    		select.selectByIndex(1);*/

	}

}
