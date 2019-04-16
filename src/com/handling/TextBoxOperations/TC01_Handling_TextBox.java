package com.handling.TextBoxOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TC01_Handling_TextBox
{
	//OLD FIREFOX VERSION : 43.0.1
	//NEW FIREFOX VERSION : 64.0.2
	public static void main(String[] args) 
	{
		/*
		 TEXT BOX OPERATIONS
		 ===================
		 1. CLEAR THE TEXTBOX
		 2. ENTER THE VALUE IN TEXTBOX
		 3. RETRIVE THE VALUE FROM THE TEXTBOX
		 */
		
		//IN FIREFOX
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//IN CHROME
		//System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Browser_Drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		driver.findElement(By.linkText("PIM")).click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		driver.findElement(By.linkText("Add Employee")).click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		String employeeId=driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("EMPLOYEE ID IS "+employeeId);
		
		driver.close();
	}
}
