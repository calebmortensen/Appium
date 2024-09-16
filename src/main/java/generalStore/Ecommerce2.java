package generalStore;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import androidSetup.BaseSetup;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecommerce2 extends BaseSetup{

	@Test
	public void PopulateForm() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Caleb");
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
		
		//findElement(S) ->add to cart changes to Added, so we can use get(0) twice which will change the index
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		//Cart page			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> productPrices= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count= productPrices.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = productPrices.get(i).getText();
			//remove $ sign, convert to Double for decimal  
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;   //160.97 + 120 = 280.97
		}
		
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormattedAmount(displaySum);
		
		Assert.assertEquals(totalSum, (double)displayFormattedSum);
		
		WebElement element = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(element);
		//Click 'Close" button of Terms and Conditions prompt
		driver.findElement(By.id("android:id/button1")).click();
		//Click email check box
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		//Submit order
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(8000);
		
		//HYBRID - App that is Native with Browser
		
		//this gets all handles that are Currently Active
		Set<String> contexts = driver.getContextHandles();
		for(String contextName :contexts) //Enhanced For Loop
		{
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore"); //chrome driver
		driver.findElement(By.name("q")).sendKeys("Chicken Pot Pie");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		//Switch back to NATIVE APP
		driver.context("NATIVE_APP");
		
		//Current browser version is  ECOMMERCE APP is: 124.0.6367.219 -> Download
		//https://storage.googleapis.com/chrome-for-testing-public/124.0.6367.219/win64/chromedriver-win64.zip
		
		
		
		
		
		
	}
	
	
		
}