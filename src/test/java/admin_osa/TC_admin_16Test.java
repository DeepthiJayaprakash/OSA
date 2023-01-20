package admin_osa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_admin_16Test {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String adminUrl = pObj.getProperty("Aurl");
		driver.get(adminUrl);
	    String adminusername= pObj.getProperty("Ausername");
	    driver.findElement(By.id("inputEmail")).sendKeys(adminusername);
	    
	    String adminpassword= pObj.getProperty("Apassword");
	    driver.findElement(By.id("inputPassword")).sendKeys(adminpassword);
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.xpath("//a[.='User Login Log ']")).click();
	    
	      FileInputStream fi=new FileInputStream("./src/test/resources/Testdata45.xlsx");
	      Workbook wb=WorkbookFactory.create(fi);
	           Sheet sheet = wb.getSheet("Sheet2");
	           
	           String expectedUserName = sheet.getRow(1).getCell(0).getStringCellValue();
	           driver.findElement(By.xpath("//input[@type='text']")).sendKeys(expectedUserName);
	           
	           String actualUserName = driver.findElement(By.xpath("//tbody[@role='alert']//td[text()='"+expectedUserName+"']")).getText();
	           if (expectedUserName.equals(actualUserName)) {
				System.out.println(expectedUserName+" is successfully Added");
			} else {
				System.out.println(expectedUserName+" is not Added");
			}
	    	}

}
