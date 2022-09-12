package com.crm.qa.crud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseClass;

public class AddAddressPage extends BaseClass {

	private AddressHomePage ahp = new AddressHomePage();

	@FindBy(xpath = "//input[@id='address_first_name']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@id='address_last_name']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='address[address1]']")
	private WebElement address1;

	@FindBy(xpath = "//input[@id='address_city']")
	private WebElement city;

	@FindBy(xpath = "//input[@id='address_zip_code']")
	private WebElement zipCode;

	@FindBy(xpath = "//input[contains(@value,'Create Add')]")
	private WebElement createAddress;

	@FindBy(css = "div.alert.alert-notice")
	private WebElement successMsg;

//----------------------------------------------------------------------------
	@FindBy(xpath = "//span[@data-test='first_name']")
	private WebElement firstNameValue;

	// Initializing the page

	public AddAddressPage() {
		PageFactory.initElements(driver, this);
	}

	// create the address , update address, delete address

	// use concept of common code
	private String fillAddressForm(AddressPojo address) {
		firstname.clear();
		firstname.sendKeys(address.getFirstName());
		lastName.clear();
		lastName.sendKeys(address.getLastName());
		address1.clear();
		address1.sendKeys(address.getAddress1());
		city.clear();
		city.sendKeys(address.getCity());
		zipCode.clear();
		zipCode.sendKeys(address.getZipCode());
		createAddress.click();
		return successMsg.getText();
	}

	public String addAddress(AddressPojo address) {
		ahp.clickAddressBtn();
		ahp.clickAddresLink();
		return fillAddressForm(address);
	}

	public String updateAddress(AddressPojo address, String firstName) {
		ahp.clickAddressBtn();
		driver.findElement(By.xpath("//td[text()='" + firstName + "']//following-sibling::td/a[text()='Edit']"))
				.click();
		return fillAddressForm(address);
	}

	public String deleteAddress(String firstName) {
		ahp.clickAddressBtn();
		driver.findElement(By.xpath("//td[text()='" + firstName + "']//following-sibling::td/a[text()='Destroy']"))
				.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		return successMsg.getText();
	}

	public String getAddress(String firstName) {
		ahp.clickAddressBtn();
		driver.findElement(By.xpath("//td[text()='" + firstName + "']//following-sibling::td/a[text()='Show']"))
				.click();
		return firstNameValue.getText();
	}

}
