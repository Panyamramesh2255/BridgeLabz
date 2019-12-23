package bridgelabz.featuers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * purpose: Utility Class
 * 
 * @author PanyamRamesh
 *
 */
public class utility {
	/**
	 * purpose: Common functionality
	 * 
	 * @param url
	 */
	public static void openBrowser(String url) {
		System.setProperty("webdriver.gecko.driver",
				"//home/bridgeit/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get(url);

	}

}
