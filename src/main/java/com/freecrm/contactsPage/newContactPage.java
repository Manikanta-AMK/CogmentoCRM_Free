package com.freecrm.contactsPage;

import java.awt.GraphicsDevice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.genriclib.basetest;

public class newContactPage extends basetest {

	public newContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="first_name") WebElement firstNameTxt;
	@FindBy(name="last_name") WebElement lastNameTxt;
	@FindBy(name="middle_name") WebElement middleNameTxt;
	@FindBy(xpath="(//input[@class='search'])[1]") WebElement companyTxtBx;
	@FindBy(xpath="//button[@class='ui small fluid positive toggle button']") WebElement privateBtn;
	@FindBy(xpath="//div[@class='twelve wide field']") WebElement accessTxt;
	@FindBy(xpath = "//i[@class='delete icon']") WebElement nameDelectIcon;
	@FindBy(xpath="//input[@placeholder='Email address']") WebElement emailTxt;
	@FindBy(xpath="(//i[@class='add icon'])[1]") WebElement addMail;
	@FindBy(xpath="(//button[@class='ui tiny basic icon button'])[2]") WebElement removeTxtBx;
	@FindBy(xpath="//div[@name='category' and @role='listbox']") WebElement categoryDropDown;
	@FindBy(xpath="//div[@name='status' and @role='listbox']") WebElement statusDropDownBx;
	@FindBy(xpath="//button[@class='ui linkedin button']") WebElement saveBtn; 
	@FindBy(xpath="//i[@class='large user red icon']") WebElement newContactIcon;
	@FindBy(xpath="//div[@class='visible menu transition']//descendant::span[text()='India']") WebElement countryName;
	@FindBy(xpath="//input[@placeholder='Number']") WebElement phoneNumber;
	
	
	public void firstNameTextBox(String firstName)
	{
		firstNameTxt.sendKeys(firstName);
	}
	
	public void lastNameTextBox(String lastName)
	{
		lastNameTxt.sendKeys(lastName);
	}
	
	public void middleNameTextBox(String middleName)
	{
		middleNameTxt.sendKeys(middleName);
	}
	
	public void companyNameTextBox(String companyName)
	{
		companyTxtBx.sendKeys(companyName);
	}
	
	public void privateButton()
	{
		privateBtn.click();
	}
	
	public void accessTextBox()
	{
		accessTxt.click();
	}
	
	public void nameDelete()
	{
		nameDelectIcon.click();
	}
	
	public void emailTextBox(String mailid)
	{
		emailTxt.sendKeys(mailid);
	}
	
	public void addEmail()
	{
		addMail.click();
	}
	
	public void removeMail()
	{
		removeTxtBx.click();
	}
	
	public void categoryDD()
	{
		categoryDropDown.click();
	}
	
	public void selectDD()
	{
		statusDropDownBx.click();
	}

	public void saveButton()
	{
		saveBtn.click();
	}
	
	public boolean newContactIcon()
	{
		return newContactIcon.isDisplayed();
	}
	
	public void countryName()
	{
        countryName.sendKeys();
	}
	
	public void contactNumber(String number)
	{
		phoneNumber.sendKeys(number);
	}
 
}
