import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;



public class swipeDemo extends Base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		
		//Swiping action example
		//from right 15  swipe left to 45 
		
		//Steps to follow
		//long press with the element 15 for 2 seconds 
		//move to element 45 and release
		//and perform the action
		
		TouchAction t = new TouchAction(driver);
		WebElement first15 = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement next45 = driver.findElementByXPath("//*[@content-desc='45']");
		
		
		t.longPress(longPressOptions().withElement(element(first15)).withDuration(ofSeconds(2))).moveTo(element(next45)).release().perform();

		
	}

}
