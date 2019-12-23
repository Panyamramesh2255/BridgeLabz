package com.keyword.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.keyword.base.BaseClass;

/**
 * purpose: Resource class
 * 
 * @author PanyamEamesh
 *
 */
public class ReadFromXLS extends BaseClass {
	public static BaseClass base;
	public static WebDriver driver;
	public Properties property;
	public static Workbook book;
	public static Sheet sheet;
	public final String filepath = "/home/bridgeit/eclipse-workspace/keyworddriven_framework/keyword_driven_file.xlsx";
	String locatorName;
	String locatorVlaue;
	public WebElement element;

	@Test
	public void main() throws InterruptedException {
		ReadFromXLS object = new ReadFromXLS();
		System.out.println(object.toString());
		driver = web_Driver_Init("chrome");
		object.readXLS("data");
	}

	/**
	 * purpose: Reading DATA from xls file
	 * 
	 * @param sheetName
	 * @throws InterruptedException 
	 */

	public void readXLS(String sheetName) throws InterruptedException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		System.out.println("last row number.. " + sheet.getLastRowNum());
		/**
		 * purpose: loop to repeatedly getting data from XLS file
		 */
		for (int i = 0; i < 6; i++) {
			int k = 0;

			locatorName = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
			System.out.println("locator name " + locatorName + " " + (i + 1));

			locatorVlaue = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
			System.out.println("locator value  " + locatorVlaue + " " + (i + 1));

			String action = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
			String value = sheet.getRow(i + 1).getCell(k + 4).toString().trim();
			System.out.println("action.. " + action);
			System.out.println("value.. " + value);

			switch (action) {
			case "Open Browser":
				base = new BaseClass();
				if (value.contains("NA") || value.isEmpty()) {
					property = new Properties();
					driver = base.web_Driver_Init(property.getProperty("browser"));
				} else {
					driver = base.web_Driver_Init(value);
				}

				break;
			case "EnterURL":
				if (value.contains("NA") || value.isEmpty())
					driver.get(property.getProperty("baseURL"));
				driver.get(value);

				break;
			case "quit":
				driver.quit();
				break;

			default:
				break;
			}
			switch (locatorName) {
			case "id":
				element = driver.findElement(By.id(locatorVlaue));
				if (action.equalsIgnoreCase("sendkeys")) {
					element.clear();
					element.sendKeys(value);
				} else if (action.equalsIgnoreCase("click")) {
					element.click();
				}
				locatorName = null;

				break;
			case "linktext":
				element = driver.findElement(By.linkText(locatorVlaue));
				element.click();
				locatorName = null;
				break;
			case "xpath":
				System.out.println("in the xpth case " + locatorVlaue);
				element = driver.findElement(By.xpath(locatorVlaue));
				if (action.equalsIgnoreCase("sendkeys")) {
					element.clear();
					element.sendKeys(value);
				} else if (action.equalsIgnoreCase("click")) {
				element.click();
				Thread.sleep(4000);
				}
				locatorName = null;

				break;
			default:
				break;
			}

		}

	}

	}
