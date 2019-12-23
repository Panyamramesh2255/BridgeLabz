package bridgelabz.testcases;

import java.awt.AWTException;
import java.util.stream.StreamSupport;

import org.apache.http.util.Asserts;
import org.testng.annotations.Test;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import bridgelabz.base.BaseClass;
import bridgelabz.pageobjects.RegistrationPage;

/**
 * 
 * @author PanyamRamesh purpose: implementing registration page test scripts
 *
 */
public class RegistrationTestCases extends BaseClass {
	public static final String ACCOUNT_SID = "AC7f9fbeab19b90924e1f87af8b174524d";
	public static final String AUTH_token = "686d9927c64d81a313f44fad48ceb571";

	/**
	 * purpose:implementing Registration page web elements and method to perform
	 * actions on that web elements
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	@Test
	public void testRegistration() throws AWTException, InterruptedException {
		RegistrationPage robject = new RegistrationPage(driver);
		robject.setUserName("panyam");
		Thread.sleep(1000);
		robject.clickDropDwonButton();
		Thread.sleep(1000);
		robject.clickUSCountryCode();
		Thread.sleep(1000);
		robject.setPhonenumber("2564748171");
		Thread.sleep(1000);
		robject.setPassword("panyam@123");
		Thread.sleep(1000);
		robject.clickContinueButton();
		Thread.sleep(2000);
		Twilio.init(ACCOUNT_SID, AUTH_token);
		String otp = getMessage();
		// System.out.println("otp is: "+otp);
		otp.replace("[^_?0-9]+", " ");
		System.out.println("opt is: " + otp);
		robject.sendOTP(otp);
		Thread.sleep(5000);
	}

	/**
	 * purpose: implemnting API's to get OTP from twilio otp
	 * 
	 * @return
	 */
	public static String getMessage() {
		return (String) ((java.util.stream.Stream<Message>) getMessages())
				.filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().equals("+12564748171")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	/**
	 * purpose: getting OTP from twilio
	 * 
	 * @return
	 */
	private static java.util.stream.Stream<Message> getMessages() {
		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}
	// Asserts.asssserEquals("", "");

}
