package com.mphasis.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginPageTest {

	@Test
	public void validateTitleTest() {
		String expectedTitle = "OrangeHRM";
		LoginPage lp = new LoginPage();
		String actualTitle = lp.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void validateLoginTest() {
		LoginPage lp = new LoginPage();
		lp.login("Admin", "admin123");
	}
}
