package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPaymentUniapply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

try {		
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://s2.collexo.co.in/test/");
			
			// getting fee id field
			WebElement feeId = driver.findElement(By.xpath("//input[@id='id_fee_id']"));
			feeId.clear();
			feeId.sendKeys("1742");
			
			//getting email address field
			WebElement emailId = driver.findElement(By.xpath("//input[@id='id_email']"));
			emailId.sendKeys("vanshika.m@uniapply.com");
			
			//getting mobile number field
			WebElement mobile = driver.findElement(By.xpath("//input[@id='id_mobile']"));
			mobile.sendKeys("8474960887");
			
			//getting full name field
			WebElement fName = driver.findElement(By.xpath("//input[@id='id_student_full_name']"));
			fName.clear();
			fName.sendKeys("Vanshika Mehrotra");
			
			//getting gender field
			WebElement gender = driver.findElement(By.xpath("//input[@id='id_student_gender']"));
			gender.clear();
			gender.sendKeys("Female");
			Thread.sleep(1000);
			
			//clicking on submit button
			WebElement submitB = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]"));
			submitB.click();
			Thread.sleep(3000);
			
			// clicking on the payNow button
			WebElement payNow = driver.findElement(By.xpath("//button[contains(text(),'Pay Now')]"));
			payNow.click();
			Thread.sleep(1000);
				
			//Click on the cashfree test wallet.
		    WebElement testWallet = driver.findElement(By.xpath("//body/div[@id='sapperpc']/main[1]/div[1]/div[3]/div[2]/div[3]/div[2]/div[1]/div[1]"));
		    testWallet.click();
		    Thread.sleep(5000);
		    
		    //Click on the success button
		    WebElement success = driver.findElement(By.xpath("//button[contains(text(),'Simulate success')]"));
		    success.click();
		    
		    // download Receipt 
		    WebElement receipt = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]"));
		    receipt.click();
			
			
			
			
					  
}
catch(Exception e) {
	System.out.print("Exception : "+e);
}
	}

}
