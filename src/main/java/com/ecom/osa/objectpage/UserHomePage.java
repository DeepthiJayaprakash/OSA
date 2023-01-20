package com.ecom.osa.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
 
	public UserHomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[.='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "//a[.='Wishlist']")
	private WebElement wislist;

	@FindBy(xpath = "//a[.='My Cart']")
	private WebElement myCart;

	@FindBy(xpath = "//a[.='Login']")
	private WebElement login;

	@FindBy(xpath = "//input[@name='product']")
	private WebElement searchTextfield;

	@FindBy(xpath = "//button[@name='search']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logout;

	@FindBy(xpath = "//a[.=' ADD TO CART']")
	private WebElement addToCart;

	

	public WebElement getMyAccount() {
	return myAccount;
	}

	public WebElement getWislist() {
	return wislist;
	}

	public WebElement getMyCart() {
	return myCart;
	}

	public WebElement getLogin() {
	return login;
	}

	public WebElement getSearchTextfield() {
	return searchTextfield;
	}

	public WebElement getSearchButton() {
	return searchButton;
	}

	public WebElement getLogout() {
	return logout;
	}

	public WebElement getAddToCart() {
	return addToCart;
	}


	}
	
	

