package com.handling.DropDowns;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC03_Handling_Dropdown_13 { // VERIFY VALUE PRESENT IN A DROP DOWN
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
		List<WebElement> dropdownvalues = sele.getOptions();
		System.out.println(dropdownvalues.size());
		String actvalue, expvalue;
		expvalue = "T24";
		boolean valueexist = false;

		for (int i = 0; i < dropdownvalues.size(); i++) {
			actvalue = dropdownvalues.get(i).getText();
			if (actvalue.contains(expvalue)) {
				valueexist = true;
				break;
			}
		}

		if (valueexist) {
			System.out.println("VALUE IS  PRESENT IN DROP DOWN");

		} else {
			System.out.println("VALUE IS NOT PRESENT IN DROP DOWN");
		}
		driver.close();

	}

}
