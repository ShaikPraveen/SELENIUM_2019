package com.handling.HrefValue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_Href_Value
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://demo.guru99.com/");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
		
		String href=driver.findElement(By.linkText("Selenium")).getAttribute("href");
		System.out.println(href);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/");
		driver.close();
	}

}
