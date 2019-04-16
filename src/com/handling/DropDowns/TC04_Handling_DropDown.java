package com.handling.DropDowns;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC04_Handling_DropDown 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		
		driver.get("https://www.justrechargeit.com/");
		Assert.assertEquals(driver.getTitle(), "Online Mobile Recharge|Online Prepaid Mobile,DTH Recharge & Top Up for Airtel,Idea,Vodafone,Aircel,Tata Indicom,DOCOMO,Dish TV,Tata Sky & Videocon D2H");
		
		Select sele=new Select(driver.findElement(By.xpath("//select[@id='ddlMobileServiceProvider']")));
		List<WebElement> options=sele.getOptions();
		System.out.println(options.size());
		
		String actoption,expoption;
		expoption="DOCOMO";
		boolean optionexist=false;
		
		for(int i=0; i<options.size();i++)
		{
		      System.out.println(options.get(i).getText());
		      actoption=options.get(i).getText();
		      if (actoption.contains(expoption))
		      {
		    	optionexist=true;
		     	break;
			} 
		}
		if (optionexist) 
		{
			
			System.out.println("EXPECTED ELEMENT IS FOUND IN DROP DOWN  => "+expoption); 	
		} else
		{
			
			System.out.println("EXPECTED ELEMENT IS NOT FOUND IN DROP DOWN => "+expoption);
		}
		
		    driver.close(); 	
	}

}
