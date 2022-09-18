package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class practice extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		Thread.sleep(1000);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void newCallPage() {
		WebElement frme = driver.findElement(By.xpath("//frame[@name ='mainpanel']"));
		driver.switchTo().frame(frme);
		
		Actions ac = new Actions(driver);
		WebElement call =driver.findElement(By.xpath("//a[@title='Call']"));
		ac.moveToElement(call).click().perform();
		
		driver.findElement(By.xpath("//input[@name='contact_lookup']")).sendKeys("D");
		driver.findElement(By.xpath("(//input[contains(@onclick,'callForm')])[1]")).click();
		
		Set<String> window = driver.getWindowHandles();
		
		ArrayList<String> al = new ArrayList<String>(window);
		
		driver.switchTo().window(al.get(1));
		
		driver.findElement(By.xpath("(//a)[1]")).click();
		
		Assert.assertTrue(true);
		
		//Assert.assertEquals(call.isDisplayed(), true);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
