package com.handling.Checkboxes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC04_Handling_CheckBox 
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
		
		WebElement ele=driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/form/div[4]/label"));
		String text=ele.getText();
		
		if (text.contains("Remember"))
		{
			Assert.assertTrue(true);
			System.out.println("TEXT IS DISPLAYED : TEST PASS");
			ele.click();
			
		} else 
		{
			Assert.assertTrue(false);
            System.out.println("TEXT IS NOT DISPLAYED : TEST FAIL");
		}
		
		driver.close();
	}
}
