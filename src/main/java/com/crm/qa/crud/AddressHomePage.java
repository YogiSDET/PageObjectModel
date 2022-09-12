package com.crm.qa.crud;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class AddressHomePage extends BaseClass{

	@FindBy(xpath = "//a[contains(text(),'Addresses')]")
	private WebElement addressBtn;

	@FindBy(linkText = "New Address")
	private WebElement newAddressLink;
	
	public AddressHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddressBtn() {
		addressBtn.click();
	}
	
	public void clickAddresLink() {
		newAddressLink.click();
	}
}
