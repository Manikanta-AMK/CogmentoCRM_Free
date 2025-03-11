package com.freecrm.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.freecrm.commonlib.reUsableMethods;
import com.freecrm.genriclib.basetest;
import com.freecrm.loginpage.loginPage;

public class loginTestCase_02 extends basetest {

	public loginTestCase_02()
	{
		super();
	}
	
	public basetest bt;
	public loginPage lp;

	@BeforeMethod
	public void initialization()
	{
		bt = new basetest();
		bt.openbrowser();
		lp = new loginPage();
	}
	
	@Test(priority=1)
	public void verificationOfTitle()
	{
		
		 String loginPagetitle = lp.verifyTitle();
		 Assert.assertEquals(loginPagetitle,"Cogmento CRM");
		log.info("login page title is correct");
	}
	
	@Test(priority=2)
	public void logintest() throws InterruptedException
	{
		lp = new loginPage();
		lp.emailTextBox(prop.getProperty("username"));
		log.info("user name enterd");
		lp.passwordTextBox(prop.getProperty("password"));
		log.info("password enterd");
		lp.loginButton();
		log.info("clicked on login button");

	}
	
	@AfterMethod
	public void teardown()
	{
		bt.closebrowser();
	}
}
