package com.handling.FindAllWebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Handling_FindAllWebElemensOnWebpage
{
	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://www.acegrades.com");
		  System.out.println(driver.getTitle());
		  
		  List<WebElement> elements=driver.findElements(By.xpath("//*"));
		  System.out.println(Integer.toString(elements.size()));
		  
		  for(WebElement ele : elements)
		  {
			  System.out.println(ele.getTagName()+" = "+ele.getText());
		  }
		  
		  driver.close();  
	}

}
