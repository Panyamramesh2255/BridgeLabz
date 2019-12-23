package bridgelabz.DDF_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * purpose: Login Method
 * 
 * @param username
 * @param password
 * @return
 * @throws InterruptedException
 */

public class Login {
	/**
	 * purpose: test scripts for login page
	 */
	@Test
	public String login(String username, String password) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"//home/bridgeit/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://fundoopush-dev.bridgelabz.com/login");
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);
		driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		if (title.contentEquals(DDFClass.pageTitle))
			return "pass";
		return "fail";

	}

}
