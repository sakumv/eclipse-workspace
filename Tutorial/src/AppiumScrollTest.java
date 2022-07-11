import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class AppiumScrollTest extends BaseIOSTest {

	public static void main(String[] args) throws MalformedURLException  {
		// TODO Auto-generated method stub

		IOSDriver<WebElement> driver = setUpCap();
		
		//scroll --> use javascripit
		HashMap<String,Object> scrollObject = new HashMap<>();
		
		//To scroll down
		scrollObject.put("direction", "down")
		//To find the value and stop scrolling
		scrollObject.put("name","Web View");
		
		//find that element by executing the script and click on the WebView
		driver.executeScript("mobile:scroll", scrollObject);
		driver.findElementByAccessibilityId("Web View").click();
		Thread.sleep(5000);
		
		//Go back screen 
		driver.findElementByXPath("//XCUIElementTypeButton[@name='UIKitCatalog']").click();
		//Select picker view for drop down menu selection
		driver.findElementByAccessibilityId("Picker View").click();
		//Set the value and the drop down will be selected automativally
		
		driver.findElementByAccessibilityId("Red Color Component Value").sendKeys("90");
		driver.findElementByAccessibilityId("Green Color Component Value").sendKeys("200");
		driver.findElementByAccessibilityId("Blue Color Component Value").sendKeys("100");

		
		//Cehck whether whatever we selected has appeared or not
		
		System.out.println(driver.findElementByAccessibilityId("Blue Color Component Value").getText());
	}

}
