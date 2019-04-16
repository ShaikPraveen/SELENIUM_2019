package com.handling.ActiosClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TC02_Handling_MouseOver 
{
	public static void main(String[] args) {
		   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://www.nexaexperience.com/");
		  Assert.assertEquals(driver.getTitle(), "Top Luxury Cars in India: Price, Showrooms & Dealership | NEXA");
		  
		  Actions act=new Actions(driver);
		  
		  act.moveToElement(driver.findElement(By.linkText("NEXA SERVICES"))).build().perform();
		  
		  driver.findElement(By.linkText("ON ROAD SUPPORT")).click();
		  
		  Assert.assertEquals(driver.getCurrentUrl(), "https://www.nexaexperience.com/on-road-support.html");
		  driver.close();
		  
	}

}
