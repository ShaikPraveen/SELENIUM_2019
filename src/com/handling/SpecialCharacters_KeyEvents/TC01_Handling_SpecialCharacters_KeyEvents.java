package com.handling.SpecialCharacters_KeyEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Handling_SpecialCharacters_KeyEvents
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://acegrades.com");
		
		WebElement ele=driver.findElement(By.cssSelector("body"));
		//ele.sendKeys(Keys.F5);
		//ele.sendKeys(Keys.PAGE_DOWN);
		
		//Uni Code Keys
		//ele.sendKeys("\uE035"); //Will Refresh the Page
		ele.sendKeys("\uE00F"); //Will Refresh the Page
	}

}
