package com.handling.Alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_Alerts1
{
	//This script to handle Alert Box with OK Button
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		Assert.assertEquals(driver.getTitle(), "Alerts");
		
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		
		//driver.switchTo().alert().getText();
		//driver.switchTo().alert().accept();
		
		
		Alert alt=driver.switchTo().alert();
			
		
		if (alt.getText().contains(" am an alert box!"))
		{
		   System.out.println("TEST PASS");	
		} else {
           System.out.println("TEST FAIL");
		}
		
		alt.accept();
	}
}
