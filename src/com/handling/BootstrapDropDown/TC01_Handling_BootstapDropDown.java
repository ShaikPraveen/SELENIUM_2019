package com.handling.BootstrapDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_BootstapDropDown
{
	//This script to handle BootStrap Dropdown
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://demo.guru99.com/");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
		
		driver.findElement(By.linkText("Selenium")).click();
		
		List<WebElement> selenium_content=driver.findElements(By.xpath("//*[@id='navbar-brand-centered']/ul/li[1]/ul/li/a"));
		System.out.println(selenium_content.size());
		
		for (int i = 0; i < selenium_content.size(); i++)
		{
		    String selenium_content_text=selenium_content.get(i).getText();	
		    System.out.println(selenium_content_text);
		    
		    WebElement ele=selenium_content.get(i);
		    String innerhtml=ele.getAttribute("innerHTML");
		    if (innerhtml.contentEquals("Scrollbar Demo"))
		     {
			      ele.click();
			      Assert.assertEquals(driver.getTitle(), "Scrolling Demo page");
			      break;
			}
		}
		driver.close();
	}
}
