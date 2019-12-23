package Bridgelabz.SeleniumProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FundooPush {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"//home/bridgeit/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		Robot r = new Robot();
		r.mouseMove(200, 500);
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F);
		r.keyRelease(KeyEvent.VK_F);
		r.keyRelease(KeyEvent.VK_ALT);
//	r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		driver.close();
	}

}
