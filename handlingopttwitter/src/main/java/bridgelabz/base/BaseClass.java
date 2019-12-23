package bridgelabz.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public String url = "https://twitter.com/";

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
		driver.get(url);
		driver.manage().window().maximize();
	}
//	@AfterClass
//	public void afterTest()
//	{
//		driver.quit();
//	}

}
