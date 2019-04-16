package com.handling.CordinatesOfWebelement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_Webelement_Cordinates 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.acegrades.com");
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		
		WebElement element=driver.findElement(By.linkText("LOG IN"));
		
		Point p=element.getLocation();
		  int xcord= p.getX();
		  int ycord= p.getY();
		  
	System.out.println("X AND Y CORDINATES ARE => "+xcord+" - "+ycord);
	
	driver.close();
	}

}
