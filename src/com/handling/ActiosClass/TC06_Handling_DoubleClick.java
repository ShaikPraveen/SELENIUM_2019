package com.handling.ActiosClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TC06_Handling_DoubleClick 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://jqueryui.com/");
		  Assert.assertEquals(driver.getTitle(), "jQuery UI");
		  
		  Actions act=new Actions(driver);
		  act.moveToElement(driver.findElement(By.linkText("Thems"))).doubleClick().perform();
		  
		  Assert.assertEquals(driver.getCurrentUrl(), "https://jqueryui.com/themeroller/");
		  driver.close();
		 
	}

}
