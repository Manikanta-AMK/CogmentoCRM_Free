package com.freecrm.companiesPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.genriclib.basetest;

public class companiesPage extends basetest {

	public companiesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Companies']") WebElement companiestext;
	@FindBy(xpath="(//button[@class='ui linkedin button'])[3]") WebElement createBtn;
	
	public boolean companiesTextVisible()
	{
		return companiestext.isDisplayed();
	}

	public void createButton()
	{
		createBtn.click();
	}

}


