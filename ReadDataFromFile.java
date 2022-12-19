package selenium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s,user = null,pass=null;
		File file = new File("C:\\Users\\User.DESKTOP-OEK3V4C\\Documents\\abc.txt");
		FileReader r = new FileReader(file);
		BufferedReader reader = new BufferedReader(r);
		System.out.println("111111111111");

		for(int i=0;reader.readLine()!=null;i++) {
			System.out.println("2222222222222");

			s=reader.readLine();
			System.out.println("3333333333333333"+s);

			String[] login = s.split("[,]",i);
			System.out.println("4444444444");

			 for(int j=0;j<login.length-1;j++) {
					System.out.println("555555555555");

				 user = login[j];
					System.out.println("666666666666");

				 pass = login[j+1];
					System.out.println("77777777777777");

			 }
		}
		System.out.println("88888888888");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  //Launch chrome
		driver.get("https://s8bk.unicloud9.co.in/");
		
		driver.findElement(By.xpath("//input[@id='id_email_id']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@id='loginFormSubmitBtn']")).click();
		
	}

}
