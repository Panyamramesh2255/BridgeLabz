package com.bridgelabz.keyworddriven.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Util {

	public static void main(String[] args) throws FileNotFoundException {
		JsonParser parser = new JsonParser();
		FileReader file = new FileReader("data.json");
		Object obj = parser.parse(file);
		JsonObject jsonObject = (JsonObject) obj;
		System.out.println("title " + jsonObject.get("title").toString().replace("\"", ""));
	}
	public void takeScreenshots(WebDriver driver) throws IOException
	{
	TakesScreenshot screenShot=(TakesScreenshot)driver;
	File srcfile=screenShot.getScreenshotAs(OutputType.FILE);
	File destfile=new File("/home/bridgeit/eclipse-workspace/datadriven/Screenshots");
	FileUtils.copyFile(srcfile, destfile);
	
	
	}
	public void scrolldown( WebDriver driver)
	{
		JavascriptExecutor jscript=(JavascriptExecutor)driver; {
        jscript.executeScript("window.scrollBy(0,1000)");			
		
	}


}
}
