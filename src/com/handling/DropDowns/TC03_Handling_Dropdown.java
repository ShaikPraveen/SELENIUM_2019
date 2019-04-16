package com.handling.DropDowns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC03_Handling_Dropdown 
{
	//This Script to Select the Value From Drop down and Print the Selected Value
	public static void main(String[] args) {
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");
    
		Select sele=new Select(driver.findElement(By.xpath("//select[@id='gi_class']")));
		
		sele.selectByIndex(1);
		WebElement option=sele.getFirstSelectedOption();
		System.out.println(option.getText());
		
		sele.selectByVisibleText("First class");
		WebElement option1=sele.getFirstSelectedOption();
		System.out.println(option1.getText());
		
		sele.selectByVisibleText("Premium Economy");
		WebElement option2=sele.getFirstSelectedOption();
		System.out.println(option2.getText());
		
		driver.close();
	}
}
