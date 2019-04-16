package com.handling.DisableImages;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;

public class TC01_Handling_DisableImages 
{
	public static void main(String[] args) 
	{
		/*ChromeOptions options=new ChromeOptions();
		disableImagesChrome(options);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);*/
		
		FirefoxOptions options=new FirefoxOptions();
		disableImagesFirefox(options);
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver(options);
		//driver.get("https://www.amazon.com/");
		driver.get("https://classic.crmpro.com/index.html");
		//Assert.assertEquals(driver.getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");	
	}
	
	
	public static void disableImagesChrome(ChromeOptions options)
	{
		HashMap<String,Object> images=new HashMap<String,Object>();
		images.put("images", 2);
		
		HashMap<String,Object> prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values", images);
		
		options.setExperimentalOption("prefs", prefs);	
	}
	
	
	public static void disableImagesFirefox(FirefoxOptions options)
	{
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
	}
}
