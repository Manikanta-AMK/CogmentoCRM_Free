package com.freecrm.testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.commonlib.reUsableMethods;
import com.freecrm.genriclib.basetest;
import com.freecrm.genriclib.xlutils;
import com.freecrm.loginpage.loginPage;

public class invalidLogin extends basetest {

	loginPage lp;
	loginTestCase_02 ltc;
	basetest bt;
	reUsableMethods rum;

	@BeforeMethod
	public void initialization() {
		bt = new basetest();
		bt.openbrowser();
	}

	@Test(dataProvider="invalidLoginData")
	public void invalidLoginTest(String username, String password) throws Throwable  {
		lp = new loginPage();
		lp.emailTextBox(username);
		lp.passwordTextBox(password);
		lp.loginButton();
		
//		WebElement errMsg =  driver.findElement(By.xpath("//div[text()='Something went wrong...']"));
		
		if(lp.verifyTitle().equals(lp.verifyErrorMessage()))
		{
			Assert.assertTrue(true, "login is not happening");
			reUsableMethods.screenShots();
		}
	}

	@DataProvider(name="invalidLoginData")
	public String[][] getdata() throws Throwable {
		String path = "C:\\Users\\10693635\\eclipse-workspace\\project\\src\\test\\resources\\excelSheet\\testData.xlsx";
		int rc = xlutils.getrowcount(path, "invalid data");
		int cc = xlutils.getcellcount(path, "invalid data", 1);

		String invaliddata[][] = new String[rc][cc];
		for (int i=1; i<=rc; i++) {
			for (int j = 0; j <cc; j++) {
				invaliddata[i-1][j] = xlutils.getDataFromExcel(path, "invalid data", i, j);
			}
		}
		return invaliddata;

	}

	@AfterMethod
	public void teardown() {
		bt.closebrowser();
	}
}
