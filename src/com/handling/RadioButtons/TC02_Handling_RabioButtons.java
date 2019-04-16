package com.handling.RadioButtons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC02_Handling_RabioButtons
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
	
		List<WebElement> allradios=driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("NUMBER OF RADIO BUTTONS ARE "+allradios.size());
		
		System.out.println("====NAMES OF RADIO BUTTONS ARE======");
		WebElement radiobutton1=driver.findElement(By.xpath("//*[@id='u_0_z']/span[1]/label"));
		System.out.println(radiobutton1.getText());
		
		
		WebElement radiobutton2=driver.findElement(By.xpath("//*[@id='u_0_z']/span[2]/label"));
		System.out.println(radiobutton2.getText());
		
		
		radiobutton1.click();
		boolean status=radiobutton1.isEnabled();
		System.out.println("AFTER CLICKING FEMALE BUTTON, STATUS IS "+status);
		
		radiobutton2.click();
		boolean status1=radiobutton1.isEnabled();
		System.out.println("AFTER CLICKING MALE BUTTON, STATUS IS "+status1);
		
		driver.close();
	}

}
