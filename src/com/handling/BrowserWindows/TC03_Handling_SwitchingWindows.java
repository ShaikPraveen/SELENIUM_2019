package com.handling.BrowserWindows;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC03_Handling_SwitchingWindows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    driver.get("https://www.talentzing.com/");
	    Assert.assertEquals(driver.getTitle(), "Talent Zing - NextGen Portal for Resources|Jobs|Trainings in India");
	    
	    String parentwindow=driver.getWindowHandle();
	    
	    driver.findElement(By.linkText("Terms & Conditions")).click();
	    
	    Set<String> windows=driver.getWindowHandles();
	    
	    for(String s : windows)
	    {
	    	driver.switchTo().window(s);
	    	String title=driver.getTitle();
	    	if (title.contains("TAC")) 
	    	{
			    driver.findElement(By.xpath("//*[@id='form1']/div[3]/div/a/div/div/span[1]")).click();
			    driver.close();
			    break;
			}
	    }
	    
	    driver.switchTo().window(parentwindow);
	    
	    WebElement image=driver.findElement(By.xpath("//*[@id='form1']/div[3]/div/div[1]/div/img[1]"));
	    Assert.assertTrue(image.isDisplayed(),"IMAGE IS NOT DISPLAYED"); 
	    
	    driver.quit();
	}
}
