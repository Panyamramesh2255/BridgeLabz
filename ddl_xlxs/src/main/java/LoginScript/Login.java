package LoginScript;

import java.io.IOException;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import bridgelabz.ddl_xlxs.ReadFromXLXS;

/**
 * purpose: implementing test scripts
 * 
 * @author PanyamRamesh
 *
 */
public class Login {
	public static String title = "fundooPush Admin";

	public static void main(String[] args) throws IOException, InterruptedException {
		Login obj = new Login();
		obj.loginScript();
	}

	/**
	 * purpose: login page test scripts
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void loginScript() throws IOException, InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"//home/bridgeit/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://fundoopush-dev.bridgelabz.com/login");

		ReadFromXLXS object = new ReadFromXLXS();
		String[][] dataArray = object.fileproperties();
		for (int i = 0; i < dataArray.length; i++) {
			System.out.println("inside array");
			for (int j = 0; j < dataArray[i].length; j++) {
				driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(dataArray[i][j]);
				driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(dataArray[i][j + 1]);
				driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();

				if (driver.getTitle().contentEquals(title))
					System.out.println("pass");
				else
					System.out.println("fail");
				Thread.sleep(3000);
				System.out.print(dataArray[i][j] + " ");
				System.out.print(dataArray[i][j + 1]);
				// break;

			}
			System.out.println();
		}
	}
}
