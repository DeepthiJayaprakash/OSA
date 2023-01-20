package com.ecom.osa.objectpage;


import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.osa.genericUtility.FileUtility;
import com.ecom.osa.genericUtility.JavaUtility;

public class UserLoginPage {

	//declaration
	@FindBy(id="exampleInputEmail1")
	private WebElement userusername;

	@FindBy(id="exampleInputPassword1")
	private WebElement userpassword;

	@FindBy(xpath="//button[text()='Login']")
	private WebElement UserLoginButton;
	//create account 
	@FindBy(id="fullname")
	private WebElement fullnameTextfield;

	@FindBy(id="email")
	private WebElement emailtextfield;
	@FindBy(id="contactno")
	private WebElement contactno;

	@FindBy(id="password")
	private WebElement useraccntpswrd;

	@FindBy(id="confirmpassword")
	private WebElement confrmpasswrd;

	@FindBy(name = "submit")
	private WebElement submitButton;
	
	
	//initialization

	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserusername() {
		return userusername;
	}

	public WebElement getUserpassword() {
		return userpassword;
	}

	public WebElement getUserLoginButton() {
		return UserLoginButton;
	}

	public WebElement getFullnameTextfield() {
		return fullnameTextfield;
	}

	public WebElement getEmailtextfield() {
		return emailtextfield;
	}

	public WebElement getContactno() {
		return contactno;
	}

	public WebElement getUseraccntpswrd() {
		return useraccntpswrd;
	}

	public WebElement getConfrmpasswrd() {
		return confrmpasswrd;
	}

	
	public WebElement getSubmitButton() {
		return submitButton;
		}

	//business library
	public void loginAsUser(String userUsername,String userPassword) throws Throwable
	{
		Thread.sleep(2000);
		getUserusername().sendKeys(userUsername);
	Thread.sleep(2000);
	getUserpassword().sendKeys(userPassword);
	Thread.sleep(2000);
	getUserLoginButton().click();
	}

	public HashMap<String, String> createUser(WebDriver driver, HashMap<String, String> newuser, int rand)
	{
	HashMap<String, String> credentials = new HashMap<String, String>();

	for (Entry<String, String> e:newuser.entrySet())
	{
	String key = e.getKey();
	String value = e.getValue();

	if(key.equals("password"))
	{
	credentials.put("Password", value+rand);
	driver.findElement(By.xpath("(//input[@name='"+key+"'])[2]")).sendKeys(value+rand);
	}
	else
	{
	if(key.equals("emailid"))
	{
	credentials.put("Username", value+rand+"@gmail.com");
	driver.findElement(By.name(key)).sendKeys(value+rand+"@gmail.com");

	}
	else
	{
	driver.findElement(By.name(key)).sendKeys(value+rand);
	}
	}
	}
	getSubmitButton().click();
	return credentials;
	}




	} 