package AndroidDriverutiliy;

import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

public class AndroidDriverUtility {
     
	public String readToastMessage(AndroidDriver driver)
	{
		WebDriverWait waitForToast = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		String toastMessage = driver.findElement((AppiumBy.xpath("/hierarchy/android.widget.Toast"))).getText();
		return toastMessage;

	}
	public void installApp(AndroidDriver driver,String path)
	{
		driver.installApp(path);
	}
	public boolean verifyAppInstall(AndroidDriver driver,String packageName)
	{
		boolean st = driver.isAppInstalled(packageName);
		return st;
		
	}
	
	public void removeApp(AndroidDriver driver,String packagename)
	{
		driver.removeApp(packagename);
	}
	public void lunchApp(AndroidDriver driver,String packagename)
	{
		driver.activateApp(packagename);
	}
	public void closeApp(AndroidDriver driver,String packagename)
	{
		driver.terminateApp(packagename);
	}
	public void runAppInBackGround(AndroidDriver driver,int duration)
	{
      driver.runAppInBackground(Duration.ofSeconds(duration));
	}
	public void hideKey(AndroidDriver driver)
	{
		driver.hideKeyboard();
	}
	public void LandscapeOrientation(AndroidDriver driver)
	{
		ScreenOrientation sc = driver.getOrientation();
		driver.rotate(sc.LANDSCAPE);
	}
	public void potraitOrientation(AndroidDriver driver)
	{
		ScreenOrientation sc = driver.getOrientation();
		driver.rotate(sc.PORTRAIT);
	}
	public ApplicationState appState(AndroidDriver driver, String packageName)
	{
		ApplicationState state = driver.queryAppState(packageName);
		return state;
	}
	
   public void switchToContext(AndroidDriver driver, String Partitalcontext) throws InterruptedException
   {
	   Set<String> context = driver.getContextHandles();
		for(String co: context)
		{ 
			System.out.println(co);
			driver.context(co);
			if(co.contains(Partitalcontext))
			{
				break;
			}
			
		}
   }
   public void waitForPageToLoad(AndroidDriver driver) 
   {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   
   }
   public void waitForElement(AndroidDriver driver,WebElement ele)
   {
	   WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
   }
  
   
	
}
