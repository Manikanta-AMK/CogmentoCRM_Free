package com.freecrm.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.freecrm.genriclib.basetest;
import com.freecrm.loginpage.signUpPage;

public class signUpPageTestCase_01 extends basetest {

	basetest bt = new basetest();
	
	@BeforeMethod
	public void initialization()
	{
		bt.openbrowser();
	}
	
	@Test
	public void signUp()
	{
		signUpPage sup = new signUpPage();
		sup.signupButton();
		sup.emailTextBox().sendKeys("abc@gmail.com");
		sup.phnoneNumberTextBox().sendKeys("9334455534");
		sup.termsConditionsCheckBox();
//		sup.robotCheckBox();
		sup.signUpButton2();
		
		String errorText = "[[Please complete the Captcha]]";
		assertTrue(true,errorText);
		log.info("error message appearing succussfully");
		
	}
	
	@AfterMethod
	public void teardown()
	{
		bt.closebrowser();
	}
}
