package iosSetup;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class IOSSlider extends IOSBaseSetup {

	
	@Test
	public void IOSSliderTest() throws InterruptedException {
			
		WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == 'AppElem'`]"));
		slider.sendKeys("0%"); //setValue
		Assert.assertEquals("0%", slider.getAttribute("value"));
		Thread.sleep(3000);
		slider.sendKeys("1%"); //This is 100%... .5 would be middle
		Assert.assertEquals("100%", slider.getAttribute("value"));
		
	}
}
