package com.crm.vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogoutTest {
	@Test
	public void loggingToVtigerTest()
	{
		String browserName = System.getProperty("browser");
		String url= System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			
			driver= new OperaDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
	
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG\']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
		
	

}
