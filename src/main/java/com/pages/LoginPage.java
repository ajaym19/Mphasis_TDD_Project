package com.pages;

import org.openqa.selenium.By;

import com.mphasis.base.TestBase;

public class LoginPage extends TestBase{

	public String getTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;
	}
	
	public void login(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
	}
}
