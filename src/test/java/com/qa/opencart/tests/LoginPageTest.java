package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("The page title is "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void forgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.forgottenPasswordIsDisplayed());
	}

	@Test(priority = 3)
	public void doLoginTest() {
		loginPage.doLogin("Test", "12345");
	}
}
