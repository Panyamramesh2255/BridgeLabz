package bridgelabz.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * purpose: implementing object repository for registration page
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

	@FindBy(xpath = "//a[@class='js-nav EdgeButton EdgeButton--medium EdgeButton--primary StaticLoggedOutHomePage-buttonSignup']")
	WebElement signInButton;
	// @FindBy(xpath =
	// "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/label[1]/div[2]/div[1]/input[1]")
	@FindBy(css = "div.css-1dbjc4n.r-13awgt0.r-12vffkv div.css-1dbjc4n.r-13awgt0.r-12vffkv div.css-1dbjc4n.r-1pi2tsx.r-13qz1uu.r-417010 main.css-1dbjc4n.r-16y2uox.r-1wbh5a2 div.css-1dbjc4n.r-150rngu.r-16y2uox.r-1wbh5a2 div.css-1dbjc4n.r-14lw9ot.r-16y2uox.r-1wbh5a2 div.css-1dbjc4n.r-1pz39u2.r-16y2uox.r-1wbh5a2 div.css-1dbjc4n.r-6koalj.r-16y2uox:nth-child(2) div.css-1dbjc4n.r-16y2uox.r-1jgb5lz.r-13qz1uu:nth-child(2) div.css-1dbjc4n.r-xx1rs6 div.css-1dbjc4n.r-mk0yit.r-1w50u8q:nth-child(2) label.css-1dbjc4n.r-1u4rsef.r-rull8r.r-wgabs5.r-1awa8pu.r-1jkafct:nth-child(1) div.css-1dbjc4n.r-18u37iz.r-16y2uox.r-1wbh5a2.r-1udh08x div.css-901oao.r-1awozwy.r-k200y.r-hkyrab.r-6koalj.r-1qd0xha.r-1b6yd1w.r-16dba41.r-ad9z0x.r-bcqeeo.r-13qz1uu.r-qvutc0 > input.r-30o5oe.r-1niwhzg.r-17gur6a.r-1yadl64.r-deolkf.r-homxoj.r-poiln3.r-7cikom.r-1ny4l3l.r-1inuy60.r-utggzx.r-vmopo1.r-1w50u8q.r-1lrr6ok.r-1dz5y72.r-1ttztb7.r-13qz1uu\n")
	WebElement userNameField;
	@FindBy(xpath = "//input[@name='phone_number']")
	WebElement phoneNumber;
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextButton;
	@FindBy(xpath = "div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-vw2c0b r-1777fci r-eljoum r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0']")
	WebElement signUpButton;
	@FindBy(xpath = "//div[@class='css-18t94o4 css-1dbjc4n r-urgr8i r-42olwf r-sdzlij r-1phboty r-rs99b7 r-16y2uox r-1w2pmg r-1vuscfd r-1dhvaqw r-1fneopy r-o7ynqc r-6416eg r-lrvibr']//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-vw2c0b r-1777fci r-eljoum r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0']")
	WebElement okButton;
//    @FindBy(xpath = "//input[@id='ap_password']")
//	WebElement passwordField;
//	@FindBy(xpath = "//input[@id='continue']")
//	WebElement continueButton;

	public void setUserName(String name) {
		userNameField.sendKeys(name);
	}

	public void clicksignINButton() {
		signInButton.click();
	}

	public void clickNextButton() {
		nextButton.click();
	}

	public void setPhonenumber(String phonenumber) {
		phoneNumber.sendKeys(phonenumber);
	}

	public void clickOkButton() {
		okButton.click();
	}

	public void clickSignUpButton() {
		signInButton.click();
	}
}
