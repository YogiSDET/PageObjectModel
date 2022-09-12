package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.crud.AddAddressPage;
import com.crm.qa.crud.AddressPojo;

public class AddressTest extends BaseClass{

	
	private AddressPojo address;
	private AddAddressPage addressPage;

	@BeforeTest
	public void setUp() throws Exception {
		initialization();
		driver.findElement(By.id("session_email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("session_password")).sendKeys("Test@12345");
		driver.findElement(By.name("commit")).click();		
		addressPage = new AddAddressPage();
		
	}

	
	@Test
	public void createAddressTest() {
		address = new AddressPojo("Yogendra", "automation", "sharubai smruti", "Mumbai", "4534");
	String successMsg=	addressPage.addAddress(address); 
		Assert.assertEquals(successMsg, "Address was successfully created");
	}
	
	
	@Test
	public void updateAddressTest() {
		address = new AddressPojo("burkul", "automationlab", "sharubai smruti", "Mumbai", "4534");
		addressPage.addAddress(address); 
		address.setAddress1("manuallab");
		address.setCity("NY");

		String successMsg =addressPage.updateAddress(address, address.getFirstName());

		Assert.assertEquals(successMsg, "Address was successfully updated");
	}
	
	
	@Test
	public void deleteAddressTest() {
		address = new AddressPojo("naveenDelete", "autolabs", "newAdd", "banglore", "43434");
		addressPage.addAddress(address);
		
		String successMsg = addressPage.deleteAddress("naveenDelete");
		Assert.assertEquals(successMsg, "Address was successfully destroyed");
	}
	
	@Test
	public void getAddressTest() {
		address = new AddressPojo("naveenGet", "autolabs", "newAdd", "banglore", "43434");
		addressPage.addAddress(address);
		
		String successMsg = addressPage.getAddress("naveenGet");
		Assert.assertEquals(successMsg, address.getFirstName());
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}

/*
 * 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogen\\eclipse-dataDrivenFramework\\PageObjectModel\\Browser\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--ignore-certificate-errors");
		driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://a.testaddressbook.com/sign_in");
 */
