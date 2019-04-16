package com.handling.JavascriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_JavascriptExecutor
{
	/*Using Javascript we can perform following Operations
	1. Flashing an Element
	2. Drawing a Border
	3. After drawing a border take screen shot
	4. Captupe Title of the Page
	5. Click an Element
	6. Generate an Alert at runtime
	7. Refreshing an Element
	8. Scroll down the page till we find an Element
	9. Scroll down the page till end
*/
	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.shine.com/");
		Assert.assertEquals(driver.getTitle(), "Jobs 2019 - Search Jobs in India, Latest Job Vacancies, Recruitment - Shine.com");
		
		// 1. Flashing
		WebElement element_register=driver.findElement(By.xpath("//a[@class='cls_register_signin_homepage']"));
		//TC01_JavascriptUtil.Flash(driver, element_register);
		
		// 2. DrawBorder
		  //TC01_JavascriptUtil.drawBorder(element_register, driver);
		
		//3. After DrawBorder Takescreenshot
		//File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\Screenshots\\shine.png"));
	  
		//4. Captupe Title
		String title=TC01_JavascriptUtil.captureTitle(driver);
		System.out.println(title);
		
		//5. Click an Element
		//WebElement sign_btn=driver.findElement(By.xpath("//div[@class='up']"));
		//TC01_JavascriptUtil.clickElement(sign_btn, driver);
		
		//6. Generate an Alert
		//TC01_JavascriptUtil.generateAlert(driver, "You Clicked Sign In Button!!!!");
		
		//7. Refresh the Page
		TC01_JavascriptUtil.refreshPage(driver);
		
		//8. Scroll down the page till find an element
		//WebElement ele=driver.findElement(By.xpath("//h2[contains(@class,'headfmt')]"));
		//TC01_JavascriptUtil.scrollPage(ele, driver);
		
		//9. Scroll page till down
		TC01_JavascriptUtil.scrollpageTillEnd(driver);
		
		
		
		//driver.close();
	}  
}
