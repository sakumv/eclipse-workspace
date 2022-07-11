
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import junit.framework.Assert;

public class genStoreTestcase_multiple extends genClass{

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
	
//		//Check whether the same item appears in the text in 3rd page
//		int y = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//		String[] arrSelect = new String[y];
//		System.out.println(y);
//		
//
//		for (int j =0; j<= y ; j++)
//		{
//			arrSelect[j] = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(j).getText();
//
//		}		
//		//Sort the arrays in case 	
//		Arrays.sort(arrSelect);
//		Arrays.sort(arrChosen);
//		
//		for (int z = 0; z <=arrChosen.length; z++)
//		{
//			String strActual = arrSelect[z];
//			System.out.println(strActual);
//			
//			String strChosen = arrChosen[z];
//			System.out.println(strChosen);
//
//			Assert.assertEquals(strChosen, strActual);			
//			
//		}

		
		//Check whether the items in the chosen items are existing in the cart page
		
		for (int j=0; j< arrChosen.length; j++)
		{
			String strChosen = arrChosen[j];
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")).scrollIntoView(new UiSelector().text(\""+ strChosen +"\"));");
			String strDisp =  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")).scrollIntoView(new UiSelector().text(\""+ strChosen +"\"));").getText();
			Assert.assertEquals(strChosen, strDisp);
		}
		
		
		
		
		
		
	}

}
