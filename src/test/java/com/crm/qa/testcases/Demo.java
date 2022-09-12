package com.crm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Demo {



	    @BeforeSuite
	    public void before_suite()
	    {
	        System.out.println("I am in BeforeSuite");
	    }

	    @BeforeClass
	    public void before_class()
	    {
	        System.out.println("I am in BeforeClass");
	    }

	    @BeforeMethod
	    public void before_method()
	    {
	        System.out.println("I am in BeforeMethod");
	    }

	    @BeforeTest
	    public void before_test()
	    {
	        System.out.println("I am in BeforeTest");
	    }

	    @Test
	    public void test1()
	    {
	        System.out.println("I am in Test1");
	    }
	    
	    @Test
	    public void test2()
	    {
	        System.out.println("I am in Test2");
	    }
	    
	    @AfterTest
	    public void after_test()
	    {
	        System.out.println("I am in AfterTest");
	    }

	    @AfterMethod
	    public void after_method()
	    {
	        System.out.println("I am in AfterMethod");
	    }
	    
	    @AfterClass
	    public void after_class()
	    {
	        System.out.println("I am in AfterClass");
	    }

	    @AfterSuite
	    public void after_suite()
	    {
	        System.out.println("I am in AfterSuite");
	    }


}
/*
 @BeforeSuite
@BeforeClass
@BeforeMethod
@BeforeTest
@Test
@AfterTest
@AfterMethod
@AfterClass
@AfterSuite

I am in BeforeSuite
I am in BeforeTest
I am in BeforeClass
I am in BeforeMethod
I am in Test
I am in AfterMethod
I am in AfterClass
I am in AfterTest

I am in AfterSuite
 */
