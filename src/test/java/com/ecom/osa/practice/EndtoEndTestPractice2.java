package com.ecom.osa.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class EndtoEndTestPractice2 {

	public static void main(String[] args) throws Throwable {
		//System.setProperty("webdriver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		String username = "rmgyantra";
		driver.findElement(By.id("usernmae")).sendKeys(username);
		String password = "rmgy@9999";
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//nav[@id='sidebar']//a[text()='Projects']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("onlineshoppingapplication");
		
        driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Anup");
        WebElement prjctstats = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
        Select select=new Select(prjctstats);
        select.selectByVisibleText("On Gogin");
        driver.findElement(By.xpath("//input[@value='Add Project']")).submit();
        
        
        
        Connection con = null;
		try {
		Driver driver2=new Driver();
		//Step1:register the database
		DriverManager.registerDriver(driver2);
		
		//Step2:Get connection for the database
		con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		//step3: issue create statement
		 Statement state = con.createStatement();
		 String query = "select * from project where created_on like '%12/22';";
		
		//Step4:Execute query
		 ResultSet result = state.executeQuery(query);
		 
		 while(result.next())
		 {
			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		 }
		}
		catch(Exception e)
		{
			
		}
        
	}

}
