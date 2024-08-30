package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;

public class DragDropDemo extends BaseTest {

	@Test
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

		//use Appium Inspector to get X,Y Coordinates
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) source).getId(), "endX", 775, "endY", 698));
		
		Thread.sleep(3000);

		
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
	}

}