package AndroidDriverutiliy;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GestureUtility {

	public WebElement scrollByText(AndroidDriver driver, String text)
	{
		WebElement st = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		return st;

	}
	public WebElement WebElement(AndroidDriver driver, String xpath)
	{
		WebElement st = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(xpath(\""+xpath+"\"));"));
		return st;

	}
	public void clickAtXY(AndroidDriver driver, int x, int y)
	{
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture",ImmutableMap.of("x",x,"y",y));
	}
	public void clickAtElement(AndroidDriver driver, WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));
	}
	public void longClick(AndroidDriver driver, WebElement element, long time)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"duration",time));

	}
	public void dragAndDrop(AndroidDriver driver, WebElement element, int x, int y)
	{
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"x",x,"y",y));

	}
	public void zoomIn(AndroidDriver driver,WebElement element, double percent)
	{
		((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"percent",percent));

	}
	public void zoomOut(AndroidDriver driver,WebElement element, double percent)
	{
		((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"percent",percent));

	}
	public void doubleClickAtElement(AndroidDriver driver, WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: doubleClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));
	}
	
	public void swipe(AndroidDriver driver, long left,long width,long top, long height,String direction,double percent)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap.of("left", left, "top", top, "width", width, "height", height, "direction",direction,"percent",percent));
	}
	public WebElement scrollToElementUsingText(AndroidDriver driver, String text) {
		
		WebElement ele = driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		return ele;

	}
	
	
}
