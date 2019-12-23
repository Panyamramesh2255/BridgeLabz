package bridgelabz.handlingopt;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadingPdf {
	WebDriver driver;

	// @BeforeTest
	// public void setup()
//	{
//		System.setProperty("webdriver.chrome.driver", "/home/bridgeit/Downloads/chromedriver_linux64/chromedriver");
//		String url = "file:///home/bridgeit/Documents/Selenium%20Jars/pdf-test.pdf";
//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		driver = new ChromeDriver(capabilities);
//		driver.get(url);
//		driver.manage().window().maximize();
//	}
	@Test
	public void readingPdf() throws IOException {
		URL url = new URL("file:///home/bridgeit/Documents/Selenium%20Jars/pdf-test.pdf");
		InputStream inputStream = url.openStream();
		BufferedInputStream bufferInputStream = new BufferedInputStream(inputStream);
		PDDocument pdf = null;
		pdf = PDDocument.load(bufferInputStream);
		String pdfContent = new PDFTextStripper().getText(pdf);
		System.out.println(pdfContent);
		Assert.assertEquals(pdfContent.contains("Congratulations, your computer is equipped with a PDF"), true);

	}

//	@AfterTest  
//	public void quit()
//	{
//		driver.quit();
//	}

}
