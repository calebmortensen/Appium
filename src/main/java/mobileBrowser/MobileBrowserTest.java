package mobileBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends androidSetup.BrowserBaseTest{

	@Test
	public void browserTest() throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		//Click Hamburger menu
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		//Click Products
		driver.findElement(By.cssSelector("a[routerlink*='/products']")).click();
		//Scroll Down
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)","");
		//Click Devops link
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		Assert.assertEquals(text, "Devops");
		
	}
	
	
}
