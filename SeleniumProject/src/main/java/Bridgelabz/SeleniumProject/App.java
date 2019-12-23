package Bridgelabz.SeleniumProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        System.setProperty("webdriver.gecko.driver",
                "//home/bridgeit/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
     WebDriver driver = new FirefoxDriver();
 driver.get("http://www.google.com"); 
 driver.manage().window().maximize();
System.out.println( "the class of the page is.. "+driver.getClass());
 String title=driver.getTitle();
 System.out.println("the title of the page is.. "+title);
 Thread.sleep(2000);
 WebElement element=driver.findElement(By.name("q"));
 element.sendKeys("selenium.dev");
 element.submit();
 
 Thread.sleep(5000);
 TakesScreenshot ts=(TakesScreenshot)driver;
 File source=ts.getScreenshotAs(OutputType.FILE);
 File destfile=new File(".//screenshots/scrshot.png");
 FileUtils.copyFile(source, destfile);
 
 driver.navigate().to("http://docs.google.com");
 Thread.sleep(4000);
// driver.navigate().back();
// Thread.sleep(4000);
// driver.navigate().forward();
// Thread.sleep(4000);
 driver.close();
 
 
 
    }
}
