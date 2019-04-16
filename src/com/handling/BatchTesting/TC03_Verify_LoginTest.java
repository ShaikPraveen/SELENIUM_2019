package com.handling.BatchTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_Verify_LoginTest 
{
	
	@Test
	public void loginTest()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    
		driver.get("http://demo.nopcommerce.com/");	
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("info.praveen77@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).sendKeys(Keys.RETURN);
		
		String url=driver.getCurrentUrl();
		
		if (url.contains("com"))
		{
		   Assert.assertTrue(true);	
		} else 
		{
           Assert.assertTrue(false);
		}
		
		driver.close();
	}
}


