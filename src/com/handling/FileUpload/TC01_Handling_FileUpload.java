package com.handling.FileUpload;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_FileUpload 
{
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.tinyupload.com/");
		Assert.assertEquals(driver.getTitle(), "TinyUpload.com - best file hosting solution, with no limits, totaly free");
		
		driver.findElement(By.xpath("//input[@name='uploaded_file']")).click();
		
		Thread.sleep(2000);
		Runtime.getRuntime().exec("E:\\Praveen_Automation\\AutoIt_Programs\\TinyFileupload.exe");
		
		
	}

}
