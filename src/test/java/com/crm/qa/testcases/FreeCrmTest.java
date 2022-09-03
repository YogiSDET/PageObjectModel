package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCrmTest {

	static WebDriver driver;
	static JavascriptExecutor js;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogen\\eclipse-workspace\\PageObjectModel\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.get("https://classic.crmpro.com/index.html");
	}

	@Test
	public void freeCrmTitleTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println("title is: " + title);
		
		//title value
	//CRMPRO - CRM software for customer relationship management, sales, and support.
		
		if (title.equals("CRMPRO - CRM software for customer relationship management, sales, and support.")) {
	
			Assert.assertTrue(true);
		} else {
	
			takeScreenshot("freecrmloginpage");
			Assert.assertTrue(false);
		}

	}

		
	public static void takeScreenshot(String fileName) throws IOException{
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, 
				new File("C:\\Users\\yogen\\eclipse-workspace\\PageObjectModel\\screenshots" + fileName +".png"));

	}

}
