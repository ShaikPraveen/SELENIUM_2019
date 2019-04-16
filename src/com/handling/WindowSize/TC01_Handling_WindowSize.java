package com.handling.WindowSize;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_WindowSize 
{
	public static void main(String[] args) 
	{
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://www.acegrades.com");
		  Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		  
		  System.out.println(driver.manage().window().getSize()); //(1382, 744)
		  
		  Dimension d=new Dimension(1200, 500);
		  
		  driver.manage().window().setSize(d);
		  
		  System.out.println(driver.manage().window().getSize());
		  
		 // driver.close();
		  	
	}

}
