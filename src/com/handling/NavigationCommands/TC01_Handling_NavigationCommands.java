package com.handling.NavigationCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_NavigationCommands
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://demo.guru99.com/");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
		
		driver.navigate().to("https://money.rediff.com/tools/forex");
		Assert.assertEquals(driver.getTitle(), "Forex and Currency Converter : BSE, NSE, Stock quotes, share market, stock market, stock tips: Rediff Stocks");
		
		driver.navigate().back();
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
		
		driver.navigate().forward();
		driver.navigate().to("https://money.rediff.com/tools/forex");
		Assert.assertEquals(driver.getTitle(), "Forex and Currency Converter : BSE, NSE, Stock quotes, share market, stock market, stock tips: Rediff Stocks");
		
		driver.navigate().refresh();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://money.rediff.com/tools/forex");
		driver.close();
	}
}
