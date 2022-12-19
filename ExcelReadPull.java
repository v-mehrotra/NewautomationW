package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelReadPull {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		 FileInputStream fis = new FileInputStream("C:/Users/User.DESKTOP-OEK3V4C/Desktop/pull.xlsx/");
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet("pullS");
	        XSSFRow row = sheet.getRow(0);
	        
	        String a[] = new String[7];
	        for(int i=0;i<7;i++) {
	        	row = sheet.getRow(i+1);
	        	XSSFCell cell=row.getCell(0); //getting the cell representing the given column  
	        	String value=cell.getStringCellValue();    //getting cell value  
	        	System.out.println("Value of the Excel Cell is - "+ value);
	        	a[i]=value;
	        }
	 System.out.println("array");
	      for(int i=0;i<7;i++) {
	    	  System.out.println(a[i]);
	      }
	}

}
