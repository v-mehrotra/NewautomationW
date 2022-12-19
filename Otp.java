package selenium;
import org.testng.annotations.AfterClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;


@Test
public class Otp {
	WebDriver driver;
	@BeforeTest
	public void setUp() throws FileNotFoundException, IOException{
	
		 JsonReader JSONRead = new JsonReader(null);
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("BROWSER_NAME", "Android");
			capabilities.setCapability("deviceName","Redmi 9 Prime");
			capabilities.setCapability("platformName","Android");
			capabilities.setCapability("appPackage","com.android.mms");
			capabilities.setCapability("appActivity","com.android.mms.ui.ConversationList");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}
	public void ReadOTP() throws Exception {
	  driver.findElement(By.id("com.android.mms:id/subject")).click();
      System.out.println( driver.findElement(By.id("com.android.mms:id/text_view")).getText());
	}
	@AfterClass
	public void teardown(){
		driver.quit();
	}

	
}
