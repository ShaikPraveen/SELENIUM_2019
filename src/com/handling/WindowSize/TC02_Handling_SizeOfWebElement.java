package com.handling.WindowSize;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC02_Handling_SizeOfWebElement
{
	public static void main(String[] args) {

		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://acegrades.com/login.html");
		  Assert.assertEquals(driver.getTitle(), "Login");
		  
		  Dimension d=driver.findElement(By.xpath("//input[@type='text']")).getSize();
		  
		  System.out.println("WIDTH  OF THE WEB ELEMENT  "+d.width);
		  System.out.println("HEIGHT OF THE WEB ELEMENT  "+d.height);
		  
		  driver.close(); 
	}
}
