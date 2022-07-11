import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class gesturesJava extends Base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		TouchAction t = new TouchAction(driver);
		
		WebElement expList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		t.tap(tapOptions().withElement(element(expList))).perform();

		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		
		
		WebElement pn = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
		
		Thread.sleep(2000);
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		
		

		
		
		
	}

}
