package com.ecom.osa.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage
{
	@FindBy(xpath = "//input[@value='COD']")
	private WebElement cODOption;

	@FindBy(xpath = "//input[@value='Internet Banking']")
	private WebElement internetBankingOption;

	@FindBy(xpath = "//input[@value='Debit / Credit card']")
	private WebElement cardOption;

	@FindBy(xpath = "//input[@value='submit']")
	private WebElement submitButton;

	public PaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getcODOption() {
		return cODOption;
	}

	public WebElement getInternetBankingOption() {
		return internetBankingOption;
	}

	public WebElement getCardOption() {
		return cardOption;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

}

