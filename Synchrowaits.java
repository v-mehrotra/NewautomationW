package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchrowaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  //Launch chrome
//		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// Note : Implicitly always use for global wait that means it will apply on all the element of the page
		//        which are mentioned.
		
		driver.get("https://s8bk.unicloud9.co.in/");
		WebElement username = driver.findElement(By.xpath("//input[@id='id_email_id']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='id_password']"));
		WebElement button = driver.findElement(By.xpath("//button[@id='loginFormSubmitBtn']"));
		
		sendKeys(driver,username,10,"ritesh.shalanki@uniapply.com");
		sendKeys(driver,password,5,"teamwork");
		clickOn(driver,button,5);
	}
	
	public static void sendKeys(WebDriver driver,WebElement element,int timeout,String value) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
 
	public static void clickOn(WebDriver driver,WebElement element,int timeout) {
		new WebDriverWait(driver,Duration.ofSeconds(timeout)).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
