import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseWebChrome {
	public static AndroidDriver<AndroidElement> setUp() throws MalformedURLException
	{
	
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_5_API_30");

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");



		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;
		

	}
		

}
