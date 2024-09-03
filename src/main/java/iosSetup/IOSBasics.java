package iosSetup;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseSetup {

	
	@Test
	public void IOSBasicsTest() {
		//xpath, classname, IOS, iosClassChain, IOSPredicateString, accessibility id, id
		//Note: predicate means attribute + value
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		//xpath is SLOW on iphone -> iosClassChain
		//driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
		//popup
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello Caleb");
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		// can use MORE THAN 2 attributes unlike Android
		//driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'"));
		//driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'"));
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
		String text = driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText();
		Assert.assertEquals(text, "A message should be a short, complete sentence.");
		System.out.println(text);
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
		
		
		
		
	}
}
