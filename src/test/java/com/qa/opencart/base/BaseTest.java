package com.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	private WebDriver driver;
	DriverFactory df;
	public LoginPage loginPage;
	
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		driver = df.init_driver("chrome");
		loginPage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
