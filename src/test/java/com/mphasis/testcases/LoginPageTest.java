package com.mphasis.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mphasis.base.TestBase;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		initialization();
	}
	
	@Test
	public void validateTitleTest() {
		String expectedTitle = "OrangeHRM";
		LoginPage lp = new LoginPage();
		String actualTitle = lp.getTitle();
		AssertJUnit.assertEquals(expectedTitle, actualTitle);
	}

	@Test
	public void validateLoginTest() {
		LoginPage lp = new LoginPage();
		lp.login("Admin", "admin123");
	}
	
	@AfterMethod
	public void closeSetUp() {
		tearDown();
	}
}
