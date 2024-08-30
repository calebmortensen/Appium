package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class NavigateToActivity extends BaseTest {

	@Test
	public void Navigate() throws MalformedURLException, InterruptedException
	{
		
		//To navigate to a SPECIFIC Activity (page) without going through each
		//From a terminal, ADB Devices
		//ADB shell dumpsys window | find "mCurrentFocus"
		//OUTPUT is in this format:  package / activity
		//mCurrentFocus=Window{59cb287 u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
				
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));				
				
		driver.findElement(By.id("android:id/checkbox")).click();
		
		Thread.sleep(3000);
	}
}
