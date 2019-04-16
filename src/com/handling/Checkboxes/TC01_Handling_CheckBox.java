package com.handling.Checkboxes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_CheckBox
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://practice.automationtesting.in/my-account/");
		Assert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		
		WebElement checkbox=driver.findElement(By.xpath("//label[@class='inline']"));
	    String checkbox_text=checkbox.getText();
	    
	    if (checkbox_text.contains("Remember me"))
	    {
	    	checkbox.click();
	    	System.out.println("REMEMEBER ME CHECK BOX IS DISPLAYED AND CLICKED : TEST PASS");
	    	
		}else
		{
		   System.out.println("REMEMEBER ME CHECK BOX IS NOT DISPLAYED NOT CLICKED : TEST FAIL");	
		}
	    
	     driver.close();
	}
}
