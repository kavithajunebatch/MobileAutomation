package MobileAutomation.MobileAutomation;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base {
	public static AndroidDriver driver;
	public void configuration() throws Exception 
	{
		try { 
		//File app =new File("C:\\Appium\\ApiDemo.apk");
			File app =new File("C:\\Users\\mkavi\\Downloads\\General-Store.apk");
		  File js = new File("C:\\Users\\mkavi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		  AppiumDriverLocalService service =
		  new AppiumServiceBuilder()
		  .withAppiumJS(js)
		  .withIPAddress("0.0.0.0")
		  .withArgument(GeneralServerFlag.BASEPATH, "wd/hub")
		  .usingPort(4723)
		  .build();
		  service.start();
		  
		  DesiredCapabilities cap = new DesiredCapabilities();
		  cap.setCapability("app", app.getAbsolutePath());
		  
		  cap.setCapability("deviceName", "ZY22D7NR7X");
		  //cap.setCapability("deviceName", "emulator-5554");
		  cap.setCapability("platformName", "Android");
		  cap.setCapability("automationName","UiAutomator2"); 
		  
		  
		   driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);	  
	  
		  
		 
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		  
	}


}
