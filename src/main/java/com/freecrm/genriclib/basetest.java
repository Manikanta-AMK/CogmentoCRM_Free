package com.freecrm.genriclib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freecrm.reports.webdriverFireEvent;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest implements IConst {

	public static Properties prop;
	public static WebDriver driver;
	public static Logger log;
	public static EventFiringWebDriver eventFiring;
	public static webdriverFireEvent webdrvierfireevent;
	
	
	public basetest()
	{
		 prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(configPath);
				prop.load(fis);
		    }catch (FileNotFoundException e) {
		        e.printStackTrace();	
			} catch (IOException e) {
				e.printStackTrace();
			}
	} 		
		
	public void openbrowser()
	{
		log = Logger.getLogger("FreeCRM");
		PropertyConfigurator.configure(log4jPath);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			log.info("chrome browser opened");
			
		}else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("firefox browser opened");
			
		}else{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("edge browser opened");
			
		}
		
		 eventFiring = new EventFiringWebDriver(driver);
		 webdrvierfireevent = new webdriverFireEvent();
		 eventFiring.register(webdrvierfireevent);
		 driver = eventFiring;
		 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		log.info("browser maximised");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String appUrl = prop.getProperty("url");
		driver.get(appUrl);
		log.info("application launched");
		
	}
	
	public void closebrowser()
	{
		driver.quit();
		log.info("application closed");
		
	}
}
