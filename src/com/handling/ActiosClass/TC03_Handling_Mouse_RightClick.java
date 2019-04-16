package com.handling.ActiosClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TC03_Handling_Mouse_RightClick 
{
	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		  Assert.assertEquals(driver.getTitle(), "jQuery contextMenu (2.x)");
		  
		 Actions act=new Actions(driver);
		 act.moveToElement(driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']")));
		 act.contextClick().build().perform();
		 
		 
		 driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click();

	    String copytext=driver.switchTo().alert().getText();
	    
	    driver.switchTo().alert().accept();
	    
	    if (copytext.contains("clicked: copy")) 
	    {
		    System.out.println("TEST PASS");	
		} else
	 	{
           System.out.println("TEST FAIL");
		}
	}

}
