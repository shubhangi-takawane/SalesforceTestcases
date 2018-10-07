package TestDriver;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import TestScirpt.ReusableMethods;


public class InitialDriver {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		String dt_path = "/home/shubhangi/workspace/SeleniumDriver/TestSuit.xls";

		String[][] recData = ReusableMethods.readDataFromXl(dt_path, "Sheet1");

		for(int i = 1; i < recData.length; i++){
			if(recData[i][1].equalsIgnoreCase("Y")){
				String tc = recData[i][2];
				Method testScript = AutomationScripts.class.getMethod(tc);
				testScript.invoke(testScript);
			}else{
				System.out.println("In line number "+ i +" test script " + recData[i][2]+ " did not execution." );
			}
		}
	}

}



/*Java reflection or Java reflexive API*/
//Method testScript = AutomationScript.class.getMethod(tc);
//testScript.invoke(tc);
