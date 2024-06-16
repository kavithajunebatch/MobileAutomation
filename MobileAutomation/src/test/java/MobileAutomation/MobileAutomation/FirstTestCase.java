package MobileAutomation.MobileAutomation;
//import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;

public class FirstTestCase extends BasePage{
	
	public void simpleEvents() 
	{
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
		  		  
			  
	}
	
	
	@SuppressWarnings("deprecation")
	public void deviceRotationToLandscape() {
		WebElement button = driver.findElement(AppiumBy.accessibilityId("Preference"));
		button.click();
		WebElement preferenceDep =  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"));
		preferenceDep.click();
		WebElement wifiCheckbox = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]"));
		  wifiCheckbox.click();
		  WebElement wifiSettings = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]"));
		  wifiSettings.click();
		  ((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
		  
	}
	
	public void longPress() {

		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
		views.click();
		WebElement expandableList = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]"));
		expandableList.click();
		WebElement customAdapter = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]"));
		customAdapter.click();
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
			    "duration", 2000));
		
	}
	
	public void ScrollingFirstapproach() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
	    Thread.sleep(2000);
	}

	public void ScrollingSecondapproach() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		boolean scrollMore = false;
		do {
		scrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 1.0
				));
		}while(scrollMore);
		}
	public void swipeGesture() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement firstImage=driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		swipeAction(firstImage, "left");
	}
	
	public void swipeAction(WebElement element,String direction) throws InterruptedException
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
			    "direction", direction,
			    "percent", 1.0,"speed",15000
			));	

		Thread.sleep(2000);
	}
	
	public void DragAndDrop() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 619,
			    "endY", 577
			));
		Thread.sleep(5000);
	String result=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
	System.out.println("Result is "+result);
	}

	public void otherActivities() throws Exception
	{
		WebElement button=driver.findElement(AppiumBy.accessibilityId("Preference"));
		 button.click();
		 WebElement preferenceDep=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"));
		 preferenceDep.click();
		 WebElement checkbox=driver.findElement(By.id("android:id/checkbox"));
		 checkbox.click();
		 DeviceRotation landScape=new DeviceRotation(0,0,90);
		 driver.rotate(landScape);
		 
		 
		 
		 WebElement wifisetting=driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout"));
		 wifisetting.click();
		 driver.setClipboardText("Kavitha");
		 
		 WebElement text=driver.findElement(By.id("android:id/edit"));
		 text.sendKeys(driver.getClipboardText());
		 driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		 WebElement ok=driver.findElement(By.id("android:id/button1"));
		 ok.click();
		 
	}

	public static void main(String args[]) throws Exception {
		FirstTestCase firstTestCase = new FirstTestCase();
		firstTestCase.configuration();
		/*firstTestCase.simpleEvents();
		firstTestCase.swipeGesture();*/
		//firstTestCase.ScrollingFirstapproach();
		//firstTestCase.ScrollingSecondapproach();
		//firstTestCase.longPress();
		firstTestCase.DragAndDrop();
	}


}
