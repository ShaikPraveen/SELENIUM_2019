package com.handling.DropDownSortedOrNot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC08_Handling_DropdownSortedOrNot {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://testingmasters.com");
		Assert.assertEquals(driver.getTitle(), "Testing Masters");

		driver.findElement(By.xpath("/html/body/div[5]/div/div/a")).click();

		Thread.sleep(2000);

		WebElement logo = driver.findElement(By.xpath("//*[@id='undefined-sticky-wrapper']/div/div/div[1]/h1/a/img"));
		Assert.assertTrue(logo.isDisplayed(), "LOGO IS NOT DISPLAYED ON WEBPAGE");

		driver.findElement(By.linkText("REGISTER")).click();

		Select sele = new Select(driver.findElement(By.xpath("//select[@name='menu-123']")));
		List<WebElement> dropdownoptions = sele.getOptions();

		List<String> originallist = new ArrayList<String>();
		List<String> templist = new ArrayList<String>();

		for (WebElement ele : dropdownoptions) {
			originallist.add(ele.getText());
			templist.add(ele.getText());
		}
		System.out.println("BEFORE SORTING ORIGINAL LIST IS " + originallist);
		System.out.println("BEFORE SORTING TEMP LIST IS " + templist);

		Collections.sort(templist);

		System.out.println("AFTER SORTING ORIGINAL LIST IS " + originallist);
		System.out.println("AFTER SORTING TEMP LIST IS " + templist);

		if (originallist == templist) {
			System.out.println("DROP DOWN VALUES ARE SORTED");
		} else {
			System.out.println("DROP DOWN VALUES ARE NOT SORTED");
		}

		String url = driver.getCurrentUrl();
		if (url.contains("masters")) {
			System.out.println("URL IS MATCHED");
		} else {
			System.out.println("URL IS NOT MATCHED");
		}

		driver.close();
	}
}
