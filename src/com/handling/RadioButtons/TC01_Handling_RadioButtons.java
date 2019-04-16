package com.handling.RadioButtons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TC01_Handling_RadioButtons
{
	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");
	
	    List<WebElement> radios=driver.findElements(By.xpath("//input[@type='radio']"));
	    System.out.println("NUMBER OF RADIO BUTTONS ARE "+radios.size()); 
	    System.out.println("NAMES OF RADIO BUTTONS ARE");
	    WebElement roundtrip=driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]"));
	    System.out.println(roundtrip.getText());
	    
	    WebElement oneway=driver.findElement(By.xpath("//label[contains(text(),'One Way')]"));
	    System.out.println(oneway.getText());
	    
	    WebElement multicity=driver.findElement(By.xpath("//label[contains(text(),'Multi City')]"));
	    System.out.println(multicity.getText());
	    
	    roundtrip.click();
	    boolean roundtripselected=roundtrip.isEnabled();
	    System.out.println("IS ROUND TRIP RADIO BUTTON SELECTED =>"+roundtripselected);
	    
	    oneway.click();
	    boolean onewayselected=roundtrip.isEnabled();
	    System.out.println("IS ONE WAY RADIO BUTTON SELECTED =>"+onewayselected);
	    
	    multicity.click();
	    boolean multiselected=roundtrip.isEnabled();
	    System.out.println("IS MULTI CITY  RADIO BUTTON SELECTED =>"+multiselected);
	    
	    driver.close();       
	}
}
