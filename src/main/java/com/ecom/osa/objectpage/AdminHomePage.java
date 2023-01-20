package com.ecom.osa.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	//declaration
	@FindBy(xpath="//a[contains(.,'Order Management')]")
	private WebElement Ordrmgmntlink;
	
	@FindBy(xpath="//a[contains(.,'Today')]")
	private WebElement TodaysOrderlink;
	
	@FindBy(xpath="//a[contains(.,'Pending Orders')]")
	private WebElement PendingOrderlink;
	
	@FindBy(xpath="//a[contains(.,'Delivered Orders')]")
	private WebElement DeliveredOrderlink;
	
	@FindBy(xpath="//a[contains(.,'Manage users')]")
	private WebElement ManageUserLink;
	
	@FindBy(xpath="//a[contains(.,'Create Category')]")
	private WebElement CrteCatrgylink;
	
	@FindBy(xpath="//a[contains(.,'Sub Category')]")
	private WebElement Subcatagrylink;
	
	@FindBy(xpath="//a[contains(.,'Insert Product ')]")
	private WebElement insertprdct;
	
	@FindBy(xpath="//a[contains(.,'Manage Products')]")
	private WebElement Mangprdct;
	
	@FindBy(xpath="//a[contains(.,'User Login Log ')]")
	private WebElement usrlog;
	
	@FindBy(xpath="(//a[contains(.,'Logout')])[2]")
	private WebElement logout;
	
	@FindBy(name="password")
	private WebElement crntpsswrd;
	
	@FindBy(name="newpassword")
	private WebElement newpswrd;
	
	@FindBy(name="confirmpassword")
	private WebElement cnfrmpswrd;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitbttn;

	public WebElement getOrdrmgmntlink() {
		return Ordrmgmntlink;
	}

	public WebElement TodaysOrderlink() {
		return TodaysOrderlink;
	}

	public WebElement getPendingOrderlink() {
		return PendingOrderlink;
	}

	public WebElement getDeliveredOrderlink() {
		return DeliveredOrderlink;
	}

	public WebElement getManageUserLink() {
		return ManageUserLink;
	}

	public WebElement getCrteCatrgylink() {
		return CrteCatrgylink;
	}

	public WebElement getSubcatagrylink() {
		return Subcatagrylink;
	}

	public WebElement getInsertprdct() {
		return insertprdct;
	}

	public WebElement getMangprdct() {
		return Mangprdct;
	}

	public WebElement getUsrlog() {
		return usrlog;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getCrntpsswrd() {
		return crntpsswrd;
	}

	public WebElement getNewpswrd() {
		return newpswrd;
	}

	public WebElement getCnfrmpswrd() {
		return cnfrmpswrd;
	}

	public WebElement getSubmitbttn() {
		return submitbttn;
	}
	
	public AdminHomePage(WebDriver driver)
	 {
	  PageFactory.initElements(driver, this);
	 }
	
	 public WebElement getTodaysOrderlink() {
		 getOrdrmgmntlink().click();
		  return TodaysOrderlink;
		 }
		 public WebElement getPendingOrder() {
			 getOrdrmgmntlink().click();
		  return PendingOrderlink;
		 }
		 public WebElement getDeliveredOrder() {
			 getOrdrmgmntlink().click();
		  return DeliveredOrderlink;
		 }
		 
		 public WebElement getLogoutbutton()
		 { 
			 getLogout().click();
			 return logout; 
		 }
		
		 
		}
