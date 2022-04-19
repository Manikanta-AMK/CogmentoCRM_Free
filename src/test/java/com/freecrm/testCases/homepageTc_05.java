package com.freecrm.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.freecrm.calander.calanderPage;
import com.freecrm.calls.callsPage;
import com.freecrm.cases.casesPage;
import com.freecrm.companiesPage.companiesPage;
import com.freecrm.contactsPage.contactPage;
import com.freecrm.dealsPage.dealsPage;
import com.freecrm.documents.documentsPage;
import com.freecrm.genriclib.basetest;
import com.freecrm.homePage.homePage;
import com.freecrm.tasks.tasksPage;

public class homepageTc_05 extends basetest {

	basetest bt;
	loginTestCase_02 ltc;
	homePage hp;
	
	@BeforeMethod
	public void initalization() throws Throwable
	{
	    bt = new basetest();
	    bt.openbrowser();
	    ltc = new loginTestCase_02();
	    ltc.logintest();
	    
	}
	
	@Test(priority=1)
	public void verifyPageTitle()
	{
		Assert.assertEquals(driver.getTitle(), "Cogmento CRM", "title is not matching");
	}
	
	@Test(priority=2)
	public void usernameVerification()
	{
	   WebElement username = driver.findElement(By.xpath("//span[@class='user-display']"));
	   Assert.assertEquals(username.getText(), "Manikanta A", "username is not matched");
	}

	@Test(priority=3)
	public void logoVerification()
	{
		hp = new homePage();
		hp.verifyLogo();
	}
	
	@Test(priority=4)
	public void homePageTest()
	{
		hp = new homePage();
		hp.calander();
		hp.contacts();
		hp.companies();
		hp.deals();
		hp.tasks();
		hp.cases();
		hp.calls();
		hp.documents();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		bt.closebrowser();
	}
}
