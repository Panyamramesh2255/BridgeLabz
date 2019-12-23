package bridgelabz.handlingopt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class VideoRecorder {

	public static WebDriver driver;
	ATUTestRecorder recorder;

	@BeforeTest
	public void basicFunction() throws ATUTestRecorderException {
		System.setProperty("webdriver.chrome.driver", "/home/bridgeit/Downloads/chromedriver_linux64/chromedriver");
		String url = "https://www.google.co.in/";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get(url);
		driver.manage().window().maximize();
		recorder = new ATUTestRecorder("./VideoOutput", "TestRecording", false);
		recorder.start();

	}

	@Test
	public void videoRecorder() {
		driver.navigate().to("https://www.amazon.in/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		// re

	}

	@AfterTest
	public void afterTest() throws ATUTestRecorderException {
		driver.quit();
		recorder.stop();
	}

}
