package com.handling.Checkboxes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC06_Handling_SelectMultiple_CheckBoxes 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
	  driver.get("file:///C:/Users/Manohar/Desktop/New%20folder/CheckBox1.html");
	    
	    
	  List<WebElement> ele=driver.findElements(By.xpath("//input[@type='checkbox']"));
	  System.out.println("NUMBER OF CHECKBOXES ARE =>"+ele.size());
	 
	  
	  for(WebElement element : ele)
	  {
		 element.click(); 
	  }
	}
}
