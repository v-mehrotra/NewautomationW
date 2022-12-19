package selenium;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;


public class testDrop {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\User.DESKTOP-OEK3V4C\\Downloads\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();  //Launch chrome
			driver.get("https://s8bk.unicloud9.co.in/account/manage-account/");
		
					driver.findElement(By.xpath("//input[@id='id_email_id']")).sendKeys("ritesh.shalanki@uniapply.com");
					driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("teamwork");
					driver.findElement(By.xpath("//button[@id='loginFormSubmitBtn']")).click();
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
					driver.findElement(By.className("wt-btn-back")).click();
		
					driver.findElement(By.id("menu_li_2")).click();
					driver.findElement(By.id("menu_17")).click();
					Actions actions = new Actions(driver);
					
					WebElement target = driver.findElement(By.xpath("//a[contains(text(),'Business Accounts')]"));
					actions.moveToElement(target).click().perform();
					driver.findElement(By.xpath("//button[@id='entity_create_btn']")).click();
					WebElement dropdownAT = driver.findElement(By.xpath("//div[contains(text(),'Select Account Type')]"));
					WebElement dropdownAC = driver.findElement(By.xpath("//div[contains(text(),'Select Account Category')]"));
					WebElement dropdownState = driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
					WebElement dropdownDis = driver.findElement(By.xpath("//div[contains(text(),'Select District')]"));
					WebElement dropdownCity = driver.findElement(By.xpath("//div[contains(text(),'Select City')]"));

					
						// Click on drop down
						dropdownAT.click();
						List<WebElement> itemsInDropdown = driver
								.findElements(By.cssSelector("body.pace-done.sidebar-mini.preload.modal-open:nth-child(2) div.modal.fade.right.offCanvasModal.show:nth-child(3) div.modal-dialog.modal-mlg div.modal-content div.modal-body:nth-child(3) div.row.mb-4.required:nth-child(1) div.col-12.col-md-8:nth-child(2) div.dropdown.bootstrap-select.show div.dropdown-menu.show div.inner.show > ul.dropdown-menu.inner.show>li"));
						
						for(int i = 0; i < itemsInDropdown.size(); i++) {
				            System.out.println(itemsInDropdown.get(i).getText());
				            
				        }
						int size = itemsInDropdown.size();
						System.out.println(size);
						// Generate a random number with in range
						int randnMumber = ThreadLocalRandom.current().nextInt(0,size);

						
						// Selecting random value
						itemsInDropdown.get(randnMumber).click();

						Thread.sleep(2000);
						// Getting size of options available
						
						dropdownAC.click();
						List<WebElement> category = driver
								.findElements(By.cssSelector("body.pace-done.sidebar-mini.preload.modal-open:nth-child(2) div.modal.fade.right.offCanvasModal.show:nth-child(3) div.modal-dialog.modal-mlg div.modal-content div.modal-body:nth-child(3) div.row.mb-4.required:nth-child(2) div.col-12.col-md-8:nth-child(2) div.dropdown.bootstrap-select div.dropdown-menu div.inner.show > ul.dropdown-menu.inner.show>li"));
						// Getting size of options available
						int s = category.size();
						// Generate a random number with in range
						int randnMumber1 = ThreadLocalRandom.current().nextInt(0, s);

						
						// Selecting random value
						category.get(randnMumber1).click();

						Thread.sleep(2000);        
						
						Faker faker = new Faker();
						driver.findElement(By.xpath("//input[@id='name']")).sendKeys(faker.name().fullName());
						// Click on drop down
						dropdownState.click();
						
						List<WebElement> state = driver.findElements(By.cssSelector("body.pace-done.sidebar-mini.preload.modal-open:nth-child(2) div.modal.fade.right.offCanvasModal.show:nth-child(3) div.modal-dialog.modal-mlg div.modal-content div.modal-body:nth-child(3) div.row.mb-4:nth-child(5) div.col-12.col-md-8:nth-child(2) div.dropdown.bootstrap-select.show div.dropdown-menu.show div.inner.show > ul.dropdown-menu.inner.show>li"));
						int s1 = state.size();
						int randnMumber2 = ThreadLocalRandom.current().nextInt(0, s1);

						
						// Selecting random value
						state.get(randnMumber2).click();

						Thread.sleep(2000);   
						driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
						dropdownDis.click();
						List<WebElement> Dis = driver.findElements(By.cssSelector("body.pace-done.sidebar-mini.preload.modal-open:nth-child(2) div.modal.fade.right.offCanvasModal.show:nth-child(3) div.modal-dialog.modal-mlg div.modal-content div.modal-body:nth-child(3) div.row.mb-4:nth-child(6) div.col-12.col-md-8:nth-child(2) div.dropdown.bootstrap-select.show div.dropdown-menu.show div.inner.show > ul.dropdown-menu.inner.show>li"));
						int s2 = state.size();
						int randnMumber3 = ThreadLocalRandom.current().nextInt(0, s2);

						
						// Selecting random value
						Dis.get(randnMumber3).click();

						Thread.sleep(2000); 
						driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
						dropdownCity.click();
						List<WebElement> city = driver.findElements(By.cssSelector("body.pace-done.sidebar-mini.preload.modal-open:nth-child(2) div.modal.fade.right.offCanvasModal.show:nth-child(3) div.modal-dialog.modal-mlg div.modal-content div.modal-body:nth-child(3) div.row.mb-4:nth-child(7) div.col-12.col-md-8:nth-child(2) div.dropdown.bootstrap-select.dropup.show div.dropdown-menu.show div.inner.show > ul.dropdown-menu.inner.show>li"));
						int s3 = city.size();
						int randnMumber4 = ThreadLocalRandom.current().nextInt(0, s3);

						
						// Selecting random value
					    city.get(randnMumber4).click();

						Thread.sleep(2000); 
						driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("A12 Street,Town Hall");
						driver.findElement(By.cssSelector("body.pace-done.sidebar-mini.preload.modal-open:nth-child(2) div.modal.fade.right.offCanvasModal.show:nth-child(3) div.modal-dialog.modal-mlg div.modal-content div:nth-child(2) form:nth-child(1) div.modal-footer.d-flex.justify-content-between:nth-child(4) > button.btn.btn-md.btn-purpal.entity_submit:nth-child(2)")).click();
						
						//Integration
						driver.findElement(By.xpath("//a[@id='integration-tab']")).click();
						driver.findElement(By.cssSelector("body.pace-done.sidebar-mini.preload:nth-child(2) div.position-relative:nth-child(2) div.main-wrapper.main-wrapper-1 div.main-content section.section div.section-body:nth-child(3) div.row div.col-md-10.m-auto div.tab-content div.tab-pane.fade.show.active div.row.justify-content-start div.col-md-4.col-lg-3.col-12.col-padding.mb-4.mb-md-5:nth-child(2) div.bg-white.position-relative.integrationItem.cscard div.p-4 div.d-flex.align-items-center.justify-content-between:nth-child(3) > a.btn.btn-sm.py-0.integration.btn-success.connect")).click();	
						driver.findElement(By.xpath("//input[@id='user_code']")).sendKeys("");
						
					}
						catch(Exception e) 
						{
							System.out.println("Exception is  "+e);
						}
		
		}
	
}
