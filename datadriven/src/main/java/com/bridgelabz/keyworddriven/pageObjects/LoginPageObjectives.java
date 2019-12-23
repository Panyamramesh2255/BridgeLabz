package com.bridgelabz.keyworddriven.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author PanyamRamesh purpose: implementing login page objectives
 *
 */
public class LoginPageObjectives {
	WebDriver driver;
	Robot robot = new Robot();

	public LoginPageObjectives(WebDriver rDriver) throws AWTException {

		driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	WebElement element = driver.findElement(By.id(""));

	@FindBy(xpath = "//input[@id='mat-input-0']")
	WebElement UserName;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	WebElement Password;

	@FindBy(xpath = "//button[@class='login-button mat-button']")
	WebElement loginButton;

	@FindBy(xpath = "//mat-icon[@class='mat-icon-floating mat-icon material-icons notranslate mat-icon-no-color']")
	WebElement addCtaButton;

	@FindBy(xpath = "//button[contains(text(),'ADD ARTICLE')]")
	WebElement AddArticle;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-add-article-dialog[1]/div[1]/div[1]/div[1]/div[2]/img[1]")
	WebElement AddImageOption;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-add-article-dialog[1]/div[1]/div[1]/div[1]/div[4]/div[1]/textarea[1]")
	WebElement titleField;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-add-article-dialog[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[3]/quill-editor[1]/div[2]/div[1]/p[1]")
	WebElement decriptionfield;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-add-article-dialog[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/img[1]")
	WebElement moreoption;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-add-article-dialog[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[4]/span[1]")
	WebElement redirectButton;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-add-article-dialog[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[2]/mat-form-field[1]/div[1]/div[1]/div[3]/input[1]")
	WebElement redirectlinkTextBox;

	@FindBy(xpath = "//span[@class='mat-button-wrapper']")
	WebElement doneButton;

	@FindBy(xpath = " //i[@class='material-icons save-btn']")
	WebElement uploadArticleButton;

	public void setUserName(String Username) {
		UserName.sendKeys(Username);
	}

	public void setPassword(String password) {
		Password.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickaddCtaButton() {
		addCtaButton.click();
	}

	public void clickAddArticleOption() {
		AddArticle.click();
	}

	public void AddImageOption(String image) {

		AddImageOption.click();
		// AddImageOption.sendKeys(image);
		StringSelection imagepath = new StringSelection(image);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imagepath, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void setTitle(String title) {
		titleField.sendKeys(title);
	}

	public void setDescription(String description) {
		decriptionfield.sendKeys(description);
	}

	public void clickMoreOption() {
		moreoption.click();
	}

	public void clickredirectButton() {
		redirectButton.click();
	}

	public void clickAndPasteRedirectLink(String link) {
		redirectlinkTextBox.click();
		StringSelection linkdata = new StringSelection(link);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(linkdata, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		doneButton.click();
	}

	public void clickUploadArticleButton() {
		uploadArticleButton.click();
	}

}
