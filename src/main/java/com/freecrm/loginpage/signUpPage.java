package com.freecrm.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.genriclib.basetest;

public class signUpPage extends basetest{
	
	public signUpPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(@href,'https://api.co')]") WebElement signupBtn;
	@FindBy(name="email") WebElement emailTxt;
	@FindBy(name="phone") WebElement numberTxt;
	@FindBy(xpath="//input[@type=\"checkbox\"]") WebElement checkBox;
	@FindBy(xpath="(//div[@class='recaptcha-checkbox-border' and @role='presentation'])[1]") WebElement RobotCBox;
	@FindBy(xpath="//button[@type='submit']") WebElement signupBtn2;
	
	
	public void signupButton()
	{
		signupBtn.click();
	}
	
	public WebElement emailTextBox()
	{
		return emailTxt;
	}
	
	public WebElement phnoneNumberTextBox()
	{
		return numberTxt;
	}

	public void termsConditionsCheckBox()
	{
		checkBox.click();
	}

	public void robotCheckBox()
	{
		RobotCBox.click();
	}

	public void signUpButton2()
	{
		signupBtn2.click();
	}
	
	


}
