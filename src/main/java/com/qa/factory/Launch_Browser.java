package com.qa.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.ConfigReader;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch_Browser {
	
	public static WebDriver driver;
	public static ChromeOptions options;
	
	private Launch_Browser()
	{
		}
	
	public static WebDriver launch_browser()
	{
		if(driver==null)
		{
		
			if(ConfigReader.init_Reader().equalsIgnoreCase("chrome"))
		
			{
				
				
				WebDriverManager.chromedriver().setup();
				options = new ChromeOptions();
				options.addArguments("--start-maximized");
				driver=new ChromeDriver(options);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			}
	
		
			if(ConfigReader.init_Reader().equalsIgnoreCase("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			
		
		return driver;
		
		}
		else
			return driver;
		}
	
}
