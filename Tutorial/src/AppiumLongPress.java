import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class AppiumLongPress extends BaseIOSTest {

	public static void main(String[] args) throws MalformedURLException  {
		// TODO Auto-generated method stub

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.2"); // ios Version supported got from xcrun simctl list 
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro"); // same as above
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(IOSMobileCapabilityType.COMMAND_TIMEOUTS,50000);
		cap.setCapability("commandTimeouts", 12000); //for each app to load
		cap.setCapability(MobileCapabilityType.APP,"Users/sakuj/Desktop/Appium/LongTap.app");
		
		IOSDriver driver = new IOSDriver<> (new URL("http://localhost:4723/wd/hub"),cap); // sppium server port address

		
		MobileElement e = (MobileElement)driver.findElementByName("Long Tap");
		IOSTouchAction touch = new IOSTouchAction(driver);
		
		touch.longPress(longPressOptions().withElement(element(e)).withDuration(ofSeconds(2))).release().perform();
		
		//tap action
		MobileElement tapE = (MobileElement)driver.findElementByXPath("//XCUIElementTypeSwitch[1]");
		touch.tap(tapOptions().withElement(element(tapE))).perform();
		
		
		
		
//		///For real device automation
//		d.setCapability("xcodeOrgId","xxxxxxxx"); //
//		d.setCapability("xcodeSigningId","iPhone Developer");
//		d.setCapability("udid","xxxxxxxx");
//		d.setCapability("updateWDABundleId","xxxxxxx");


	}

}
