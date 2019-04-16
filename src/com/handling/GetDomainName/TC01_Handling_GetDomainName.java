package com.handling.GetDomainName;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_GetDomainName
{
	public static void main(String[] args) throws MalformedURLException {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://www.acegrades.com");
		  Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		  
		  URL url=new URL(driver.getCurrentUrl());
		  String domainname=url.getHost();//This is our goal
		  String protocol=url.getProtocol();
		  String authority=url.getAuthority();
		  System.out.println(domainname+" - "+protocol+" - "+authority);
		  
		  driver.close();
		  
	}

}
