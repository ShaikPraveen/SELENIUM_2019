package com.handling.JavascriptExecutor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TC02_Handling_JavascriptExecutor 
{
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		//driver.get("https://www.google.com/");
		driver.get("https://www.twoplugs.com/");
		Assert.assertEquals(driver.getTitle(), "twoPLUGS - A plug for your Service and another for your Need");
		
		
		//1.Flashing an Element
		//WebElement button=driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a/span"));
	   // TC02_Javascript_Util.flash(button, driver);
	    
	    //2. Draw Border
	    //TC02_Javascript_Util.drawBorder(button, driver);
	    
	    //3.Take Screenshot
	   //File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   //FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\Screenshots\\twoplugs.png"));
	   
	   //4. Capture Title 
	   String title=TC02_Javascript_Util.captureTitle(driver);
	   System.out.println(title);
	   
	   //5. Click An Element
	  // WebElement ele=driver.findElement(By.xpath("//body[@class='main-template']/div[@class='wrapper']/header/div[@class='container']/ul[@class='control-bar']/li/a[@class='btn border']/span[1]"));
	   //TC02_Javascript_Util.clickElement(ele, driver);
	  
	   //6. Generate An Alert at Runtime
	  // TC02_Javascript_Util.generateAlert("You Clicked Login Button!!!", driver);
	  
	   //7. Refresh the Page
	   //TC02_Javascript_Util.refreshPage(driver);
	   
	   //8. ScrollPage till an Element Find 
       //WebElement img_ele=driver.findElement(By.xpath("//img[@src='/newlayout/images/screen.png']"));
	   //TC02_Javascript_Util.scrolltillFindElement(img_ele, driver);
       
       //9.Scrollpage down till end
       //TC02_Javascript_Util.scrollDown(driver);
	   
	   //10.ZoomInZoomOut
	  // TC02_Javascript_Util.zoomInZoomOut(driver);
	   
	  		 Thread.sleep(5000);
			 System.out.println("zooming");
			 // To zoom in 3 times
			 for(int i=0; i<3; i++)
			 {
				
			 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ADD));
			 }
			 // To zoom out 3 times
			 for(int i=0; i<3; i++)
			 {
				 
			 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
			 }
			 //To set the browser to default zoom level ie., 100%
			 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
				
	}
}
