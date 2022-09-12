package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseClass;

public class ContactsPage extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement company;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;

	// Initializing the Page Objects:
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
		// is present on web page or not 
	}

	public String selectContactsByName(String name) {
		// a[@_name='Yogendra Burkul']
		String n = driver.findElement(By.xpath("//a[@_name='"+name+"']")).getText();
		return n;
	}

	public void createNewContact(String title, String ftName, String ltName, String comp) throws InterruptedException {
		WebElement wb = driver.findElement(By.xpath("//select[@name='title']"));

		Select select = new Select(wb);
		Thread.sleep(1000);
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();

	}

}
