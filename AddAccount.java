package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import com.github.javafaker.Faker;

public class AddAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  //Launch chrome
		
		driver.get("https://s8bk.unicloud9.co.in/account/manage-account/");
	
				driver.findElement(By.xpath("//input[@id='id_email_id']")).sendKeys("ritesh.shalanki@uniapply.com");
				driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("teamwork");
				driver.findElement(By.xpath("//button[@id='loginFormSubmitBtn']")).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				driver.findElement(By.className("wt-btn-back")).click();
	
				driver.findElement(By.id("menu_li_2")).click();
				driver.findElement(By.id("menu_17")).click();
				Actions actions = new Actions(driver);
				
				WebElement target = driver.findElement(By.xpath("//a[contains(text(),'Business Accounts')]"));
				actions.moveToElement(target).click().perform();
				
				driver.findElement(By.xpath("//button[@id='entity_create_btn']")).click();
				driver.findElement(By.xpath("//div[contains(text(),'Select Account Type')]")).click();
				driver.findElement(By.xpath("//a[@id='bs-select-3-0']")).click();
				
				
				}
	
}
