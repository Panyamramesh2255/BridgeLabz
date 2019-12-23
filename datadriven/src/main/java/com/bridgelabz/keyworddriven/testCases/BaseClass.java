package com.bridgelabz.keyworddriven.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * 
 * @author PanyamRamesh purpose: base class implementation
 */
public class BaseClass {
	public String url = "https://fundoopush-dev.bridgelabz.com/login";
	public String UserName = "suhas.mhatre@bridgelabz.com";
	public String Password = "suhas";
	public static WebDriver driver;

	/**
	 * purpose: implementing method which keeps basic requirements for project
	 */

	@BeforeClass
	public void prerequi() {
		System.setProperty("webdriver.chrome.driver", "/home/bridgeit/Downloads/chromedriver_linux64/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void terminate() {
		driver.quit();
	}

}
