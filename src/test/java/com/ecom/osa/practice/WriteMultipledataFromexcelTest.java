package com.ecom.osa.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteMultipledataFromexcelTest {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		
		  List<WebElement> links = driver.findElements(By.xpath("//a"));
		  
		  FileInputStream fis = new FileInputStream("./src/test/resources/Testdata45.xlsx");
		       Workbook wb = WorkbookFactory.create(fis);
		       Sheet sheet = wb.getSheet("Sheet2");
		       for(int i=0;i<links.size();i++)
		       {
		    	   String linkvalue = links.get(i).getAttribute("href");
		    	   sheet.createRow(i).createCell(0).setCellValue(linkvalue);
		       }
				  
       FileOutputStream fout = new FileOutputStream("./src/test/resources/Testdata45.xlsx");
       wb.write(fout);
       
	}

}
