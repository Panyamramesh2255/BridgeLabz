package bridgelabz.handlingopt;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HashMap {
	public static WebDriver driver;

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
	@Test(dataProvider = "hashMapData")
	public void fbLogin(String[] userDetails)
	{
		System.out.println("UN usename: "+userDetails[0]);
		//System.out.println("PW password: "+userDetails[1]);
		WebElement userNameField=driver.findElement(By.id("email"));
		userNameField.sendKeys(userDetails[0]);
		WebElement passwordField=driver.findElement(By.id("pass"));
		passwordField.sendKeys(userDetails[0]);
		WebElement loginButton=driver.findElement(By.id("loginbutton"));
		loginButton.click();
		
		
	}
	@DataProvider(name = "hashMapData")
	public String[] hashmapReading()
	{
		java.util.HashMap<String, String>hashMap=new java.util.HashMap<String, String>();
		hashMap.put("user1", "ramesh2255141@gmail.com_181135198");
		String userDetails[]=hashMap.get("user1").split("_");
		System.out.println("From hash fn:");
		System.out.println("UN: "+userDetails[0]);
		System.out.println("PW: "+userDetails[1]);
		return userDetails;
		
	}

	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
