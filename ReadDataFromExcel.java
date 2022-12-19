package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

public class ReadDataFromExcel {
	
	public static void main(String args[]) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  //Launch chrome
		
		driver.get("https://s8bk.unicloud9.co.in/");
		
		String fileName="data.xlsx";
		
		File file = new File("C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\data.xlsx");
		 FileInputStream inputStream = new FileInputStream(file);
         Workbook dataW = null;
         String fileExtensionName = fileName.substring(fileName.indexOf("."));
         
         if(fileExtensionName.equals(".xlsx")){

        	    dataW = new XSSFWorkbook(inputStream);

        	    }

        	    else if(fileExtensionName.equals(".xls")){

        	        dataW = new HSSFWorkbook(inputStream);

        	    }
         
         Sheet loginSheet = dataW.getSheet("login");
         
         int rowCount = loginSheet.getLastRowNum()-loginSheet.getFirstRowNum();
         
         for (int i = 0; i < rowCount+1; i++) {

             Row row = loginSheet.getRow(i);

             for (int j = 0; j < row.getLastCellNum(); j++) {

                 System.out.print(row.getCell(j).getStringCellValue()+"  ");
//                 driver.findElement(By.xpath("//input[@id='id_email_id']")).sendKeys(row.getCell(j).getStringCellValue());
//             	 driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys(row.getCell(j+1).getStringCellValue());
                
             }

             System.out.println();
         } 

         }  
	}


