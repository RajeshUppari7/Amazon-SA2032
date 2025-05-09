package com.amazon.seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecution {
	WebDriver driver;

	@Test
	@Parameters({ "bname" })
	public void testParallelExecution(String bname) throws MalformedURLException {

		System.out.println("RemoteWebDriver session started");
		if (bname.equals("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
			System.out.println("*******Chrome browser*******");
		} else if (bname.equals("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
			System.out.println("*******Firefox browser*******");
		} else if (bname.equals("Edge")) {
			EdgeOptions options = new EdgeOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
			System.out.println("*******Edge browser*******");
		} else {
			System.out.println(bname + " browser not found");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		System.out.println("App Title is : " + driver.getTitle());
		System.out.println("App Current URL is : " + driver.getCurrentUrl());
		System.out.println("RemoteWebDriver session completed");

	}
}
