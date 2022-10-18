/*
 * @author Naveen Khunteta
 * 
 */

package com.crm.qa.testcases;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends BaseClass{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	   

	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		homePage.clickOnContactsLink();
	String name = contactsPage.selectContactsByName("Tom Peter");   //test2 ---example
		Assert.assertEquals(name, "Tom Peter");
		
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		homePage.clickOnContactsLink();
	String name =	contactsPage.selectContactsByName("Tom Peter");
		Assert.assertEquals(name, "Tom Peter");
		contactsPage.selectContactsByName("Yogendra Burkul");
	//	Assert.assertEquals(name, "Yogendra Burkul");
		
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		
		return data;
		
	}
	
	/*
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException{
		
		Thread.sleep(2000);
		
		homePage.clickOnNewContactLink();
		
	//	contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
		Thread.sleep(2000);
	}
	
	*/

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
