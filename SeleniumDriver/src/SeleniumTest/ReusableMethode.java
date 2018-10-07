package SeleniumTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReusableMethode {
	
	public static HSSFWorkbook wb;
	public static WebDriver driver;
	
	public static WebDriver launchBrowser(String name){
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		
		if(name.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("chrome")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.chrome.driver","/home/shubhangi/workspace/SeleniumDriver/src/utility/chromedriver");
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver closeBrowser(WebDriver driver){
		try{
			driver.quit();
		}
		catch(Exception e){
			
		}
		return driver;
	}
	public static WebDriver Login_toXerox(WebDriver driver) throws InterruptedException{
		
		driver.get("https://login.xero.com/");
		driver.findElement(By.id("email")).sendKeys("shubhangi.takawane@gmail.com");
		driver.findElement(By.id("password")).sendKeys("shubhangi1");
		driver.findElement(By.id("submitButton")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualText=driver.findElement(By.xpath(".//*[@id='root']/div/div/div[1]/div[1]/div[1]/div/div[1]/div")).getText();
		String expString="Welcome to Xero";
		
		if(actualText.equalsIgnoreCase(expString))
			System.out.println("User's Home Page is displayed");
		else
			System.out.println("eUser's Home Page is not displayed");
		
		return driver;
	}
	public static String[][] readDataFromXl(String dataTablePath, String sheetName) throws IOException{
//		String cur_dir = System.getProperty("user.dir");
		FileInputStream fs = new FileInputStream (new File(dataTablePath));
		
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		HSSFSheet sheet=wb.getSheet(sheetName);
		
		int trow=sheet.getLastRowNum()+1;
		int tcol=sheet.getRow(0).getLastCellNum();
		String[][] s = new String[trow][tcol];
		System.out.println("total rows="+trow+" and total column="+tcol);
		for(int i=0;i<trow;i++){
			for(int j=0;j<tcol;j++){
				int cellType=sheet.getRow(i).getCell(j).getCellType();
				if(cellType==HSSFCell.CELL_TYPE_NUMERIC)
					s[i][j]=String.valueOf((int)sheet.getRow(i).getCell(j).getNumericCellValue());
				else
				s[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();	
		
			}
		}
		
		return s;
	}

	
}
