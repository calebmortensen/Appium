package iosSetup;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class IOSScroll extends IOSBaseSetup {

	
	@Test
	public void IOSScrollTest() throws InterruptedException {
		
		    Map <String,Object>params = new HashMap<>();
		    WebElement element = driver.findElement(AppiumBy.accessibilityId("Web View"));
		    params.put("direction", "down");
		    params.put("element", ((RemoteWebElement)element).getId());
		    
			driver.executeScript("mobile:scroll", params);
			driver.findElement(AppiumBy.accessibilityId("Web View")).click();
			
			Thread.sleep(2000);
			
			//Click Back button
			driver.findElement(By.xpath("XCUIElementTypeButton[@name='UIKitCatalog']")).click();
			//Picker View (3 scrolling wheels)
			driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
			driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
			driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
			driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).sendKeys("105");
			String number = driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).getText();
			Assert.assertEquals(number, "105");
		
	}
}
