package com.ecom.osa.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.osa.genericUtility.FileUtility;

public class AdminLoginPage {
	//decalaration
	@FindBy(id="inputEmail")
	private WebElement adminusername;
	
	@FindBy(id="inputPassword")
	private WebElement adminpasswrd;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement LoginButton;

	//initialization 
	public AdminLoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
		public WebElement getAdminusername() {
			return adminusername;
		}

		public WebElement getAdminpasswrd() {
			return adminpasswrd;
		}

		public WebElement getLoginButton() {
			return LoginButton;
		}
		
		//business library
		
		public void adminlogin(String userUsername,String userPassword) 
		{
			
			adminusername.sendKeys(userUsername);
			
			adminpasswrd.sendKeys(userPassword);
			
			LoginButton.click();
		}
		
}
