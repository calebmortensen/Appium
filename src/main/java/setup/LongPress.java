package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {

	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
	
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		longPressAction(element); //added to BaseClass
		/*
		 * ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
		 * ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),
		 * "duration",2000));
		 */
		
		//resource-id
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		//expected vs actual
		Assert.assertEquals(menuText, "Sample menu");
		//manually putting assertion in that should be true
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	
	}
}
