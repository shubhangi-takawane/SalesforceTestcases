package SeleniumAss;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotation {

	static WebDriver driver;	
	@BeforeTest
	public void Setup(){
		String path= "/home/shubhangi/workspace/SeleniumDriver/src/utility/chromedriver";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
	}
	 
	@Test(dataProvider="testdata")
	public void TestFireFox(String uname,String password1)
	 
	{
	 
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys(uname);
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys(password1);
	}
	 
	@DataProvider(name= "testdata")
	public static String[][] readDataFromXl() throws IOException{
		String cur_dir=System.getProperty("user.dir");
		File file=new File(cur_dir+"/testData.xls");///home/shubhangi/workspace/SeleniumDriver/testData.xls
		FileInputStream fs=new FileInputStream(file);
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		
		HSSFSheet sheet=wb.getSheet("sheet1");
		
		int trow=sheet.getLastRowNum()+1;
		int tcol=sheet.getRow(0).getLastCellNum();
		String[][] s = new String[trow][tcol];
		System.out.println("total rows="+trow+" and total column="+tcol);
		for(int i=0;i<trow;i++){
			for(int j=0;j<tcol;j++){
				int cellType=sheet.getRow(i).getCell(j).getCellType();
				System.out.println("cell type:"+cellType);//cell type 1(String) or 0(int), cell type numeric is 0
				if(cellType==HSSFCell.CELL_TYPE_NUMERIC)					
					s[i][j]=String.valueOf((int)sheet.getRow(i).getCell(j).getNumericCellValue());
				else
				s[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();	
		
			}
		}
		
		return s;
	}
}
