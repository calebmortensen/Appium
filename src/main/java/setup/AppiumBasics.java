package setup;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumBasics {

	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException
	{
		//code to start automation instead of running appium from command line
		//Appium code -> Appium Server -> Mobile
		//capabilities is android or ios etc
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("MP35"); //emulator
		options.setApp("C:\\Users\\caleb\\EWS\\Appium\\src\\main\\java\\resources\\ApiDemos-debug.apk");
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		driver.quit();
		
	}
}
