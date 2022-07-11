
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import junit.framework.Assert;

import static java.time.Duration.ofSeconds;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class testcase_gestures extends genClass{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//1. Add to cart for specific items
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementById("android:id/text1").click();
		//check the popup menu and select country
		
		//Use default country and gender, so nothing to do
		//Scroll down till you view the element to click
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Albania\"));");
		driver.findElementByXPath("//*[@text='Albania']").click();


		//enter something in name field
		driver.findElementByClassName("android.widget.EditText").sendKeys("Test");
		driver.hideKeyboard();
		
		
		//click button
		driver.findElementByClassName("android.widget.Button").click();
		
		String[] arrChosen = {"Air Jordan 4 Retro","Converse All Star"}; //,"PG 3"
		
		//Get the selected item by scrolling and correspondingly click add to cart
		//List com.androidsample.generalstore:id/rvProductList
		// Product to choose - 		Converse All Star - com.androidsample.generalstore:id/productName
		// addtocart - com.androidsample.generalstore:id/productAddCart
		// cart on top - com.androidsample.generalstore:id/appbar_btn_cart
		
		for (int x=0; x < arrChosen.length; x++)
		{
				System.out.println(arrChosen[x]);
				String strChosen = arrChosen[x];
				// To do - Scroll through the lisr
				//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"+ arrChosen[x] +\"));");
		
				driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""+ strChosen +"\").instance(0))"));
				
				
				int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
				
				// find the chosen product
				for (int i=0; i<= count; i++  )
				{
					//get the text of the item and check if it is equla to chosen one
					// get the index and get the index of add to cart next to the product and click
					String itemText = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
					if (strChosen.equalsIgnoreCase(itemText))
					{
						//click that add to cart
						driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
						break;
					}
				}
				
				
				
		}		
				
		//Click on the cart on the top 		// click on the cart icon on top to see the item added
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
		// Tap the check box and Click Privacy terms and conditions using the mobile gestures
		//Clikc on the button to view the link in webview

		WebElement checkbox = driver.findElement(By.xpath("//*[@class='android.widget.CheckBox']"));
		//com.androidsample.generalstore:id/termsButton
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
//		WebElement terms = driver.findElementByXPath("//*[@text = 'Please read our terms of conditions']");
//		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
//		
		//Click on the close button
		//driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		//go and check webview
		Thread.sleep(1000);
		
		Set<String> setContexts = driver.getContextHandles();
		for(String strContext : setContexts)
		{
			System.out.println(strContext);
			if (strContext.contains("WEBVIEW")) 
			{
				System.out.println(driver.getContext());
				driver.context(strContext);
				break;
			}
			
		}
		
		Thread.sleep(1000);
		
		System.out.println(driver.getContext());
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		
	}

}
