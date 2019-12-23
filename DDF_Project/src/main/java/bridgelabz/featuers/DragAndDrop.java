package bridgelabz.featuers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DragAndDrop {
	public static WebDriver driver;

	public static void main(String[] args) {
		DragAndDrop dnd = new DragAndDrop();
		dnd.openBrowser();
	}

	/**
	 * purpose: performing drag and drop operation
	 */
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/home/bridgeit/Downloads/chromedriver_linux64/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);

		Actions action = new Actions(driver);

		action.clickAndHold(driver.findElement(By.xpath("/html[1]/body[1]/div[1]")))
				.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[2]"))).release().build().perform();

	}
}
