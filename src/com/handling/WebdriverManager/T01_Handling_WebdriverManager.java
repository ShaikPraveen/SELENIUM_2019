package com.handling.WebdriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T01_Handling_WebdriverManager
{
	
	//https://github.com/bonigarcia/webdrivermanager
	//https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/3.3.0
	
	//What is Webdriver Manager?
	//1.WebDriverManager as Java dependency 
	//2.WebDriverManager as a Command Line Interface (CLI) tool
	//3.WebDriverManager as Server
	//4.WebDriverManager is open source, released under the terms of Apache 2.0 License.
	
	public static void main(String[] args) 
	{
		
		//In Chrome
		/*WebDriverManager.chromedriver().version("65.35").setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");*/
		
		
		//In Firefox
		WebDriverManager.firefoxdriver().version("65.35").setup();
		WebDriver driver=new FirefoxDriver();
		//driver.manage().window().maximize();
		//driver.get("https://google.com");
		
		driver.close();
		
		
	}

}
