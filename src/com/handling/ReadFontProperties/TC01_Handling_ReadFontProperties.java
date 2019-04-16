package com.handling.ReadFontProperties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_ReadFontProperties 
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
		 
		  WebElement element=driver.findElement(By.xpath("//button[@class='btn btn--main btn-large']"));
		  String color = element.getCssValue("color");
		  System.out.println("FONT COLOR IS =>"+color);
		  
		  String fontsize = element.getCssValue("font-size");
		  System.out.println("FONT SIZE IS =>"+fontsize);
		  
		  
		  String fontfamily = element.getCssValue("font-family");
		  System.out.println("FONT FAMILY IS =>"+fontfamily);
	
	}

}
