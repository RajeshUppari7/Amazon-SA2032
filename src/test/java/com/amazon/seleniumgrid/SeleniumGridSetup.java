package com.amazon.seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridSetup {
	@Test
	public void testSetup() throws MalformedURLException {

		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		driver.get("https://www.amazon.in/");
		System.out.println("App Title is : " + driver.getTitle());
		System.out.println("App Current URL is : " + driver.getCurrentUrl());

	}
}
