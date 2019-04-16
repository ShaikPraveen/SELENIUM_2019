package com.handling.PageSourceIntoTextFile;

import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_PageSourceIntoTextFile
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.guru99.com/");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
		
		String pagesource=driver.getPageSource();
		System.out.println(pagesource);
		
		try
		{
			File file=new File("C:\\Users\\Manohar\\Desktop\\HtmlCode.txt");
			FileWriter fw=new FileWriter(file);
			
			fw.write(pagesource);
			fw.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		driver.close();
	}

}
