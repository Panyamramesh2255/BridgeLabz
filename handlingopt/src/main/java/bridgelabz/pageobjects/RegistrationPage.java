package bridgelabz.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * purpose: implementing registration page object repository
 * 
 * @author PanyamRamesh
 *
 */
public class RegistrationPage {
	WebDriver driver;
	Robot robot = new Robot();

	public RegistrationPage(WebDriver rdriver) throws AWTException {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	/**
	 * purpose:implementing Registration page web elements and method to perform
	 * actions on that web elements
	 */
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement userNameField;
	@FindBy(xpath = "//span[@class='a-dropdown-prompt']")
	WebElement countryDropdownButton;
	@FindBy(xpath = "//a[@id='auth-country-picker_212']")
	WebElement usCountrycode;
	@FindBy(xpath = "//input[@id='ap_phone_number']")
	WebElement phoneNumber;
	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement passwordField;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButton;
	@FindBy(xpath = "//input[@id='auth-pv-enter-code']")
	WebElement otpField;
	@FindBy(xpath = "//input[@id='auth-verify-button']")
	WebElement createamazonaccuountButton;

	public void setUserName(String name) {
		userNameField.sendKeys(name);
	}

	public void clickDropDwonButton() {
		countryDropdownButton.click();
	}

	public void clickUSCountryCode() {
		usCountrycode.click();
	}

	public void setPhonenumber(String phonenumber) {
		phoneNumber.sendKeys(phonenumber);
	}

	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickContinueButton() {
		continueButton.click();
	}

	public void sendOTP(String otp) {
		otpField.sendKeys(otp);
	}

	public void clickCreateAccountButton() {
		createamazonaccuountButton.click();
	}
}
