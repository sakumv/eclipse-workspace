
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import junit.framework.Assert;

public class genStoreTestcase_3 extends genClass{

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
		
		//1. Add to cart for specific item
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementById("android:id/text1").click();
		//check the popup menu and select country
		
		//Scroll down till you view the element to click
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByXPath("//*[@text='Argentina']").click();

		//enter something in name field
		driver.findElementByClassName("android.widget.EditText").sendKeys("Test");
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		
		//click button
		driver.findElementByClassName("android.widget.Button").click();
		
		//Get the selected item by scrolling and correspondingly click add to cart
		//List com.androidsample.generalstore:id/rvProductList
		// Product to choose - 		Converse All Star - com.androidsample.generalstore:id/productName
		// addtocart - com.androidsample.generalstore:id/productAddCart
		// cart on top - com.androidsample.generalstore:id/appbar_btn_cart
		
		// To do - Scroll through the lisr
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"));");

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(count);
		
		String strChosen = "Converse All Star";
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
		//Click on the cart on the top 		// click on the cart icon on top to see the item added
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
		//Check whether the same item appears in the text in 3rd page
		String strActual = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		
		Assert.assertEquals(strChosen, strActual);
		
		
	}

}
