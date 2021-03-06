		
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class AndUIAutomator extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Syntax for findelement by androidUIautomator
		//driver.findElementByAndroidUIAutomator("attribute(\"value\")");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
			//Animation
		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		
		
		//Syntax for findElementsByAndroidUIAutomator(new UISelector().property("value"));
		int count = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(false)").size();
		System.out.print(count);
		
		
	}
	
}

		
		

