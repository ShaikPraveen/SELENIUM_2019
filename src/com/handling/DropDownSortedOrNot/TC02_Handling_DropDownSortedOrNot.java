package com.handling.DropDownSortedOrNot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC02_Handling_DropDownSortedOrNot
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		Assert.assertEquals(driver.getTitle(), "Facebook � log in or sign up");
		
		Select sele=new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		
		List originallist=new ArrayList<>();
		List templist=new ArrayList<>();
		
		List<WebElement> options=sele.getOptions();
		
		for(WebElement ele : options)
		{
		              originallist.add(ele.getText());
		              templist.add(ele.getText());
		}	
		System.out.println("BEFORE SORTING ORIGINAL LIST IS "+originallist);
		System.out.println("BEFORE SORTING TEMP LIST IS "+templist);
		
		Collections.sort(templist);
		
		System.out.println("AFTER SORTING ORIGINAL LIST IS "+originallist);
		System.out.println("AFTER SORTING TEMP LIST IS "+templist);
		
		if (originallist==templist) 
		{
		   System.out.println("DROP DOWN VALUES ARE SORTED");	
		} else 
		{
          System.out.println("DROP DOWN VALUES ARE NOT SORTED");
		}
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		driver.close();
	}
}
