package com.crm.qa.TestngListenClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;

@Listeners(CustomListener.class)
public class ScreenshotConcept extends BaseClass{

	@BeforeMethod
	public void setUp()	{
		initialization();
	}
	
	
	
	@Test
	public void takeScreenshotTest() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(false, true);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
	}

}

