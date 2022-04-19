package com.freecrm.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.companiesPage.companiesPage;
import com.freecrm.genriclib.basetest;
import com.freecrm.homePage.homePage;

public class CompaniesPage_TC_06 extends basetest{

	basetest bt;
	loginTestCase_02 lt;
	companiesPage companiespage;
	homePage hp;

	@BeforeMethod
	public void initialization() throws Throwable
	{
        bt = new basetest();
        bt.openbrowser();
        lt = new loginTestCase_02();
        lt.logintest();
        hp = new homePage();
		hp.companies();
		companiespage = new companiesPage();
         
	}
	
	@Test(priority=1)
	public void pageNameVerification() throws Throwable
	{
		companiespage.companiesTextVisible();
	}
	
	@Test(priority=2)
	public void newCreateCompaniesButton()
	{
		companiespage.createButton();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
