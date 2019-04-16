package com.handling.LastModifiedWebPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC02_Handling_WebPageReadyStateOrNot 
{
	public static void main(String[] args)
	{
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://acegrades.com/");
		  Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		 
		  //driver.get("https://www.goibibo.com/");
		  //Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");
			
		  //driver.get("https://www.facebook.com/");
		  //Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
			
		  
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  String ready=(String)js.executeScript("return document.readyState");
		  System.out.println("READY OR NOT :"+ready);
		  
		  driver.close(); 
		
	}

}
