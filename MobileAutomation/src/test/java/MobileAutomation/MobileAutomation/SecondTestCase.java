package MobileAutomation.MobileAutomation;
//import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import junit.framework.Assert;

import java.net.MalformedURLException;
import java.text.DecimalFormat;

public class SecondTestCase extends Base{
	
		
	public void ScrollingFirstapproach() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();
		Thread.sleep(2000);
		//driver.findElement((By.xpath("//android.widget.EditText[@text()='Enter name here']"))).sendKeys("Kavitha");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")).sendKeys("Kavitha");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//android.widget.TextView[@text()='India']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]")).click();
		Thread.sleep(3000);
		
		//Scroll to Item1
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
		String price1 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$55.0\"]")).getAttribute("text");
		System.out.println(price1);
		//Add to Cart
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();
		Thread.sleep(3000);
	    //Scroll to Item2
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))"));
		Thread.sleep(4000);
		String price2 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$115.0\"]")).getAttribute("text");
		Thread.sleep(4000);
		System.out.println(price2);
		//Add to Cart
		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();
		Thread.sleep(3000);
		//Enter to cart
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		String totalPrice=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]")).getDomAttribute("text");
		System.out.println(totalPrice);
		
		//Sum price1 and price2
		double num1 = Double.parseDouble(price1.replace("$", ""));
		double num2 = Double.parseDouble(price2.replace("$", ""));
		double totalPrice1 = Double.parseDouble(totalPrice.replace("$", ""));
		double sum = num1 + num2;
		DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");
		String formattedSum = decimalFormat.format(sum);
		if(totalPrice1 == sum) {
			System.out.println("test passed");
		}
		else {
			System.out.println("test not passed");
		}
	/*	driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();
		Thread.sleep(2000);
	*   String toastMessage = driver.findElement((By.xpath("//android.widget.Toast[@text()='Please enter your name']")));
	 *  String toastMessage = driver.findElement((By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println(toastMessage);
		Assert.assertEquals(toastMessage, "Please enter your name");*/
	}

	

	public static void main(String args[]) throws Exception {
		SecondTestCase secondTestCase = new SecondTestCase();
		secondTestCase.configuration();
		secondTestCase.ScrollingFirstapproach();
		
	}


}

