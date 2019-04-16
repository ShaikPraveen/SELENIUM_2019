package com.handling.HightWebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Highlight_WebElement 
{
	public static WebDriver driver;
	
	public static void main(String[] args) 
	{
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("http://demo.guru99.com/V4/");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
		
		WebElement username=driver.findElement(By.xpath("//input[@name='uid']"));
		//highlightWebelement(username);
		//highLightElement(username);
		highLightElement1(username);
		username.sendKeys("mngr47659");
		
		
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		//highlightWebelement(password);
		//highLightElement(password);
		highLightElement1(password);
		password.sendKeys("12345@");
		
		WebElement loginbtn=driver.findElement(By.xpath("//input[@name='btnLogin' or @value='LOGIN']"));
		//highlightWebelement(loginbtn);
		//highLightElement(loginbtn);
		highLightElement1(loginbtn);
		loginbtn.click();
		
	String welcome_text=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")).getText();
	    if (welcome_text.contains("Welcome To"))
	    {
	    	Assert.assertTrue(true);
			
		} else
		{
            Assert.assertTrue(false);
		}
	    
	    driver.close();
	}
	

	public static void highlightWebelement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;');",element);	
	}
	
	
	
	//Display yellow background  and border highlight with red color.
	public static void highLightElement(WebElement element) {

		 try {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
		  Thread.sleep(1000);
		  js.executeScript("arguments[0].style.border=''", element, "");
		  Thread.sleep(1000);
		 } catch (InterruptedException e) {
		 
		  e.printStackTrace();
		 }
		}
	
	//Display only border highlight only using Red color :
	public static void highLightElement1(WebElement element) {

		 try {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].setAttribute('style','border: 2px solid red;');", element);
		  Thread.sleep(1000);
		  js.executeScript("arguments[0].style.border=''", element, "");
		  Thread.sleep(1000);
		 } catch (InterruptedException e) {
		 
		  e.printStackTrace();
		 }
		}


}
