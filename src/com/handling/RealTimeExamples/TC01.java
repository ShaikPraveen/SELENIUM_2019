package com.handling.RealTimeExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01
{
	//How to Findout Howmuch Time Taken Open website using Selenium with java
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		long start=System.currentTimeMillis();
		driver.get("https://acegrades.com/");
		long finish=System.currentTimeMillis();
		
		long total_time=finish-start;
		System.out.println("TOTAL TIME FOR PAGE LOAD TIME IS "+total_time);
		
		
		driver.close();	
	}
}
