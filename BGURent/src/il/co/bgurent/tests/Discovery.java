package il.co.bgurent.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import il.co.bgurent.pageobject.MainPage;

public class Discovery {

	// FIELDS
	WebDriver driver;
	
	final String baseUrl = "http://www.bgurent.co.il";
 
	
	// Before the tests are running
	@BeforeClass
	public void setUp() {
		// Instance str objects related to ChromeDriver
		String engine, wdPath;
		// Chrome Engine
		engine = "webdriver.chrome.driver";
		// chromedriver application path
		wdPath = "ABSOLUTE_PATH_TO_THIS_DIRECTORY/BGURent/libs/Drivers/chromedriver";
		// Set chromedriver properties
		System.setProperty(engine, wdPath);
		// Instanciate options to chromedriver
		ChromeOptions options = new ChromeOptions();
		// Set incognito && fullscreen mode enabled
		options.addArguments("--incognito");
		// Instanciate a driver with the options above
		driver = new ChromeDriver(options);
		// Go to "http://www.bgurent.co.il"
		driver.get(baseUrl);
		// Wait for page to load , interval is 2.5 seconds
		driver.manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS);
	}
	
	// After the tests are running
	@AfterClass 
	public void tearDown() {
		// Check for null
		if(driver != null) {
			// Delete all cookies and quit teh browser
			driver.manage().deleteAllCookies();
			// Close broswer
			driver.quit();
		}
	}
	
	@Test
	public void E2E_Test1() {
		MainPage mainPage = new MainPage(driver);
		mainPage.isLoaderDispayed();
	}
}
