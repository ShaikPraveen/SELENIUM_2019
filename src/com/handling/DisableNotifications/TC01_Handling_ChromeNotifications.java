package com.handling.DisableNotifications;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TC01_Handling_ChromeNotifications
{
	//https://www.skptricks.com/2018/04/loading-of-unpacked-extensions-is-disabled-by-the-administrator.html
	public static void main(String[] args)
	{
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-notifications");
    	
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com/flights");
		Assert.assertEquals(driver.getTitle(), "Flight bookings, Cheap flights, Lowest Air tickets @Cleartrip");	
	}

}
