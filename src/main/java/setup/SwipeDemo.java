package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest {

	@Test
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		//Initially, BEFORE Swipe, focusable on the element defaults to true
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");
		//Swipe
		swipeAction(firstImage, "left");
		
		
		//AFTER Swipe, the element will turn to false
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");
	}
}
