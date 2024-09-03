package iosSetup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class IOSBaseSetup {
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException{
		
		//code to start automation instead of running appium from command line
				service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\caleb\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				
				//Appium code -> Appium Server -> Mobile
				//capabilities is android or ios etc
				//appium driver install xcuitest  for MAC
				//no uiautomator in MAC
				
				XCUITestOptions options = new XCUITestOptions();
				options.setDeviceName("iPhone 13 Pro");
				//options.setApp("C:\\Users\\caleb\\EWS\\Appium\\src\\main\\java\\resources\\UIKitCatalog.app");
				options.setApp("C:\\Users\\caleb\\EWS\\Appium\\src\\main\\java\\resources\\TestApp 3 app");
				options.setPlatformVersion("15.5");
				//Appium - will install Webdriver Agent in IOS apps (substitute for uiautomator2 in android)
				options.setWdaLaunchTimeout(Duration.ofSeconds(20));

				driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
												
			}
				
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
		
		
	}
	
	
	
}
