package com.handling.GetAll_ImageURL;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_Getall_ImageURLS 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.acegrades.com");
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		
		List<WebElement> allimages=driver.findElements(By.tagName("img"));
		System.out.println(allimages.size());
		
		for (int i = 0; i < allimages.size(); i++)
		{
			if (!(allimages.get(i).getAttribute("src").equals("")) && !(allimages.get(i).getAttribute("src")==null)) {
				System.out.println(allimages.get(i).getAttribute("src"));
			}	
		}
		
		driver.close();
		
	}

}
