package com.freecrm.commonlib;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.freecrm.genriclib.basetest;
import com.freecrm.reports.extentReports3;
import com.google.common.io.Files;

public class reUsableMethods extends basetest {
	
	public void backNavigation()
	{
		driver.navigate().back();
	}
	
	public void frontnavigation()
	{
		driver.navigate().forward();
	}
	
	public void pageRefresh()
	{
		driver.navigate().refresh();
	}
	
	public static void elementStatus(int checkType, WebElement element, String elementName)
	{
		switch(checkType)
		{
		case 1: 
			try {
				element.isDisplayed();
				extentReports3.test.info(MarkupHelper.createLabel(elementName+" is displayed", ExtentColor.ORANGE));
				
			}
			catch(Exception e)
			{
				extentReports3.test.info(MarkupHelper.createLabel(elementName+" is not displayed", ExtentColor.GREY));
			}
			break;
			
		case 2:
			try {
				element.isEnabled();
				extentReports3.test.info(MarkupHelper.createLabel(elementName+" is enabled", ExtentColor.ORANGE));
			}
			catch(Exception e)
			{
				extentReports3.test.info(MarkupHelper.createLabel(elementName+" is not disabled", ExtentColor.PINK));
			}
		    break;
		
		case 3:
			try {
				element.isSelected();
				extentReports3.test.info(MarkupHelper.createLabel(elementName+" is selected", ExtentColor.ORANGE));
			}
		    catch(Exception e)
			{
		    	extentReports3.test.info(MarkupHelper.createLabel(elementName+" is not selected", ExtentColor.YELLOW));
			}
		    break;
		}
	}

	public void pageTitleVerification(String actual, String expected, String pagetitle)
	{
		Assert.assertEquals(actual, expected);
		
		if(actual.equals(expected))
		{
			Assert.assertEquals(pagetitle+" is displayed, passed", true);
		}else {
			Assert.assertEquals(pagetitle+" is not displayed, failed", false);
		}
	}
	
	public void webdrvierwait(By element)
	{
		WebDriverWait wait =  new WebDriverWait(driver, 20);
	}
	
	public void staticDropDownVisibleTxt(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void staticDropDownByIndex(WebElement element, String text, int number)
	{
		Select sel = new Select(element);
        sel.selectByIndex(number);
	}

	public void staticDropDownByValue(String value, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void staticDropDownDeSelectAll(WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectAll();
	}

	public void staticDropDownByIndex(int index, WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}
	
	public void ActionsClass(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public Robot robotclassEnter() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		return robot;
	}
	
	public void robotclassDown() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
	}

	public void robotclassUp() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
	}

	public void robotclassRight() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
	}

	public void robotclassLeft() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_LEFT);
	}

	public static void screenShots() throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = "./screenShots/"+System.currentTimeMillis()+".png";
		File destination = new File(dest);
		try {
			Files.copy(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public void javaScript(JavascriptExecutor JavascriptExecutor)
//	{
//		JavascriptExecutor js = JavascriptExecutor;
//		js.executeScript(null, null)
//	}
	

	
	
	
}
