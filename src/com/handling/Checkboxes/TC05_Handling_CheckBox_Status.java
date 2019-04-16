package com.handling.Checkboxes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC05_Handling_CheckBox_Status 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.get("https://www.acegrades.com");
	    Assert.assertEquals(driver.getTitle(), "ACEGRADES");
	    
	     driver.findElement(By.linkText("LOG IN")).click();
	    
	   WebElement element=driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/form/div[4]/label"));
	   
	 boolean elementisDisplayed = element.isDisplayed();
	 System.out.println("IS ELEMENT IS DISPLAYED "+elementisDisplayed);
	 
	 boolean elementisEnabled = element.isEnabled();
	 System.out.println("IS ELEMENT IS ENABLED  "+elementisEnabled);
	 
	 boolean elementisSelected = element.isSelected();
	 System.out.println("IS ELEMENT IS SELECTED "+elementisSelected);
	 
	 element.click();
	 
	 boolean elementNewStatus = element.isEnabled();
	 System.out.println("AFTER CLICK THE CHECK BOX, STATUS IS  "+elementNewStatus);
	 
	  WebElement logo=driver.findElement(By.xpath("//*[@id='logo_id']/img"));
	  Assert.assertTrue(logo.isDisplayed(),"LOGO IS NOT DISPLAYED");
	  driver.close();
	}
}
