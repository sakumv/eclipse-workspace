
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class genClass {

	//public static void main(String[] args) throws MalformedURLException {
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		// TODO Auto-generated method stub

		//Set the Appname, .apk path and Android Emulator 
		DesiredCapabilities cap = new DesiredCapabilities();
		
		File appDir = new File("src");
		File f = new File(appDir, "General-Store.apk");
		// Enter device name as "Pixel_Saku" for emulator and "Android Device" for real device
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_5_API_30");
		cap.setCapability(MobileCapabilityType.APP,f.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		//Set the Android driver and include the above capabilities
		AndroidDriver<AndroidElement> driver = new AndroidDriver<> (new URL("http://127.0.0.1:4723/wd/hub"), cap);

		return driver;
		
	}

}
