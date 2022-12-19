package selenium;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Erp {

	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\User.DESKTOP-OEK3V4C\\\\Downloads\\\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
		    driver.get("https://s2bk.unicloud9.co.in/unipe/manage-fees/");
		    driver.findElement(By.xpath("//input[@id='id_email_id']")).sendKeys("ritesh.shalanki@collexo.com");
			driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("teamwork");
			driver.findElement(By.xpath("//button[@id='loginFormSubmitBtn']")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(By.className("wt-btn-back")).click();
			
			Thread.sleep(1000);
			WebElement businessA = driver.findElement(By.xpath("//body/div[@id='app']/div[3]/nav[1]/div[1]/div[1]/div[1]/button[1]/span[1]"));
			businessA.click();
			Thread.sleep(1000);
			
			WebElement uniap = driver.findElement(By.xpath("//a[contains(text(),\"UniApply Demo School's, Delhi\")]"));
			uniap.click();
			Thread.sleep(1000);
			
			WebElement session = driver.findElement(By.xpath("//span[@id='sessionName']"));
			session.click();
			Thread.sleep(1000);
			
			WebElement selectS = driver.findElement(By.xpath("//a[contains(text(),'2022-2023')]"));
			selectS.click();
			Thread.sleep(3000);
			
			//open fee connect
			driver.findElement(By.id("menu_li_7")).click();
			driver.findElement(By.id("menu_6")).click();
			Actions actions = new Actions(driver);
			WebElement target = driver.findElement(By.xpath("//a[contains(text(),'Fee Connect')]"));
			actions.moveToElement(target).click().perform();
			Thread.sleep(3000);
			
			//Add fees
			driver.findElement(By.xpath("//body/div[@id='app']/div[3]/div[3]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/button[1]")).click();
			
			Thread.sleep(3000);
			
			WebElement feeT = driver.findElement(By.xpath("//input[@id='id_fee_title']"));
			feeT.sendKeys("ERP FeeA12");
			Thread.sleep(1000);
			WebElement erp = driver.findElement(By.xpath("//input[@id='workflow_required_1']"));
			erp.click();
			Thread.sleep(1000);
			WebElement sessionF = driver.findElement(By.xpath("//input[@id='id_session_id_1']"));
			sessionF.click();
			Thread.sleep(1000);
			WebElement sDate = driver.findElement(By.xpath("//div[@id='datepik_start_date']//input[@id='id_start_date']"));
			sDate.click();
			
			  Thread.sleep(3000);
			    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			    LocalDateTime now = LocalDateTime.now();  
			    sDate.sendKeys(dtf.format(now));
			    Thread.sleep(5000);
			 
			    // Select payment method
			    
			    WebElement pNow = driver.findElement(By.xpath("//div[contains(text(),'Pay Now')]"));
			    pNow.click();
			    Thread.sleep(1000);
			    
			    //Select payment gateway
			    WebElement pg = driver.findElement(By.xpath("//body/div[@id='createModal']/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[8]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/div[1]/div[1]/div[1]"));
	             pg.click();
	             Thread.sleep(1000);
	             
	             WebElement selectPg = driver.findElement(By.xpath("//a[@id='bs-select-7-1']"));
	             selectPg.click();
	             Thread.sleep(500);
	             
	             // Select DD PM
	             WebElement DDPM = driver.findElement(By.xpath("//div[contains(text(),'DD')]"));
	             DDPM.click();
	             Thread.sleep(500);
	             
	             //Select Cash PM
	             WebElement cashPM = driver.findElement(By.xpath("//div[contains(text(),'Cash')]"));
	             cashPM.click();
	             Thread.sleep(1500);
	             
	             //Fee enable
	             WebElement status = driver.findElement(By.xpath("//body/div[@id='createModal']/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[9]/div[2]/label[1]/span[1]"));
	             JavascriptExecutor jse = (JavascriptExecutor)driver;
	     		jse.executeScript("arguments[0].click()",status);
	             
	             //Fee submit button
	             WebElement feeS = driver.findElement(By.xpath("//button[@id='fee_configuration_form_submit']"));
	             feeS.click();
	           System.out.print("ERP Fees has been created successfully");
	           
	           Thread.sleep(1000);
	           //integration
	           
	          //WebElement settingB = driver.findElement(By.id("//body/div[@id='app']/div[3]/nav[1]/ul[1]/li[2]/a[1]"));
	             
		}catch(Exception e) {
			System.out.print("Exception is "+e);
		}
	}

}
