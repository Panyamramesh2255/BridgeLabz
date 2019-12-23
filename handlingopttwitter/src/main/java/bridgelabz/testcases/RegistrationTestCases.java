package bridgelabz.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import bridgelabz.base.BaseClass;
import bridgelabz.pageobjects.RegistrationPage;

/**
 * purpose: test scripts
 * 
 * @author PanyamRamesh
 *
 */
public class RegistrationTestCases extends BaseClass {
	/**
	 * purpose: test scripts for registration page
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	@Test
	public void testRegistration() throws AWTException, InterruptedException {
		RegistrationPage robject = new RegistrationPage(driver);
		robject.clicksignINButton();
		Thread.sleep(2000);
		robject.setUserName("panyam");
		Thread.sleep(2000);
		robject.setPhonenumber("12564748171");
		Thread.sleep(2000);
		robject.clickNextButton();
		Thread.sleep(2000);
		robject.clickNextButton();
		Thread.sleep(2000);
		robject.clickSignUpButton();
		Thread.sleep(2000);
		// robject.clickOkButton();
		Thread.sleep(3000);
	}

}
