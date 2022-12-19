package selenium;

import java.nio.channels.Selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelector {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  //Launch chrome
		
				driver.get("https://s8bk.unicloud9.co.in/");
				
				// Set Username
				driver.findElement(By.xpath("//input[@id='id_email_id']")).sendKeys("ritesh.shalanki@uniapply.com");
	
				driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("teamwork");
				driver.findElement(By.xpath("//button[@id='loginFormSubmitBtn']")).click();
				driver.findElement(By.className("wt-btn-back")).click();
				
			
				
				
				

	}

}
