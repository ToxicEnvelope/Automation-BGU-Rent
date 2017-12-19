package il.co.bgurent.BGU_Rent_App.core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Mapper {

	static Properties properties;

	public Mapper(String FilePath) {
		try {
			FileInputStream Locator = new FileInputStream(FilePath);
			properties = new Properties();
			properties.load(Locator);
		} 
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	// GETTERS as public
	// Return WebDriver object given a passed String
	public static WebDriver getDriver(String driverType) throws Exception {
		// Check for NULL
		if(driverType != null) {
			switch(driverType.toLowerCase()) {
			// CHROME case
			case "chrome":
				System.setProperty(Mapper.getData("CHROME_ENGINE"), Mapper.getData("CHROME_WDPATH"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito --start-maximized");
				return new ChromeDriver(options);
			// default
			default:
				System.setProperty(Mapper.getData("CHROME_ENGINE"), Mapper.getData("CHROME_WDPATH"));
				ChromeOptions opts = new ChromeOptions();
				opts.addArguments("--incognito --start-maximized");
				return new ChromeDriver(opts);
			}
		}
		return null;
	}
	// Return String object from properties file given an element name
	public static String getData(String elementName) throws Exception {
		// Read value using the logical name as Key
		String data = properties.getProperty(elementName);
		return data;
	}
	// Return By object locator from properties file given element name
	public static By getLocator(String ElementName) throws Exception {
		// Read value using the logical name as Key
		String locator = properties.getProperty(ElementName);
		// Split the value which contains locator type and locator value
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		// Return an instance of By class based on type of locator
		if (locatorType.toLowerCase().equals("id")) {
			return By.id(locatorValue);
		}
		else if (locatorType.toLowerCase().equals("name")) {
			return By.name(locatorValue);
		}
		else if ((locatorType.toLowerCase().equals("classname")) 
				 || (locatorType.toLowerCase().equals("class"))) {
			return By.className(locatorValue);
		}
		else if ((locatorType.toLowerCase().equals("tagname"))
				 || (locatorType.toLowerCase().equals("tag"))) {
			return By.className(locatorValue);
		}
		else if ((locatorType.toLowerCase().equals("linktext"))
		 		 || (locatorType.toLowerCase().equals("link"))) {
			return By.linkText(locatorValue);
		}
		else if (locatorType.toLowerCase().equals("partiallinktext")) {
			return By.partialLinkText(locatorValue);
		}
		else if ((locatorType.toLowerCase().equals("cssselector"))
				     || (locatorType.toLowerCase().equals("css"))) {
			return By.cssSelector(locatorValue);
		}
		else if (locatorType.toLowerCase().equals("xpath")) {
			return By.xpath(locatorValue);
		}
		else {
			throw new Exception("Locator type '" + locatorType
					+ "' not defined!!");
		}
	}
}
