package bridgelabz.handlingopt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * purpose: class for OTP handing feature using twitter
 * 
 * @author PanyamRamesh
 *
 */
public class PaytmOtp {
	public WebDriver driver;

	/**
	 * purpose: Execution start here
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		PaytmOtp object = new PaytmOtp();
		object.handlingOtp();
	}

	/**
	 * purpose: implementing otp handling for twitter
	 * 
	 * @throws InterruptedException
	 */
	public void handlingOtp() throws InterruptedException {
		PaytmOtp object = new PaytmOtp();
		object.prereqities();

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("panyam");
		// System.out.println(firstName);
		// firstName.sendKeys("panyam");
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.sendKeys("ramesh");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("panyamramesg32454");
		//
		WebElement password = driver.findElement(By.xpath("//input[@name='Passwd']"));
		password.sendKeys("181135198@Ramesh");
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@name='ConfirmPasswd']"));
		confirmpassword.sendKeys("181135198@Ramesh");
		Thread.sleep(4000);
		//
		WebElement dropdown = driver.findElement(By.xpath("//div[@class='e2CuFe eU809d']"));
		dropdown.sendKeys("181135198@Ramesh");
		WebElement countrySelection = driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed qs41qe']//div[227]"));
		countrySelection.sendKeys("181135198@Ramesh");
		WebElement phonenumber = driver.findElement(By.xpath("//input[@id='phoneNumberId']"));
		confirmpassword.sendKeys("2564748171");
		//
	}

	/**
	 * purpose: implementing Basic setup
	 */
	public void prereqities() {
		System.setProperty("webdriver.chrome.driver", "/home/bridgeit/Downloads/chromedriver_linux64/chromedriver");
		String url = "https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default&gmb=exp&biz=true&flowName=GlifWebSignIn&flowEntry=SignUp";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get(url);
		driver.manage().window().maximize();
	}

}