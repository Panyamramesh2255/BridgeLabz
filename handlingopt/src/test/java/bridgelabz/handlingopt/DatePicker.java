package bridgelabz.handlingopt;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DatePicker {
	public WebDriver driver;

	@BeforeTest
	public void basicFunction() {
		System.setProperty("webdriver.chrome.driver", "/home/bridgeit/Downloads/chromedriver_linux64/chromedriver");
		String url = "https://www.phptravels.net/index.php";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test
	public void datePicker() throws InterruptedException {
		String Month = "May";
		String Year = "2020";
		String day = "15";

		WebElement dateField = driver.findElement(By.id("checkin"));
		dateField.click();
		while (true) {
			String text = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/nav[1]/div[2]")).getText();
			String[] date = text.split(",");
			System.out.println("0 " + date[0].trim());
			System.out.println("1 " + date[1].trim());
			boolean status = date[0].trim().contentEquals(Month) && date[1].trim().contentEquals(Year);
			System.out.println(status);
			if (status) {

				break;
			}

			driver.findElement(By.xpath(
					"//body[@class='with-waypoint-sticky']/div[@id='datepickers-container']/div[@class='datepicker -bottom-left- -from-bottom- active']/nav[@class='datepicker--nav']/div[3]/*[1]"))
					.click();
		}
		Thread.sleep(3000);
		WebElement dateElement = driver
				.findElement(By.xpath("//div[@class='datepicker--cell datepicker--cell-day'][contains(text(),'15')]"));
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("arguments[0].scrollIntoView()", dateElement);
		dateElement.click();
		Thread.sleep(5000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
