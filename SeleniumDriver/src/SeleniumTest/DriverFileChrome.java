package SeleniumTest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import SeleniumTest.ReusableMethode;

public class DriverFileChrome {

	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String dt_path = "/home/shubhangi/workspace/SeleniumDriver/Xero.xls";

		String[][] recData = ReusableMethode.readDataFromXl(dt_path, "Sheet1");
		String testCase,flag,chromeStatus;
		
		for (int i = 1; i < recData.length; i++) {
			testCase = recData[i][0];
			flag = recData[i][1];
			if(flag.equalsIgnoreCase("y")){
				chromeStatus=recData[i][3];
				if(chromeStatus.equalsIgnoreCase("y")){
					//Method tc = SeleniumTestScript_1.class.getMethod(testCase);
					Method tc = SeleniumTestScript_2.class.getMethod(testCase);
					//Method tc = SeleniumTestScript_3.class.getMethod(testCase);
					//Method tc = SeleniumTestScript_4.class.getMethod(testCase);
					tc.invoke(tc);
				}
			}
		}

	}

}
