package generalStore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends setup.BrowserBaseTest{

	@Test
	public void browserTest() throws InterruptedException {
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle()); 
		Thread.sleep(8000);
		driver.findElement(By.name("q")).sendKeys("Lasagna");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		
	}
	
	
}
