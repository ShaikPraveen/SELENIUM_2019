package com.handling.Checkboxes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC02_Handling_Checkbox 
{
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://practice.automationtesting.in/my-account/");
		Assert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		
		WebElement checkbox=driver.findElement(By.xpath("//label[@class='inline']"));
		
		//1.Verify Checkbox is displayed on not on Webpage 
		boolean checkboxisdisplayed=checkbox.isDisplayed();
		System.out.println("IS CHECK BOX IS DISPLAYED ON WEBPAGE =>"+checkboxisdisplayed);
		
		//2.Verify Checkbox is Enabled or not on Webpage
		boolean checkboxenabled=checkbox.isEnabled();
		System.out.println("IS CHECK BOX ENABLED ON WEBPAGE =>"+checkboxenabled);
	 
		//3.Verify Checkbox is Selected or not on Webpage
		boolean checkboxselected=checkbox.isSelected();
		System.out.println("IS CHECKBOX IS SELECTED on WEBPAGE  =>"+checkboxselected);
		
		checkbox.click();
		
		Thread.sleep(2000);
		
		//4. Check New Status after clicking Checkbox
		boolean checkbox_status=checkbox.isEnabled();
		System.out.println("AFTER SELECTED THE CHECK BOX STATUS IS =>"+checkbox_status);
		
		driver.close();
	}

}
