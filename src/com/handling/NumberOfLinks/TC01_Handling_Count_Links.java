package com.handling.NumberOfLinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_Count_Links 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.guru99.com/");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("SIZE OF TOTAL LINKS "+links.size());
		
		/*for (int i = 0; i < links.size(); i++) 
		{
		      String linkname=links.get(i).getText();
	          System.out.println(linkname);
		}*/
		
		//Nested For Loop
		
		for (WebElement ele : links) 
		{
		    String linknames=ele.getText();	
		    System.out.println(linknames);
		}
		
		driver.close();
	}
}
