package com.hanling.HashMap;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class TC02_Handling_HashMap {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/V4/index.php");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
		
		String credentials=getData().get("B");
		String arr[]=credentials.split("@");

		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(arr[0]);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arr[1]);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).sendKeys(Keys.RETURN);
		
		WebElement ele=driver.findElement(By.xpath("//a[contains(text(),'Demo Site')]"));
		Assert.assertTrue(ele.isDisplayed());
		
		driver.findElement(By.linkText("Log out")).click();
		driver.switchTo().alert().accept();
		
		String url=driver.getCurrentUrl();
		if (url.contains("index.php123"))
		{
			//Assert.assertTrue(true);
			System.out.println("URL IS MATCHED => "+ url +" <= TEST PASS");
			
		} else
		{
           //Assert.assertTrue(false);
           System.out.println("URL IS NOT MATCHED => "+ url +" <= TEST FAIL");
           File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\guru.png"));
		   System.out.println("SCREEN SHOT TAKEN");
		}
		
		
		driver.close();
	}
	
	
	public static HashMap<String, String> getData()
	{
		HashMap<String, String> map=new HashMap<String,String>();
		map.put("A", "mngr186224@esAdera");
		map.put("B","mngr186224@esAdera");
		return map;
	}	
}
