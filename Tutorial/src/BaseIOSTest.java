import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseIOSTest {

	public static IOSDriver setUpCap() throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.2"); // ios Version supported got from xcrun simctl list 
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro"); // same as above
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(IOSMobileCapabilityType.COMMAND_TIMEOUTS,50000);
		cap.setCapability("commandTimeouts", 12000); //for each app to load
		cap.setCapability(MobileCapabilityType.APP,"Users/sakuj/Desktop/Appium/UIKitCatalog.app");
		
		IOSDriver driver = new IOSDriver<> (new URL("http://localhost:4723/wd/hub"),cap); // sppium server port address
		return driver;
		
	}
}
