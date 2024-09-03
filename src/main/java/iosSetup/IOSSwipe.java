package iosSetup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class IOSSwipe extends IOSBaseSetup {

	
	@Test
	public void IOSSwipeTest() throws InterruptedException {
			
		// iOS Bundle ID - to identify the App
		Map <String,Object> params = new HashMap<>();
		params.put("bundleId", "com.apple.mobileslideshow"); //NOTE: BaseTest still calls NATIVE app
		driver.executeScript("mobile:launchApp", params);
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
		List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
		System.out.println(allPhotos.size());
		driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
		for(int i=0; i<allPhotos.size(); i++) {
		System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
		Map <String,Object> params1 = new HashMap<>();
		params1.put("direction", "left"); //if you don't provide coordinates of where to swipe, default swipes from Center
		driver.executeScript("mobile:swipe", params1);
		}
		driver.navigate().back();
		driver.findElement(AppiumBy.accessibilityId("Albums")).click(); //cleanup to return to Albums screen
	}
}
