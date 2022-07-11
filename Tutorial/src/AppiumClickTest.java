import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class AppiumClickTest extends BaseIOSTest  {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		IOSDriver<WebElement> driver = setUpCap();
		
		
		//find the element through appium inspector  using xpath / accesibilityid
		driver.findElementByAccessibilityId("Alert Views").click();
		
		//xpath //tagname[@attibute=value]
		
		driver.findElementByXPath("XCUIElementTypeStaticText[@name='Text Entry']").click();
		driver.findElementByXPath("XCUIElementTypeCell").sendKeys("HEllo");
		driver.findElementByAccessibilityId("OK").click();
		driver.findElementByAccessibilityId("Confirm / Cancel").click();
		
		//To check whether the message is displayed 
		System.out.println(driver.findElementByXPath("//*[contains(@name,'message')]").getText());
		
		driver.findElementByAccessibilityId("Confirm").click();
	}

}
