package MobileAutomation.MobileAutomation;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class MobileApp {
	public static void main(String[] args) throws Exception 
	{
		try { 
		File app =new File("C:\\Appium\\ApiDemo.apk");
		  
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
		  
		  
		 AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);	  
	  
		  WebElement button = driver.findElement(AppiumBy.accessibilityId("Preference"));
		  button.click();
		  WebElement preferenceDep =  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"));
		  preferenceDep.click();
		  WebElement wifiCheckbox = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]"));
		  wifiCheckbox.click();
		  WebElement wifiSettings = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]"));
		  wifiSettings.click();
		  WebElement enterText = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]"));
		  enterText.sendKeys("Hello Kavitha");
		  WebElement okButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
		  okButton.click();
		  
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		  
	}


}
