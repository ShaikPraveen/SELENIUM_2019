package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class TC11_Handling_Calender 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://tsrtconline.in/oprs-web/");
		Assert.assertEquals(driver.getTitle(), "TSRTC Official Website for Online Bus Ticket Booking - tsrtconline.in");
	
	    WebElement logo=driver.findElement(By.xpath("//div[@class='headerLogo']"));
	    Assert.assertTrue(logo.isDisplayed(),"LOGO IS NOT DISPLAYED");
	    
	    String expmonth="April 2019";
	    String day="25";
	    
	    String url=driver.getCurrentUrl();
	    if (url.contains("oprs-web")) 
	    {
	    	System.out.println("URL IS MATCHED : TEST PASS");
			
		} else
		{
			System.out.println("URL IS NOT MATCHED : TEST FAIL");
		}
	    
	    driver.findElement(By.xpath("//input[@name='txtJourneyDate']")).click();
	    while(true){
	    String current_month=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	    //System.out.println(current_month);
	    if (expmonth.equals(current_month)) 
	    {
		      break;	
		} else 
		{
           driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		}
	    }
	    
	    List<WebElement> alldates=driver.findElements(By.xpath("/html[1]/body[1]/div[5]/div[1]/table[1]/tbody[1]/tr/td"));
	    System.out.println(alldates);
	    
	    for(WebElement ele : alldates)
	    {
	    	String datenames=ele.getText();
	    	String arr[]=datenames.split("\n");
	    	
	    	if (arr[0].equals(day)) 
	    	{
			    ele.click();
			    break;
			}
	    } 
	    
	   WebElement footer= driver.findElement(By.xpath("//div[@class='h-b-left']"));
	   System.out.println("TOTAL FOOTER LINKS ARE");
	   System.out.println(footer.findElements(By.tagName("a")).size());
	   
	   driver.close();
	}

}
