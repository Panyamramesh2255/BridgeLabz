package bridgelabz.handlingopt;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopupHandling {
	public static WebDriver driver;

	@BeforeTest
	public void basicFunction() {
		System.setProperty("webdriver.chrome.driver", "/home/bridgeit/Downloads/chromedriver_linux64/chromedriver");
		String url = "https://mail.rediff.com/cgi-bin/login.cgi";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test
	public void popupHandling() throws InterruptedException {

		WebElement goButton = driver.findElement(By.name("proceed"));
		goButton.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String popuptext = alert.getText();
		System.out.println("pop message..: " + popuptext);
		alert.accept();
		Thread.sleep(3000);
		Assert.assertEquals(popuptext, "Please enter a valid user name");

		// proceed

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
