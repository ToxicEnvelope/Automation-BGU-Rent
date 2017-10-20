package il.co.bgurent.utils.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class UIMap {

	static Properties properties;

	public UIMap(String FilePath) {
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
				System.setProperty(UIMap.getData("CHROME_ENGINE"), UIMap.getData("CHROME_WDPATH"));
				ChromeOptions chOptions = new ChromeOptions();
				chOptions.addArguments("--incognito");
				return new ChromeDriver(chOptions);
			// .....
			case "firefox":
				System.setProperty(UIMap.getData("FIREFOX_ENGINE"), UIMap.getData("FIREFOX_WDPATH"));
				FirefoxOptions ffOptions = new FirefoxOptions();
				ffOptions.addArguments("--incognito");
				return new FirefoxDriver(ffOptions);
			// .....
			case "safari":
				System.setProperty(UIMap.getData("SAFARI_ENGINE"), UIMap.getData("SAFARI_WDPATH"));
				return new SafariDriver();
			// .....
			case "ie":
				System.setProperty(UIMap.getData("IE_ENGINE"), UIMap.getData("IE_WDPATH"));
				return new InternetExplorerDriver();
			// default
			default:
				System.setProperty(UIMap.getData("CHROME_ENGINE"), UIMap.getData("CHROME_WDPATH"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				return new ChromeDriver(options);
			}
		}
		return null;
	}
	// Return String object from properties file given an element name
	public static String getData(String ElementName) throws Exception {
		// Read value using the logical name as Key
		String data = properties.getProperty(ElementName);
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