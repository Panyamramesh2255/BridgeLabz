package bridgelabz.handlingopt;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShot {
	public WebDriver driver;

	@BeforeTest
	public void basicFunction() {
		System.setProperty("webdriver.chrome.driver", "/home/bridgeit/Downloads/chromedriver_linux64/chromedriver");
		String url = "https://www.facebook.com/";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test
	public void screenshots() throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourse = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourse, new File("./ScreenShot/screenshot-" + new Date() + ".jpeg"));
		System.out.println("screen shot taken..");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
