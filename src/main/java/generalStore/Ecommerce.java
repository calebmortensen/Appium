package generalStore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import setup.BaseSetup;

public class Ecommerce extends BaseSetup{

	@Test
	public void FillForm() throws InterruptedException {
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Caleb");
		//Keyboard hides the next UI element, so the following is necessary:
		driver.hideKeyboard();
		//Class - tagname[@attribute='value'
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		//open drop down with options
		driver.findElement(By.id("android:id/text1")).click();
		//scroll
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Toast Message - Remove content of name field to yield error (Good interview question)
		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Caleb");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//Scroll
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		//This is good to know below for several productNames, but since we already know the name, I think it's redundant
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
			for(int i=0; i<productCount; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{ //will keep iterating until it finds item
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
				
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		//Cart page			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();	
		Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
	}
		
}