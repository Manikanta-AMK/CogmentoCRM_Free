package com.freecrm.homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.calander.calanderPage;
import com.freecrm.calls.callsPage;
import com.freecrm.cases.casesPage;
import com.freecrm.companiesPage.companiesPage;
import com.freecrm.contactsPage.contactPage;
import com.freecrm.dealsPage.dealsPage;
import com.freecrm.documents.documentsPage;
import com.freecrm.genriclib.basetest;
import com.freecrm.tasks.tasksPage;

public class homePage extends basetest {

	public homePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='header item']") WebElement crmLogo; 
	@FindBy(xpath ="//span[text()='Calendar']") WebElement calanderLink;
	@FindBy(xpath="//span[text()='Contacts']") WebElement contactsLink;
	@FindBy(xpath="//span[text()='Companies']") WebElement companiesLink;
	@FindBy(xpath="//span[text()='Deals']") WebElement dealsLink;
	@FindBy(xpath="//span[text()='Tasks']") WebElement tasksLink;
	@FindBy(xpath="//span[text()='Cases']") WebElement casesLink;
	@FindBy(xpath="//span[text()='Calls']") WebElement callsLink;
	@FindBy(xpath="//span[text()='Documents']") WebElement documentsLink;
	
	public boolean verifyLogo()
	{
	    return crmLogo.isDisplayed();
	}

	public calanderPage calander()
	{
		calanderLink.click();
		return new calanderPage();
	}
	
	public contactPage contacts()
	{
		contactsLink.click();
		return new contactPage();
	}

	public companiesPage companies()
	{
		companiesLink.click();
		return new companiesPage();
	}

	public dealsPage deals()
	{
	    dealsLink.click();
		return new dealsPage();
	}

	public tasksPage tasks()
	{
		tasksLink.click();
		return new tasksPage();
	}

	public casesPage cases()
	{
		casesLink.click();
		return new casesPage();
	}

	public callsPage calls()
	{
		callsLink.click();
		return new callsPage();
	}

	public documentsPage documents()
	{
		documentsLink.click();
		return new documentsPage();
	}

}
