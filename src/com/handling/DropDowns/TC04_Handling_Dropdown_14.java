package com.handling.DropDowns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC04_Handling_Dropdown_14
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.justrechargeit.com/");
		Assert.assertEquals(driver.getTitle(),
				"Online Mobile Recharge|Online Prepaid Mobile,DTH Recharge & Top Up for Airtel,Idea,Vodafone,Aircel,Tata Indicom,DOCOMO,Dish TV,Tata Sky & Videocon D2H");

		Select sele = new Select(driver.findElement(By.id("ddlMobileServiceProvider")));
        sele.selectByIndex(2);
        WebElement option=sele.getFirstSelectedOption();
        System.out.println(option.getText());
        
        sele.selectByIndex(3);
        WebElement option1=sele.getFirstSelectedOption();
        System.out.println(option1.getText());
        
        
        sele.selectByIndex(4);
        WebElement option2=sele.getFirstSelectedOption();
        System.out.println(option2.getText());
        
        
        sele.selectByVisibleText("Jio");
        WebElement option3=sele.getFirstSelectedOption();
        System.out.println(option3.getText());
        
        
        sele.selectByIndex(5);
        WebElement option4=sele.getFirstSelectedOption();
        System.out.println(option4.getText());
        
        sele.selectByIndex(10);
        WebElement option5=sele.getFirstSelectedOption();
        System.out.println(option5.getText());
        
        driver.close();
	}

}
