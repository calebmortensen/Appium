package iOS;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class IOSLongPress extends IOSBaseSetup {

	
	@Test
	public void IOSLongPressTest() {
			driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
			WebElement element = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
			Map <String,Object>params = new HashMap<>();
			params.put("element", ((RemoteWebElement)element).getId());
			params.put("duration", 5);
			driver.executeScript("mobile:touchAndHold", params);
		
	}
}
