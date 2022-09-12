package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	
//	public LoginPageTest(){
//		super();
//	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}

	
	
	//jenkins practice time created this method to test or check how to send using pom in jenkin     
	@Parameters("Browser")     //this parameter will be taken from testing.xml --- but we are running with maven cmd -mvn clean test -DBrowser=chrome
	@Test(priority=1)
	public void loginPageVerify(String BrowserName) {
		System.out.println("parameter value :"+BrowserName);    //pratice sending parameter using pom file through jenkins ---
		if(BrowserName.contains("chrome")) {
			System.out.println("chrome running ");
		}
		else {
			System.out.println("firfox running ");
		}
		
	}
	
	
	
	
	
	@Test(priority=2)
	public void loginPageTitleTest(){			
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	} 
	
	@Test(priority=3)
	public void crmLogoImageTest() throws InterruptedException{
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
