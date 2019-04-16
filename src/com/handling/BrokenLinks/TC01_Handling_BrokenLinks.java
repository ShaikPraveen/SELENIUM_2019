package com.handling.BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class TC01_Handling_BrokenLinks
{
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");
	   
		//driver.get("http://www.newtours.demoaut.com/");
		//Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
		
		
		List<WebElement> alllinks=driver.findElements(By.tagName("a"));
		System.out.println(alllinks.size());
		
		for (int i = 0; i <alllinks.size(); i++) 
		{
			WebElement ele=alllinks.get(i);
			String url=ele.getAttribute("href");
			
			URL link=new URL(url);
			
			
			HttpURLConnection httpconnection = (HttpURLConnection)link.openConnection();
			
			Thread.sleep(3000);
			httpconnection.connect();
			
			int rescode=httpconnection.getResponseCode();
			
			if (rescode>=400)
			{
			   System.out.println(url +" = "+ " IS BROKEN LINK");	
			}else
			{
				System.out.println(url +" = "+ " IS VALID LINK");
			}	
		}
		
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.goibibo.com/");
		driver.close();
		
	}

}
