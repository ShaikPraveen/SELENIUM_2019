package com.handling.Alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC03_Handling_Alert3 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		Assert.assertEquals(driver.getTitle(), "Alerts");
		
		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		
		driver.switchTo().alert().sendKeys("Praveen");
		
		driver.switchTo().alert().accept();
		
		WebElement statustext=driver.findElement(By.xpath("//p[@id='demo1']"));
		Assert.assertTrue(statustext.isDisplayed(),"STATUS TEXT IS NOT DISPLAYED");
		
		driver.close();

	}

}
