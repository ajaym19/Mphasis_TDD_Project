package com.mphasis.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	static public WebDriver driver;
	static public Properties prop;

	public TestBase() {
		String propFilePath = "./src/main/java/com/mphasis/config/config.properties";
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find the Properties File");
		} catch (IOException e) {
			System.out.println("Cannot load the properties file");
		}
	}

	public void initialization() {
		// check what browser is mentioned in the property file
		// based on that launch and do the browser config
		// use if-else
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}

	public void tearDown() {
		driver.quit();
	}

}
