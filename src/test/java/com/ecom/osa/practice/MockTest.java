package com.ecom.osa.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom.osa.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockTest {

	public static void main(String[] args) {
		
		WebDriverUtility wlib=new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		
		driver.get("https://olympics.com/");
		
		List<WebElement> atheleteNames = driver.findElements(By.xpath("//h2[text()='athletes']/../../..//a[@class='featured-athlete__name d-flex text-body']"));
		
		for (WebElement ele : atheleteNames) {
			System.out.println(ele.getText());
		}
		driver.quit();
	}

}
