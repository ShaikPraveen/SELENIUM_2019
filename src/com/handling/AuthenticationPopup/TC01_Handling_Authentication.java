package com.handling.AuthenticationPopup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_Authentication 
{
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth/");
		Assert.assertEquals(driver.getTitle(), "The Internet");
		
		WebElement ele=driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]"));
		
		if (ele.getText().contains("Congratulations!"))
		{
			System.out.println("TEST PASS");
			
		} else
		{
			System.out.println("TEST FAIL");
		}
		
		driver.close();
	}
}
