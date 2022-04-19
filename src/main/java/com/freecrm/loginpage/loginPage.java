package com.freecrm.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.genriclib.basetest;

public class loginPage extends basetest {

	public loginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email") WebElement emailtxtBx;
	@FindBy(name="password") WebElement passwordBx;
	@FindBy(xpath="//a[text()='Forgot your password?']") WebElement frgtPwdBx;
	@FindBy(xpath ="//div[text()='Login']") WebElement loginBtn;
	@FindBy(xpath="//div[text()='Something went wrong...']") WebElement errorMsg;
	
	
	public void emailTextBox(String un)
	{
		emailtxtBx.sendKeys(un);
	}
	
	public void passwordTextBox(String pwd)
	{
		passwordBx.sendKeys(pwd);
	}
	
	public void forgotPasswordText()
	{
		frgtPwdBx.click();
	}
	
	public void loginButton()
	{
		loginBtn.click();
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyErrorMessage()
	{
		return errorMsg.getText();
	}
		
}
