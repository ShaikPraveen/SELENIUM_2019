package com.handling.Cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC01_Handling_Cookies 
{
	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  
		  driver.get("https://in.yahoo.com/");
		  
		  Set<Cookie> cookies=driver.manage().getCookies();
		  System.out.println("size of cookies are "+cookies.size());
		  
		  for(Cookie cookie : cookies)
		  {
			  System.out.println(cookie.getName()+": "+cookie.getValue());
		  }
		  
		  driver.manage().deleteAllCookies();
		  System.out.println("size of cookies are "+cookies.size());
		  
		  
		  driver.close();
	}

}
