package setup;


import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import io.appium.java_client.AppiumBy;


public class AppiumBasics extends BaseTest {

	@Test
	public void WifiSettingsName() throws MalformedURLException, URISyntaxException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		
		
	}
}
