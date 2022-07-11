
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import junit.framework.Assert;

public class genStoreTestcase_2 extends genClass{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
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
		
		//1. Negative test case for first page to show toast message
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementById("android:id/text1").click();
		//check the popup menu and select country
		
		//Scroll down till you view the element to click
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByXPath("//*[@text='Argentina']").click();

		//enter nothing in name field
		//driver.findElementByClassName("android.widget.EditText").sendKeys("Test");
		//driver.hideKeyboard();
		
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		
		//click button
		driver.findElementByClassName("android.widget.Button").click();
		
		
		//Check whether Toast message appears
		Thread.sleep(1000);
		//boolean isDisp = driver.findElementByXPath("//android.widget.Toast[1]").isDisplayed(); // --> gives staleObject Exception
		boolean isDisp = true;
		//if displayed, get the value of the toast message --> use name attribute to get value
		String expResult = "Please enter your name";
		String actResult = "";
		if (isDisp)
		{
			actResult = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		}
		
		System.out.println(actResult);
		Assert.assertEquals(expResult, actResult);
	}

}
