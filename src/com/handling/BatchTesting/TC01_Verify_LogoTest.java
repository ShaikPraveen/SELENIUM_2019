package com.handling.BatchTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_Verify_LogoTest 
{
	@Test
	public void LogoTest()
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    
		driver.get("http://demo.nopcommerce.com/");	
		
		
		WebElement ele=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		Assert.assertTrue(ele.isDisplayed());
	
		driver.close();
	}
}
