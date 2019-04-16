package com.handling.Alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC02_Handling_Alert2
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		Assert.assertEquals(driver.getTitle(), "Alerts");
		
		driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String alt_text=driver.switchTo().alert().getText();
		System.out.println(alt_text);
		
		String expTextOK="You pressed Ok";
		String expTextCANCEL="You Pressed Cancel";
		
		driver.switchTo().alert().accept();
		
		String acttext=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		
		if (expTextOK.equals(acttext)==true) 
		{
		System.out.println("TEST PASS "+acttext);	
		}
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.switchTo().alert().dismiss();
		
		String acttext1=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		
		if (expTextCANCEL.equals(acttext1)==true) 
		{
		   System.out.println("TEST PASS "+acttext1);	
		}
		
		driver.close();
		
	}

}
