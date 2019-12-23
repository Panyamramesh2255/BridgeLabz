package com.bridgelabz.keyworddriven.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * purpose: Object Repository for Home Page
 * @author PanyamRamesh
 *
 */
public class HomePageObjectives {
	
	Robot robot=new Robot();
	WebDriver driver;
     public HomePageObjectives(WebDriver rdriver)throws AWTException  {
	
		driver=rdriver;
		PageFactory.initElements(rdriver, null);
	}
	
	
	
	
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
	

	public void clickaddCtaButton() {
		addCtaButton.click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_K);
		robot.keyRelease(KeyEvent.VK_K);
		robot.keyRelease(KeyEvent.VK_CONTROL);
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
	public void clickUploadArticleButton()
	{
		uploadArticleButton.click();
	}


}
