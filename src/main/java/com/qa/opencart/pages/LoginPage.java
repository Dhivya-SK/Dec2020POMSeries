package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//Page locators - This will act like a Object repository
	private By emailId = By.id("input-email");
	private By passwd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@class='btn btn-primary' and @value = 'Login']");
	private By forgottenPwd = By.xpath("//div[@class = 'form-group']/a[(text() = 'Forgotten Password')]");
	
	//Constructor:
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean forgottenPasswordIsDisplayed() {
		return driver.findElement(forgottenPwd).isDisplayed();
	}
	
	public void doLogin(String un, String pwd) {
		System.out.println("Login with " +un +" and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(passwd).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}
	

}
