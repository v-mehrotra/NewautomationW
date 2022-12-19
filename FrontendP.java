package selenium;

import java.io.FileReader;
import java.io.Reader;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class FrontendP {
			
	public static void main(String[] args) {
		try {
			
			// Online payment Using SIS
			System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			// Open collexo frontend
		    driver.get("https://s2.collexo.co.in/pay-fee/");
		   
		    // Click on the login button
//		    WebElement loginB = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[2]/a[1]"));
//		    clickOn(driver,loginB,10);
//		    Thread.sleep(1000);
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
		    
		    // proceed for fee listing page
		    WebElement proceed = driver.findElement(By.xpath("//button[@id='payfeeproceed']"));
		    clickOn(driver,proceed,20);
		    
		    //Enter student enrollment number
		    WebElement enrol = driver.findElement(By.xpath(" //input[@id='field_application_no']"));
		    sendKeys(driver, enrol, 10,"enrol111");
		    
		    // Click on getDetails button for SIS
		    WebElement getDetails = driver.findElement(By.xpath("//button[contains(text(),'Get Details')]"));
		    clickOn(driver,getDetails,20);
		    Thread.sleep(3000);
		    
		    //Submit details of the student
		    WebElement savenSubmit = driver.findElement(By.xpath("//button[@id='stu_sub_btn']"));
		    clickOn(driver,savenSubmit,5);
		    
		    Thread.sleep(5000);
		    
		    // click on the fee pay now button on the fee listing page
		    WebElement payB = driver.findElement(By.xpath("//button[@id='pay-now-dis_1704']"));
		    payB.click();
		    Thread.sleep(5000);
		    
		    //Apply discount randomly from excel
		    WebElement discount = driver.findElement(By.xpath("//span[contains(text(),'Apply Coupon')]"));
		    discount.click();
		    Thread.sleep(5000);
		    FileInputStream fis = new FileInputStream("C:/Users/User.DESKTOP-OEK3V4C/Downloads/discounts.xlsx/");
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet("coupon");
	        XSSFRow row = sheet.getRow(0);
	        
	        String a[] = new String[20];
	        for(int i=0;i<20;i++) {
	        	row = sheet.getRow(i+1);
	        	XSSFCell cell=row.getCell(0); //getting the cell representing the given column  
	        	String value=cell.getStringCellValue();    //getting cell value  
	        	a[i]=value;
	        }
	  
		   
	        Random rand = new Random();
			String code=a[rand.nextInt(a.length)];
			System.out.print(a.length);
		    
	      	WebElement codeIn = driver.findElement(By.xpath("//input[@id='coupon_code']"));
      	    sendKeys(driver,codeIn,10,code);
	      	 Thread.sleep(5000);
	      	 WebElement applyC = driver.findElement(By.xpath("//body/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]"));
			 applyC.click();
			 Thread.sleep(7000);
	      
		    // Click on the paynow button of checkout page
		    WebElement payNow = driver.findElement(By.xpath("//button[contains(text(),'Pay Now')]"));
		    payNow.click();
		    Thread.sleep(5000);
		    
		    //Click on the cashfree test wallet.
		    WebElement testWallet = driver.findElement(By.xpath("//body/div[@id='sapperpc']/main[1]/div[1]/div[3]/div[2]/div[3]/div[2]/div[1]/div[1]"));
		    testWallet.click();
		    Thread.sleep(5000);
		    
		    //Click on the success button
		    WebElement success = driver.findElement(By.xpath("//button[contains(text(),'Simulate success')]"));
		    success.click();
		    
		    // download Reciept
		    WebElement receipt = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]"));
		    receipt.click();
		    }
		catch(Exception e) {
			System.out.println("Exception "+e);
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


