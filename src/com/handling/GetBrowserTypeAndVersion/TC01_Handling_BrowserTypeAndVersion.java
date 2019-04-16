package com.handling.GetBrowserTypeAndVersion;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class TC01_Handling_BrowserTypeAndVersion
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		Capabilities caps=((RemoteWebDriver)driver).getCapabilities();
		String browserNmae=caps.getBrowserName();  
		String browserVersion=caps.getVersion();
		System.out.println(browserNmae +" - "+browserVersion);
		
		driver.close();	             
	}
}
