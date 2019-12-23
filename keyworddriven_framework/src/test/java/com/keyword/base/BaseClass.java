package com.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * purpose: Base class for keyword_driven_framework
 * 
 * @author PanyamRamesh
 *
 */
public class BaseClass {
	public static  WebDriver driver;
	public static Properties property;

	/**
	 * purpose: Initialization of webdriver
	 * 
	 * @param browserName
	 * @return
	 */
 public static void main(String[] args) {
	BaseClass bc=new BaseClass();
	driver=bc.web_Driver_Init("chrome");
	System.out.println("driver.."+driver);
	driver.get("https://www.facebook.com");

}
      
	public WebDriver web_Driver_Init(String browserName) {
		if (browserName.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/bridgeit/Downloads/chromedriver_linux64/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();
		}
		return driver;
	}

	/**
	 * purpose: Initialization of properties file
	 * 
	 * @return
	 */

	public Properties init_prop() {
		property = new Properties();
		try {
			FileInputStream fip = new FileInputStream(
					"/home/bridgeit/eclipse-workspace/keyworddriven_framework/src/test/java/com/keyword/config/configuration.properties");
			try {
				property.load(fip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return property;
	}
}
