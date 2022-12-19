package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContextLocator {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  //Launch chrome
		
		driver.get("https://s8bk.unicloud9.co.in/");
		
		// Case 1 : Correct Username and Password ->
		
		// Set Username
		driver.findElement(By.xpath("//input[@id='id_email_id']")).sendKeys("ritesh.shalanki@uniapply.com");
		
		// Set Password
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("teamwork");
		driver.findElement(By.xpath("//button[@id='loginFormSubmitBtn']")).click();
		
		driver.findElement(By.className("wt-btn-back")).click();
		driver.findElement(By.className("userIcon")).click();
		driver.findElement(By.className("icon-logout")).click();
		
		// Case 2 : Incorrect Username and Correct Password
		driver.findElement(By.xpath("//input[@id='id_email_id']")).sendKeys("ritesh.shalankiuniply.com");
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("teamwork");
		driver.findElement(By.xpath("//button[@id='loginFormSubmitBtn']")).click();

		// Case 3 : Correct Username and Incorrect Password
		driver.findElement(By.xpath("//input[@id='id_email_id']")).clear();
		driver.findElement(By.xpath("//input[@id='id_password']")).clear();
		driver.findElement(By.xpath("//input[@id='id_email_id']")).sendKeys("ritesh.shalanki@uniapply.com");
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("teamwk");
		driver.findElement(By.xpath("//button[@id='loginFormSubmitBtn']")).click();

		// Case 4 : Empty username and empty password fields
		driver.findElement(By.xpath("//input[@id='id_email_id']")).clear();
		driver.findElement(By.xpath("//input[@id='id_password']")).clear();
		driver.findElement(By.xpath("//button[@id='loginFormSubmitBtn']")).click();
		
//		// ID
////		driver.findElement(By.id("id_email_id")).sendKeys("ritesh.shalanki@uniapply.com");
//		
	}

}
