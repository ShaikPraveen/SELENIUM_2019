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

public class TC06_Handling_DropDownSortedOrNot
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.kapumatrimony.com/");
		Assert.assertEquals(driver.getTitle(), "Kapu Matrimony - The No. 1 Matrimony Site for Kapus - KapuMatrimony.com");
		
	    Select sele=new Select(driver.findElement(By.id("subCaste")));
	    List<WebElement> alloptions=sele.getOptions();
	   /* System.out.println(alloptions.size());
	    
	    for(WebElement web:alloptions)
	    {
	    	System.out.println(web.getText());
	    }
	    
	    driver.close();*/
	    
	    
	    List originallist=new ArrayList<>();
	    List  templist=new ArrayList<>();
	    
	    for(WebElement ele:alloptions)
	    {
	    	originallist.add(ele.getText());
	    	templist.add(ele.getText());
	    }
	    
	    System.out.println("BEFORE SORTING ORIGINAL LIST IS "+originallist);
	    System.out.println("BEFORE SORTING TEMP  LIST IS "+templist);
	    
	    
	    Collections.sort(templist);
	    
	    System.out.println("AFTER SORTING ORIGINAL LIST IS "+originallist);
	    System.out.println("AFTER SORTING TEMP  LIST IS "+templist);
	    
	    if (originallist==templist) 
	    {
		  System.out.println("DROP DOWN VALUES ARE SORTED");	
		} else
		{
         System.out.println("DROP DOWN VALUES ARE NOT SORTED");
		}
	    
	    
	    driver.close();
	}

}
