package SeleniumAss;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;

public class WebTitle {
	
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(8000);
		
		WebElement selectMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
		Thread.sleep(3000);
		
		Select select=new Select(selectMenu);
		//select.selectByVisibleText("lastoption");

		select.getOptions().lastIndexOf(selectMenu);
		driver.close();
		
		
		driver.get("https://login.salesforce.com/");
		Thread.sleep(8000);
		driver.findElement(By.xpath(".//*[@id='Login']")).click();
		if(driver.findElement(By.xpath(".//*[@id='Login']")).isEnabled())
		{
		System.out.println("Element is clickable");
		}
		else
		{
		System.out.println("Element is not clickable");
		}
		driver.get("http://money.rediff.com/gainers/bsc/dailygroupa?");         
        //No.of Columns
        List  col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("Number of col : " +col.size()); 
        //No.of rows 
        List  rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
        System.out.println("Number of row : " + rows.size());
        driver.close();
        
       
        for(int i=0;i<=col.size();i++) {
        	for(int j=0; j<rows.size();j++) {
        		System.out.println(col);
     
        	}
        }
    	
		
		
		//select.selectByVisibleText("Baby");
		//select.selectByValue("Books");
		//select.selectByValue("sear
	//	int indexOfLastItem = myDropDownList.Items.Count - 1;
		
    //    String theSelect = driver.getElementById("searchDropdownBox");
      //  var lastValue = theSelect.options[theSelect.options.length - 1].value;
		
}
}
