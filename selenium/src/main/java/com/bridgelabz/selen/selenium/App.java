package com.bridgelabz.selen.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.setProperty("webdriver.gecko.driver",
                "/home/bridgeit/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
     WebDriver driver = new ChromeDriver();
 driver.get("www.google.com");
    }
}
