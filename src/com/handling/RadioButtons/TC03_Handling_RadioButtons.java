package com.handling.RadioButtons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class TC03_Handling_RadioButtons 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
	    driver.get("https://www.path2college529.com/plan/");
	    Assert.assertEquals(driver.getTitle(), "Planning & Saving for College : Path2College 529 Plan");
	   
	   //COUNT NUMBER OF RADIOS
	   List<WebElement> radios= driver.findElements(By.xpath("//input[@type='radio']"));
	   System.out.println("NUMBER OF RADIO BUTTONS ARE "+radios.size());
	   
	   System.out.println(" TEXT OF RADIO BUTTONS ARE ");
	   WebElement radio1=driver.findElement(By.xpath("//*[@id='sidebox-myth']/div/div[2]/label[1]"));
	   System.out.println(radio1.getText());
	
	   WebElement radio2=driver.findElement(By.xpath("//*[@id='sidebox-myth']/div/div[2]/label[2]"));
	   System.out.println(radio2.getText());
	
	   
	  radio1.click();
	  boolean maleradio=radio1.isEnabled();
	  System.out.println("IS MALE RADIO BUTTON SELECTED    =>"+maleradio);
	
	  radio2.click();
	  boolean femaleeradio=radio1.isEnabled();
	  System.out.println("IS FE-MALE RADIO BUTTON SELECTED  =>"+femaleeradio);
	
	
	}

}
