package com.freecrm.companiesPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.genriclib.basetest;

public class newCompanyPage extends basetest {

	public newCompanyPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Create new Company']") WebElement CreatenewCompany;
	@FindBy(name="name") WebElement nameTxtBx;
	@FindBy(xpath="//input[ @name='url' and contains(@type,'text')]") WebElement websiteTxtBx;
	@FindBy(name="city") WebElement cityTxtBx;
	@FindBy(xpath="//input[@placeholder='Number']") WebElement phoneNumberTxtBx;
	@FindBy(xpath="(//input[@autocomplete='new-password'])[3]") WebElement industryTxtBx;
	@FindBy(xpath="//input[@autocomplete='new-password' and @name='num_employees']") WebElement numberOfEmployeeTxtBx;
	@FindBy(xpath="//button[@class='ui linkedin button']") WebElement saveBtn;
	
	public WebElement CreatenewCompanyText()
	{
		return CreatenewCompany;
	}
	
	public void nameTextBox(String name)
	{
		nameTxtBx.sendKeys(name);
	}
	
	public void websiteTextBox(String website)
	{
		websiteTxtBx.sendKeys(website);
	}

	public void cityTextBox(String city)
	{
		cityTxtBx.sendKeys(city);
	}

	public void phoneNumberTextBox(String phoneNumber)
	{
		phoneNumberTxtBx.sendKeys(phoneNumber);
	}

	public void insdustryTextBox(String industry)
	{
		industryTxtBx.sendKeys(industry);
	}

	public void numbeOfEmployeeTextBox(String numberOfEmployee)
	{
		numberOfEmployeeTxtBx.sendKeys(numberOfEmployee);
	}

	public void saveButton()
	{
		saveBtn.click();
	}
}
