package com.freecrm.testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.freecrm.commonlib.reUsableMethods;
import com.freecrm.contactsPage.contactPage;
import com.freecrm.genriclib.basetest;

public class contactsPage_TestCase_03 extends basetest{

	public basetest bt;
	public loginTestCase_02 ltc;
	reUsableMethods rum = new reUsableMethods();
	
	@BeforeMethod
	public void initialization() throws InterruptedException
	{
		bt = new basetest();
		bt.openbrowser();
		ltc = new loginTestCase_02();
		ltc.logintest();
	}
	
	@Test
	public void contacts() throws InterruptedException
	{
		
		contactPage cp = new contactPage();
		WebElement conatactsbutton = cp.contactsButton();
		Thread.sleep(2000);
	    Actions action = new Actions(driver);
	    action.moveToElement(conatactsbutton).click().perform();
	    log.info("clicked on contacts button");
	    cp.conatcsLabel();	    
	    log.info("contactlabel is displayed");
//	    Assert.assertEquals(cp.contactPageTitle(),"Contacts");
	    Thread.sleep(2000);
	    cp.createBtn();
	    log.info("clicked on create button");
		
	}
	
	@AfterMethod
	public void teardown()
	{
		bt.closebrowser();
	}
	
}
