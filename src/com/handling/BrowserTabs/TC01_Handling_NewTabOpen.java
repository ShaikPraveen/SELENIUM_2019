package com.handling.BrowserTabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_NewTabOpen
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
		  System.out.println(driver.getTitle());
		  
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t"); //It will open New tab
		  
		  driver.get("https://testautomationpractice.blogspot.com/");
		  System.out.println(driver.getTitle());
		  
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t"); //It will comes Previous Tab
		  System.out.println(driver.getTitle());
	}

}
