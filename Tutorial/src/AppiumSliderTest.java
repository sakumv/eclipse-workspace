import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class AppiumSliderTest extends BaseIOSTest {

	public static void main(String[] args) throws MalformedURLException  {
		// TODO Auto-generated method stub

		IOSDriver<WebElement> driver = setUpCap();
		
		driver.findElementByAccessibilityId("Sliders").click();
		IOSElement slider = (IOSElement)driver.findElementByXPath("//XCUIElementTypeSlider");
		slider.setValue("0%"); //0%
		slider.setValue("0.5%"); //50%
		
		System.out.println(slider.getAttribute("value"));
		
	}

}
