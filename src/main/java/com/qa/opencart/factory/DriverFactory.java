package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/***
 * 
 * @author kdhivya
 *
 */

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	
	/***
	 * This method is used to init the driver on the basis of given browser value
	 * @param browserName
	 * @return
	 */
	
	public WebDriver init_driver(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else {
			System.out.println("Invalid browser..... Please pass valid browsername");
		}
		
		driver.manage().deleteAllCookies();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		return driver;
	}
	
	/***
	 * This method is used to initiate the properties from the .properties file
	 * @return
	 */
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream  ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	
}

