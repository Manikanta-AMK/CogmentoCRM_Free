package com.freecrm.contactsPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.genriclib.basetest;

public class contactPage extends basetest {

	public contactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Contacts']") WebElement contactsBtn;
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']") WebElement contactslbl;
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']") WebElement contactTitle;
	@FindBy(xpath="(//button[@class='ui linkedin button'])[3]") WebElement createBtn;
	
	public WebElement contactsButton()
	{
		return contactsBtn;
	}
	
	public boolean conatcsLabel()
	{
		return contactslbl.isDisplayed();
	}
	
	public WebElement contactPageTitle()
	{
		return contactTitle;
	}
	
	public void createBtn()
	{
		createBtn.click();
	}
}
