package ListenersUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import AndroidDriverutiliy.JavaUtility;
import BaseClass.BaseClass;



public class ListenerImplementationClass implements ITestListener  {

	@Override
	public void onTestFailure(ITestResult result) {
		JavaUtility jlib= new JavaUtility();
		String testname=result.getName();
		String name = testname+jlib.getTimeStamp();
		TakesScreenshot ts= (TakesScreenshot)BaseClass.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src=new File("./ErrorShots/"+name+"");//./ is for current directory
		try {
			FileHandler.copy(temp, src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}


}
