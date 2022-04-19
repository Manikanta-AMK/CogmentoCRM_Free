package com.freecrm.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.commonlib.reUsableMethods;
import com.freecrm.contactsPage.newContactPage;
import com.freecrm.genriclib.basetest;
import com.freecrm.genriclib.xlutils;

public class newContactPage_TC_04 extends basetest {

    basetest bt;
    loginTestCase_02 ltc;
    newContactPage ncp;
    contactsPage_TestCase_03 cptc;
    reUsableMethods rum;
    
    
	@BeforeMethod
	public void initialization() throws InterruptedException
	{
		bt = new basetest();
	 	bt.openbrowser();
	 	ltc = new loginTestCase_02();
	 	ltc.logintest();
	 	cptc = new contactsPage_TestCase_03();
		cptc.contacts();
	}
	
	@Test(dataProvider = "newContactData")
	public void createNewContact(String fistname, String lastname, String middlename, String company, String email, String number) throws Throwable
	{
		
		ncp = new newContactPage();
		ncp.firstNameTextBox(fistname);
		ncp.lastNameTextBox(lastname);
		ncp.middleNameTextBox(middlename);
		ncp.companyNameTextBox(company);
//		ncp.privateButton();
//		reUsableMethods rum = new reUsableMethods();
//		ncp.accessTextBox();
//		rum.robotclassEnter();
//		ncp.nameDelete();
//		ncp.privateButton();
		ncp.emailTextBox(email);
		ncp.addEmail();
		ncp.removeMail();
//		ncp.countryName();
		ncp.contactNumber(number);
//		ncp.categoryDD();
//		WebElement dd = driver.findElement(By.xpath("//div[@class='visible menu transition']//descendant :: span[text()='Customer']"));
//		rum.staticDropDownVisibleTxt(dd, "Customer");
//		ncp.selectDD();
//		WebElement sdd = driver.findElement(By.xpath("//div[@class='visible menu transition']//descendant::span[text()='Active']"));
//		rum.staticDropDownVisibleTxt(sdd, "Active");
		
		ncp.saveButton();
		Assert.assertTrue(ncp.newContactIcon(), "icon is displayed");
		
		
	}
	
	@DataProvider(name="newContactData")
	public Object[][] getData() throws Throwable  
	{
		int rc = xlutils.getrowcount(excelPath, "new contact");
		int cc = xlutils.getcellcount(excelPath, "new contact", 1);
		
		Object newContactData[][] = new Object[rc][cc];
		for(int i=1;i<=rc;i++)
			{
				for(int j=0;j<cc;j++)
				{
					newContactData[i-1][j] = xlutils.getDataFromExcel(excelPath, "new contact", i, j);
				}
			}
		return newContactData;
		

	}
	
	@AfterMethod
	public void teardown()
	{
		bt.closebrowser();
	}
	
}
