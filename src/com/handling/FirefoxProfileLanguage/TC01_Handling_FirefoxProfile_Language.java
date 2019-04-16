package com.handling.FirefoxProfileLanguage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;

public class TC01_Handling_FirefoxProfile_Language 
{
	public static void main(String[] args)
	{   
		  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		  WebDriver driver = new FirefoxDriver();
		  
		  FirefoxProfile profile=new FirefoxProfile();
		  profile.setPreference("intl.accept_languages", "p1");  
		  
		 //driver=new FirefoxDriver(profile);
		  driver.get("https://google.com/");
		  Assert.assertEquals(driver.getTitle(), "Google");
		  
		  
	}

}
