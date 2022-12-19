package selenium;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlinePayment {
	WebDriver driver = new ChromeDriver();
	
	//Method for discount
	public void applyDiscount() throws InterruptedException {
		try {
		//Apply discount
	    WebElement discount = driver.findElement(By.xpath("//span[contains(text(),'Apply Coupon')]"));
	    discount.click();
	    Thread.sleep(5000);
	    
	    //randomly pick discount code from Excel file.
	    
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
      	//String[] bulkC = {"Luck568EPL", "LuckQ1A1BR", "LuckCZU0NN", "LuckCZU0YC", "LuckM7A925"}; // array of discount codes
      	String code=a[rand.nextInt(a.length)];
	    
      	WebElement codeIn = driver.findElement(By.xpath("//input[@id='coupon_code']"));
      	sendKeys(driver,codeIn,10,code);
      	Thread.sleep(5000);
      	
      	 WebElement applyC = driver.findElement(By.xpath("//body/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]"));
		 applyC.click();
		 Thread.sleep(11000);
		}
		catch(Exception ee) {
			System.out.print("Discount exception "+ee);
		}
	}
	public void frontendP() throws InterruptedException {
		// Online payment Using SIS partial
				System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
				
				driver.manage().window().maximize();
				// Open collexo frontend
			    driver.get("https://s2.collexo.co.in/pay-fee/");
			   
//			    // Click on the login button
//			    WebElement loginB = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[2]/a[1]"));
//			    clickOn(driver,loginB,10);
			    
			    // Enter mobile number
			    WebElement mobile = driver.findElement(By.xpath("//input[@id='id_mobile_no']"));
			    sendKeys(driver,mobile,10,"8474960887");
			    
			    // Submit mobile number
			    WebElement submitB = driver.findElement(By.xpath("//button[@id='send_otp_button']"));
			    clickOn(driver,submitB,10);
			    
			    // Enter OTP
			    Thread.sleep(25000);
//			    WebElement continueB = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
//			    clickOn(driver,continueB,20);
	}
	public void selectSchool() throws InterruptedException {
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
			    sendKeys(driver, enrol, 10,"11222235011");
			    
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
			    
			    // partial payment 
			    try {
			    		    WebElement inp = driver.findElement(By.xpath("//input[@id='onlineAmtPay']"));
			    		    	 String val = inp.getAttribute("value");
			    		 	    float feeAmt = Float.parseFloat(val);
			    		 	    int fee = (int)feeAmt;
			    		 	    int len = val.length();
			    		 	    Random rnd = new Random();
			    		 	    int number = rnd.nextInt(fee-100)+100;
			    		 	    inp.clear();
			    		 	    sendKeys(driver,inp, 10,Integer.toString(number));
			    		         System.out.print("successful");
			    		 	    Thread.sleep(3000);
			    		 	    
			    		 	    WebElement updateB = driver.findElement(By.xpath("//button[@id='onlineAmtBtn']"));
			    		 	    updateB.click(); 
			    }
			    catch(Exception ee) {
			    	System.out.println(ee);
			    }
			   Thread.sleep(1000);
			   
			   applyDiscount();
			   
			     //Click on the paynow button of checkout page
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
			    
			    // download Receipt 
			    WebElement receipt = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]"));
			    receipt.click();
			    Thread.sleep(5000);
			    
			    // go to the transaction summary
			    WebElement t_Summary = driver.findElement(By.xpath("//a[contains(text(),'Go to Transaction Summary')]"));
			    t_Summary.click();
			    
			 // go to the pay fee
			    WebElement payFee = driver.findElement(By.xpath("//a[contains(text(),'Pay Fee')]"));
			    payFee.click();
	}
	
	//Main method........
public static void main(String[] args) {
	try {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		OnlinePayment p = new OnlinePayment();
		p.frontendP();
		p.selectSchool();
		p.selectSchool();

	    }
	catch(Exception e) {
		System.out.println("Exception "+e);
	}
}

// Method for click action
public static void clickOn(WebDriver driver,WebElement element,int timeout) {
	new WebDriverWait(driver,Duration.ofSeconds(timeout)).
	until(ExpectedConditions.elementToBeClickable(element));
	element.click();
} 

// Method for passing the value in the input fields.
public static void sendKeys(WebDriver driver,WebElement element,int timeout,String value) {
	new WebDriverWait(driver, Duration.ofSeconds(timeout)).
	until(ExpectedConditions.visibilityOf(element));
	element.sendKeys(value);
}
}



