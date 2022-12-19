package selenium;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.netty.resolver.AddressResolver;

public class requirementTxt {

	public static void main(String[] args) {
		
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			FileInputStream fis = new FileInputStream("C:/Users/User.DESKTOP-OEK3V4C/Desktop/pull.xlsx/");
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet("pullS");
	        XSSFRow row = sheet.getRow(0);
	        
			 String adressR[] = new String[7];
		        for(int i=0;i<7;i++) {
		        	row = sheet.getRow(i+1);
		        	XSSFCell cell=row.getCell(7); //getting the cell representing the given column  
		        	String value=cell.getStringCellValue();    //getting cell value  
		        	adressR[i]=value;
		        }
		        
		        String stage[] = new String[7];
		        for(int i=0;i<7;i++) {
		        	row = sheet.getRow(i+1);
		        	XSSFCell cell=row.getCell(3); //getting the cell representing the given column  
		        	String value=cell.getStringCellValue();    //getting cell value  
		        	stage[i]=value;
		        }
			// Open jenkins
		    driver.get("http://jenkins.uniapply.co.in:8080/");
		    WebElement username = driver.findElement(By.xpath("//input[@id='j_username']"));
		    username.sendKeys("Bhawna");
		    Thread.sleep(1000);
		    
		    WebElement password = driver.findElement(By.xpath("//body/div[1]/div[1]/form[1]/div[2]/input[1]"));
		    password.sendKeys("IObXZ8xlVpfXf");
		    Thread.sleep(1000);
		    
		    WebElement login = driver.findElement(By.xpath("//body/div[1]/div[1]/form[1]/div[3]/input[1]"));
		    login.click();
		    Thread.sleep(1000);
		    
		    for(int i=0;i<7;i++) {
		    	WebElement req1 = driver.findElement(By.xpath(adressR[i]));
		    	req1.click();
		    	Thread.sleep(1000);
		    	
		    	 WebElement bwp = driver.findElement(By.xpath("//a[contains(text(),'Build with Parameters')]"));
		 		    bwp.click();
		 		   Thread.sleep(1000);
		 		    WebElement stg = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/select[1]"));
		 		    stg.sendKeys(stage[i]);
		 		     Thread.sleep(1000);
		 		    
		 		    WebElement build1 = driver.findElement(By.xpath("//button[@id='yui-gen1-button']"));
		 		    build1.click();
		 		    Thread.sleep(1000);
		 		    
		 		   WebElement dash = driver.findElement(By.xpath("//a[contains(text(),'Back to Dashboard')]"));
		 		   dash.click();
		    }
		    System.out.print("All the requirement.txt file has been done");
			
		}
		catch(Exception e) {
			
		}
	}

}
