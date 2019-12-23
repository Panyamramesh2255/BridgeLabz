package com.bridgelabz.keyworddriven.testCases;

import java.awt.AWTException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.bridgelabz.keyworddriven.pageObjects.LoginPageObjectives;
import com.bridgelabz.keyworddriven.utility.Util;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 
 * @author PanyamRamesh purpose: implementing test cases
 *
 */
public class TestCases extends BaseClass {
	/**
	 * purpose: Login page test cases
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */

	@Test
	public void logintest() throws InterruptedException, AWTException, IOException {
		Util util = new Util();
		JsonParser parser = new JsonParser();
		FileReader file = new FileReader("/home/bridgeit/eclipse-workspace/datadriven/resourse/data.json");
		Object obj = parser.parse(file);
		JsonObject jsonObject = (JsonObject) obj;
        driver.get(url);
		LoginPageObjectives lpo = new LoginPageObjectives(driver);
		lpo.setUserName(jsonObject.get("UserName").toString().replace("\"", ""));
		lpo.setPassword(jsonObject.get("Password").toString().replace("\"", ""));
		lpo.clickLoginButton();
		Thread.sleep(3000);
		lpo.clickaddCtaButton();
        Thread.sleep(3000);
		lpo.clickAddArticleOption();
		lpo.AddImageOption(jsonObject.get("imagelocation").toString().replace("\"", ""));
        Thread.sleep(1000);
		util.scrolldown(driver);
		Thread.sleep(1000);
		lpo.setTitle(jsonObject.get("title").toString().replace("\"", ""));
		Thread.sleep(1000);
		lpo.setDescription(jsonObject.get("description").toString().replace("\"", ""));
		lpo.clickMoreOption();
        Thread.sleep(2000);
		lpo.clickredirectButton();
		Thread.sleep(2000);
		lpo.clickAndPasteRedirectLink(jsonObject.get("redirectLink").toString().replace("\"", ""));
		Thread.sleep(2000);
		// lpo.clickUploadArticleButton();
		// Thread.sleep(10000);
	}

}
