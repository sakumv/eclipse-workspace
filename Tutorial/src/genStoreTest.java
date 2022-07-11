import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class genStoreTest extends genClass{

	public static void main(String[] args) throws MalformedURLException {
		
		//Test Scenarios
		/*
		 * 1. Fill the form with wrong inputs and check whether toast message appears or not
		 * 2.Shop the items and add to cart with scrolling functionality
		 * 3. Validate if the added items in the cart appears in the check out page
		 * 4. Validate the total amount 
		 * 5. Validate mobile gesture working for links for long press
		 * 
		 * driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     
		 * 
		 * 
		 * */
		
		//1. Positive test case for first page
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementById("android:id/text1").click();
		//check the popup menu and select country
		
		//Scroll down till you view the element to click
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByXPath("//*[@text='Argentina']").click();

		//enter anything in name field
		driver.findElementByClassName("android.widget.EditText").sendKeys("Test");
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//*[@text='Male']")).click();
		
		//click button
		driver.findElementByClassName("android.widget.Button").click();
		
		
	}

}
