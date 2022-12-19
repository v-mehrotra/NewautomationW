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

public class PullAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {		
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
		    
		    FileInputStream fis = new FileInputStream("C:/Users/User.DESKTOP-OEK3V4C/Desktop/pull.xlsx/");
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet("pullS");
	        XSSFRow row = sheet.getRow(0);
	        
	        String pul[] = new String[7];
	        for(int i=0;i<7;i++) {
	        	row = sheet.getRow(i+1);
	        	XSSFCell cell=row.getCell(0); //getting the cell representing the given column  
	        	String value=cell.getStringCellValue();    //getting cell value  
	        	pul[i]=value;
	        }
	        
	        String rel[] = new String[7];
	        for(int i=0;i<7;i++) {
	        	row = sheet.getRow(i+1);
	        	XSSFCell cell=row.getCell(2); //getting the cell representing the given column  
	        	String value=cell.getStringCellValue();    //getting cell value  
	        	rel[i]=value;
	        }
	        
	        String adress[] = new String[7];
	        for(int i=0;i<7;i++) {
	        	row = sheet.getRow(i+1);
	        	XSSFCell cell=row.getCell(1); //getting the cell representing the given column  
	        	String value=cell.getStringCellValue();    //getting cell value  
	        	adress[i]=value;
	        }
	        
	        String stage[] = new String[7];
	        for(int i=0;i<7;i++) {
	        	row = sheet.getRow(i+1);
	        	XSSFCell cell=row.getCell(3); //getting the cell representing the given column  
	        	String value=cell.getStringCellValue();    //getting cell value  
	        	stage[i]=value;
	        }
	        
	        String backbtn[] = new String[7];
	        for(int i=0;i<7;i++) {
	        	row = sheet.getRow(i+1);
	        	XSSFCell cell=row.getCell(4); //getting the cell representing the given column  
	        	String value=cell.getStringCellValue();    //getting cell value  
	        	backbtn[i]=value;
	        }
	        
	        
	        String savebtn[] = new String[7];
	        for(int i=0;i<7;i++) {
	        	row = sheet.getRow(i+1);
	        	XSSFCell cell=row.getCell(5); //getting the cell representing the given column  
	        	String value=cell.getStringCellValue();    //getting cell value  
	        	savebtn[i]=value;
	        }
	        Thread.sleep(1000);
	        
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
		    Thread.sleep(3000);
//	        WebElement unicloud_backend = driver.findElement(By.xpath("//tbody/tr[@id='job_unicloud_backend']/td[3]/a[1]"));
//	        WebElement unicloud_dms_backend = driver.findElement(By.xpath("//tbody/tr[@id='job_unicloud_dms_backend']/td[3]/a[1]"));
//	        WebElement unicloud_ms_backend = driver.findElement(By.xpath("//tbody/tr[@id='job_unicloud_ms_backend']/td[3]/a[1]"));
//	        WebElement unicloud_unipe_dms_backend = driver.findElement(By.xpath("//tbody/tr[@id='job_unicloud_unipe_dms_backend']/td[3]/a[1]"));
//	        WebElement unicloud_unipe_dms_frontend = driver.findElement(By.xpath("//tbody/tr[@id='job_unicloud_unipe_dms_frontend']/td[3]/a[1]"));
//	        WebElement unicloud_unipe_frontend = driver.findElement(By.xpath("//tbody/tr[@id='job_unicloud_unipe_frontend']/td[3]/a[1]"));
//	        WebElement unicloud_unipe_ms_frontend = driver.findElement(By.xpath("//tbody/tr[@id='job_unicloud_unipe_ms_frontend']/td[3]/a[1]"));
	        
	       
	        for(int i=0;i<7;i++) {
	        	 WebElement common = driver.findElement(By.xpath(adress[i]));
	        	 common.click();
	 	        Thread.sleep(1000);
	 	        
	 	        WebElement configure = driver.findElement(By.xpath("//a[contains(text(),'Configure')]"));
	 		    configure.click();
	 		    
	 		    WebElement scm = driver.findElement(By.xpath("//body/div[@id='page-body']/div[@id='main-panel']/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]"));
	 		    scm.click();
	 		    
	 		    WebElement rel1 = driver.findElement(By.xpath("//body[1]/div[6]/div[1]/div[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[67]/td[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/input[1]"));
	 		    rel1.clear();
	 		    rel1.sendKeys(rel[i]);
	 		   Thread.sleep(1000);
	 		    WebElement save = driver.findElement(By.xpath(savebtn[i]));
	 		    save.click();
	 		   Thread.sleep(1000);
	 		    WebElement back = driver.findElement(By.xpath(backbtn[i]));
	 		    back.click();
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
	 		 
	 		 
	        }System.out.print("Pull Done");
	
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
