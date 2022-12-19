package selenium;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CashPayment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {		
			// Cash payment Using SIS
			System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
		
			// Open collexo frontend
		    driver.get("https://s2.collexo.co.in/pay-fee/");
		   
		    // Click on the login button
//		    WebElement loginB = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[2]/a[1]"));
//		    clickOn(driver,loginB,10);
		    
		    // Enter mobile number
		    WebElement mobile = driver.findElement(By.xpath("//input[@id='id_mobile_no']"));
		    sendKeys(driver,mobile,10,"8474960887");
		    
		    // Submit mobile number
		    WebElement submitB = driver.findElement(By.xpath("//button[@id='send_otp_button']"));
		    clickOn(driver,submitB,20);
		    
		    // Enter OTP
		    Thread.sleep(25000);
//		    WebElement continueB = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
//		    clickOn(driver,continueB,20);

		    // select school
		    boolean staleElement = true;
		    while(staleElement) {
		    	try {
		    		WebElement schl1 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/label[2]"));
				    clickOn(driver,schl1,20);
				    WebElement searchField = driver.findElement(By.xpath("//input[@id='sc_cl_name']"));
				    searchField.sendKeys("uniapply demo");
		 		    staleElement = false;
		    	}
		    	catch(StaleElementReferenceException e){
		    		staleElement = true;
		    	}
		    }
		     // select the school from the list
		    Thread.sleep(3000);
		    List<WebElement> unilist = driver.findElements(By.xpath("//body/div[2]/div[1]/section[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/ul[1]"));
		    for(WebElement w : unilist) {
		    	w.click();
		    	break;
		    }
		    
		    // proceed for fee student details page
		    WebElement proceed = driver.findElement(By.xpath("//button[@id='payfeeproceed']"));
		    clickOn(driver,proceed,20);
		    
		    //Enter student enrollment number
		    WebElement enrol = driver.findElement(By.xpath(" //input[@id='field_application_no']"));
		    sendKeys(driver, enrol, 10,"stu22");
		    
		    // Click on getDetails button for SIS
		    WebElement getDetails = driver.findElement(By.xpath("//button[contains(text(),'Get Details')]"));
		    clickOn(driver,getDetails,20);
		    Thread.sleep(3000);
		    
		    //Submit details of the student
		    WebElement savenSubmit = driver.findElement(By.xpath("//button[@id='stu_sub_btn']"));
		    clickOn(driver,savenSubmit,5);
		    Thread.sleep(5000);
		    
		    // click on the fee pay now button on the fee listing page
		    WebElement payB = driver.findElement(By.xpath("//button[@id='pay-now-dis_1544']"));
		    payB.click();
		    Thread.sleep(5000);
		    
		    // Click on cash button
		    WebElement cashB = driver.findElement(By.xpath("//body/div[2]/div[1]/div[3]/div[1]/div[3]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/label[1]"));
		    cashB.click();
		    Thread.sleep(5000);
		    
		  //Enter cash reciept number
		    WebElement recNumber = driver.findElement(By.xpath("//body/div[2]/div[1]/div[3]/div[1]/div[3]/div[2]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"));
		    Random rnd = new Random();
		    int number = rnd.nextInt(999999);
		    sendKeys(driver,recNumber, 10, String.format("%06d", number));
		    Thread.sleep(3000);
		    
		    //Set cash Date
		    WebElement cashDate = driver.findElement(By.xpath("//input[@id='receipt_date']"));
		    cashDate.click();
		    Thread.sleep(3000);
		    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		    LocalDateTime now = LocalDateTime.now();  
		    cashDate.sendKeys(dtf.format(now));
		    Thread.sleep(3000);
		 
		    //Click on the submit cash button
		    WebElement cashSubmit = driver.findElement(By.xpath("//button[@id='cash_edit_amt_btn']"));
            cashSubmit.click();
            Thread.sleep(5000);
            
		    // download Receipt
		    WebElement receipt = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]"));
		    receipt.click();
		    
		    }
		catch(Exception e) {
			System.out.println("Exception in "+e);
		}
	}
	
	public static void clickOn(WebDriver driver,WebElement element,int timeout) {
		new WebDriverWait(driver,Duration.ofSeconds(timeout)).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	} 
	public static void sendKeys(WebDriver driver,WebElement element,int timeout,String value) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
}


