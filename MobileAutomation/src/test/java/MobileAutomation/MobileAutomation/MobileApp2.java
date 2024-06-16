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

public class MobileApp2 {
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
	  
		  WebElement app1 = driver.findElement(AppiumBy.accessibilityId("App"));
		  app1.click();
		  WebElement menu =  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Menu']"));
		  menu.click();
		  WebElement inflateXml = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Inflate from XML']"));
		  inflateXml.click();
		  WebElement titleonlyDropdown = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));
		  titleonlyDropdown.click();
		  /*WebElement orderText = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Order']"));
		  orderText.click();
		  WebElement orderMenu = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));
		  orderMenu.click();*/
		  //WebElement groupsdropDown = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Groups']"));
		  //groupsdropDown.click();
		  
		  //WebElement spinnerDropdown = driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='io.appium.android.apis:id/spinner']"));
		  //Select spinnerDropdown = new Select(driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='io.appium.android.apis:id/spinner']")));
		  //spinnerDropdown.selectByVisibleText("Order");
		  //spinnerDropdown.click();
		 /* 
		  Select orderText = new Select(driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Order']")));
		  orderText.selectByVisibleText("Order");
		  
		  //orderText.click();
		  WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));
		  element.click();
		  WebElement categoryorderDropdown = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Category and Order']"));
		  categoryorderDropdown.click();
		  Select categoryDropdown = new Select(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']")));
		  categoryDropdown.selectByVisibleText("Category and Order");
		  // categoryDropdown.clcik();
		  WebElement checkable = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Checkable']"));
		  checkable.click();*/
		  
		  
		 
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		  
	}


}
