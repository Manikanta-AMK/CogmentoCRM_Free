package com.freecrm.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.commonlib.reUsableMethods;
import com.freecrm.companiesPage.companiesPage;
import com.freecrm.companiesPage.newCompanyPage;
import com.freecrm.genriclib.basetest;
import com.freecrm.genriclib.xlutils;
import com.freecrm.homePage.homePage;

public class newCompanyTC_07 extends basetest{

	basetest bt;
	loginTestCase_02 lt;
	homePage hp;
	CompaniesPage_TC_06 cptc;
	newCompanyPage ncp;
	
	@BeforeMethod
	public void initalization() throws Throwable
	{
		bt = new basetest();
		bt.openbrowser();
		lt = new loginTestCase_02();
		lt.logintest();
		hp = new homePage();
		hp.companies();
		cptc = new CompaniesPage_TC_06();
		cptc.pageNameVerification();
		cptc.newCreateCompaniesButton();
		
	}
	
	@Test(priority=1)
	public void textVerification()
	{
		reUsableMethods.elementStatus(1, ncp.CreatenewCompanyText(), "elementName");
	}
	
	@Test(priority =2, dataProvider = "newCompaniesDetails")
	public void newCompanies(String name, String website, String city, String phonenumber, String industry, String employeenumber)
	{
		ncp.nameTextBox(name);
		ncp.websiteTextBox(website);
		ncp.cityTextBox(city);
		ncp.phoneNumberTextBox(phonenumber);
		ncp.insdustryTextBox(industry);
		ncp.numbeOfEmployeeTextBox(employeenumber);
		ncp.saveButton();
		
	}
	
	@DataProvider(name="newCompaniesDetails")
	public Object[][] getdata() throws Throwable
	{
		int rc = xlutils.getrowcount(excelPath2, "Sheet3");
	    int cc = xlutils.getcellcount(excelPath2, "Sheet3", 1);
	    
	    Object[][] newCompaniesDetails = new Object[rc][cc];
	    
	    for(int i=1;i<=rc;i++)
	    {
	    	for(int j=0;j<cc;j++)
	    	{
	    		newCompaniesDetails[i-1][j] = xlutils.getDataFromExcel(excelPath2, "Sheet3", i, j);
	    	}
	    }
		return newCompaniesDetails;
	}
	
	@AfterMethod
	public void teardown()
	{
		bt.closebrowser();
	}
	
}
