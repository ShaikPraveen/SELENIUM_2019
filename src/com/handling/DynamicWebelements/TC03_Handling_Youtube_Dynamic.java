package com.handling.DynamicWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC03_Handling_Youtube_Dynamic {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.youtube.com/");
		Assert.assertEquals(driver.getTitle(), "YouTube");
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("selenium");
		
	   List<WebElement> elements=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
	   System.out.println(elements.size());

		
	}

}
