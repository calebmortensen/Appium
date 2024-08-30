package apiDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import setup.BaseSetup;


public class MiscAppiumActions extends BaseSetup {

	@Test
	public void Misc() throws MalformedURLException, InterruptedException
	{
		//Rotate view
		
		/*
		 * DeviceRotation horizontal = new DeviceRotation(90, 0, 0);
		 * driver.rotate(horizontal);
		 */
		
		/*
		 * DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		 * driver.rotate(landScape);
		 */
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//copy to clip board - paste to clip board (Set & Get)
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		//Set Clipboard text
		driver.setClipboardText("Voltron");
		//Get Clipboard txt
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//Press BACK & HOME Button of the phone
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
}
