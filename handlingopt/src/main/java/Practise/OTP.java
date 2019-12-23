package Practise;

import java.util.stream.StreamSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class OTP {
	public static final String ACCOUNT_SID = "AC7f9fbeab19b90924e1f87af8b174524d";
	public static final String AUTH_token = "686d9927c64d81a313f44fad48ceb571";

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/home/bridgeit/Downloads/chromedriver_linux64/chromedriver");
		String url = "https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default&gmb=exp&biz=true&flowName=GlifWebSignIn&flowEntry=SignUp";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get(url);
		driver.manage().window().maximize();

		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		// System.out.println(firstName);
		firstName.sendKeys("panyam");
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.sendKeys("ramesh");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("panyamramesg32454");
		//
		WebElement password = driver.findElement(By.xpath("//input[@name='Passwd']"));
		password.sendKeys("181135198@Ramesh");
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@name='ConfirmPasswd']"));
		confirmpassword.sendKeys("181135198@Ramesh");
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		Thread.sleep(4000);
		// body.EIlDfe:nth-child(2) div.uc81Ff.wKBl8c.bbRbR.RELBvb:nth-child(1)
		// div.LJtPoc.qmmlRd div.bdf4dc.nnGvjf div.slptg div.JhUD8d.SQNfcc
		// form.RFjuSb.bxPAYd.k6Zj8d div.mbekbe.bxPAYd:nth-child(2)
		// div.iUe6Pd.Us7fWe.JhUD8d div.lqByzd.OcVpRe div.qqYQWe.G2JKS
		// div.r5iSrd.vjc9od.lPGq1c.Axoxm div.jgvuAb.mAW2Ib.e5Emjc.iWO5td
		// div.OA0qNb.ncFHed.qs41qe:nth-child(2) div.MocG8c.aCjZuc.LMgvRb:nth-child(227)
		// > span.vRMGwf.oJeWuf

		// WebElement dropdown= driver.findElement(By.xpath("//div[@class='e2CuFe
		// eU809d']"));
		// dropdown.click();
		// Thread.sleep(2000);
		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.elementToBeClickable(By.xpath("body.EIlDfe:nth-child(2)
		// div.uc81Ff.wKBl8c.bbRbR.RELBvb:nth-child(1) div.LJtPoc.qmmlRd
		// div.bdf4dc.nnGvjf div.slptg div.JhUD8d.SQNfcc form.RFjuSb.bxPAYd.k6Zj8d
		// div.mbekbe.bxPAYd:nth-child(2) div.iUe6Pd.Us7fWe.JhUD8d div.lqByzd.OcVpRe
		// div.qqYQWe.G2JKS div.r5iSrd.vjc9od.lPGq1c.Axoxm
		// div.jgvuAb.mAW2Ib.e5Emjc.iWO5td div.OA0qNb.ncFHed.qs41qe:nth-child(2)
		// div.MocG8c.aCjZuc.LMgvRb:nth-child(227) > span.vRMGwf.oJeWuf\n"))).click();

		// WebElement countrySelection=
		// driver.findElement(By.xpath("//div[@class='MocG8c aCjZuc
		// LMgvRb']//span[@class='vRMGwf oJeWuf'][contains(text(),'United States')]"));
		// countrySelection.click();
		WebElement phonenumber = driver.findElement(By.xpath("//input[@id='phoneNumberId']"));
		phonenumber.sendKeys("+12564748171");
		//
		WebElement nextButton = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
		nextButton.click();
		Twilio.init(ACCOUNT_SID, AUTH_token);
		String otp = getMessage();
		System.out.println("OTP..: " + otp);
		otp.replace("[^_?0-9]+1", " ");
		WebElement otpTextField = driver.findElement(By.id("auth-pv-enter-code"));
		otpTextField.sendKeys(otp);
		WebElement createAmazonAccount = driver.findElement(By.id("auth-verify-button"));
		createAmazonAccount.click();

	}

	public static String getMessage() {
		return ((java.util.stream.Stream<Message>) getMessages())
				.filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().equals("+12564748171")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	private static java.util.stream.Stream<Message> getMessages() {
		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}

}
