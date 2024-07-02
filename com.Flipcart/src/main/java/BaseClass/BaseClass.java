package BaseClass;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import AndroidDriverutiliy.AndroidDriverUtility;
import Fileutility.Fileutility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseClass {
	public AndroidDriver driver;
	public static AndroidDriver sdriver;
	AppiumDriverLocalService as;
	Fileutility fu= new Fileutility();
	public  AndroidDriverUtility adu= new AndroidDriverUtility();


	@BeforeSuite
	public void configBs() throws IOException
	{
		System.out.println("connect to Appium server");
		File f= new File(fu.getdataFromPropertyFile("mainJs_vinay"));
		as=new AppiumServiceBuilder().withAppiumJS(f).
				withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();//withtimeout is optional

		as.start();

	}

	@BeforeClass
	public void configBc() throws Throwable
	{
		System.out.println("capability");

		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", fu.getdataFromPropertyFile("platformName"));
		dc.setCapability("automationName",fu.getdataFromPropertyFile("automationName"));
		dc.setCapability("noReset",true);
		dc.setCapability("autoGrantPermission",true);
		dc.setCapability("ignorHiddenApiPolicyError", true);
		dc.setCapability("appPackage",fu.getdataFromPropertyFile("appPackage"));
		dc.setCapability("appActivity",fu.getdataFromPropertyFile("appActivity"));
		URL u= new URL("http://localhost:4723");
		driver= new AndroidDriver(u,dc);
		
		driver.activateApp(fu.getdataFromPropertyFile("appPackage"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		sdriver= driver;

	}
	

	@AfterClass
	public void configAc() throws IOException
	{
		System.out.println("Close app");
		adu.closeApp(driver, fu.getdataFromPropertyFile("appPackage"));


	}
	@AfterSuite
	public void configAs()
	{
		System.out.println("close  appium serverconnection");
		as.stop();


	}
}
