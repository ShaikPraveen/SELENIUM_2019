package com.handling.TimeoutException;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.common.OpCode;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class Handling_TimeoutException 
{
	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("http://demo.guru99.com/V4/index.php");
		String title=driver.getTitle();
		if (title.contains("Guru99"))
		{
		       Assert.assertTrue(true);	
		} else
		{
			 Assert.assertTrue(false);	
		}
		
		driver.close();
	}
}
