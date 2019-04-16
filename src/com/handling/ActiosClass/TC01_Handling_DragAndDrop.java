package com.handling.ActiosClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TC01_Handling_DragAndDrop
{
	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		  Assert.assertEquals(driver.getTitle(), "Demo 2: Drag and drop");
		  
		 WebElement source_element= driver.findElement(By.xpath("//div[@id='box7']"));
		 WebElement target_element=driver.findElement(By.xpath("//div[@id='box101']"));
		 
		 Actions act=new Actions(driver);
		 
		 //First Method 
		 //act.clickAndHold(source_element).moveToElement(target_element).release().build().perform();
		
		 
		 //Second Method 
		 act.dragAndDrop(source_element, target_element).build().perform();;
	}

}
