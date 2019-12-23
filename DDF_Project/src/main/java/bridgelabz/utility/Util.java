package bridgelabz.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Util {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"//home/bridgeit/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://fundoopush-dev.bridgelabz.com/login");
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("suhas.mhatre@bridgelabz.com");
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("suhas");
		driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
		Thread.sleep(5000);
		System.out.println("Page title is.. " + driver.getTitle());

	}

}
