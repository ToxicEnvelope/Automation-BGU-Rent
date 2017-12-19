package il.co.bgurent.BGU_Rent_App.core;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

	// FIELDS
	private WebDriver _driver;
	protected JavascriptExecutor _js;
	private TakesScreenshot _snapShot;
	
	// CONSTRUCTOR
	public BasePage(WebDriver driver) {
		try {
			if(driver != null) {
				this._driver = driver;
				PageFactory.initElements(driver, this);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// GETTERS as Protected
	protected WebDriver getDriver() {
		return _driver;
	}
	protected JavascriptExecutor getJSExec() {
		return _js;
	}
	protected TakesScreenshot getScreenShot() {
		return _snapShot;
	}
	// SETTERS as Protected
	protected void setDriver(WebDriver driver) {
		try {
			if(driver != null) {
				this._driver = driver;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	protected void setJSExec(WebDriver driver) {
		try {
			if(this._js == null && driver != null) {
				this._js = (JavascriptExecutor) driver;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// PUBLIC METHODS
	// Click on element
	public void click(WebElement element) {
		try {
			if(element != null && element.isDisplayed()) {
				this._js = (JavascriptExecutor) _driver;
				_js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue');", element);
				element.click();
				wait(1000);
				takeSnapShot();
			}
		}
		catch (WebDriverException e) {
			this._js = (JavascriptExecutor) _driver;
			_js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green');");
			_js.executeScript("arguments[0].click();");
			wait(1000);
			takeSnapShot();
		}
	}
	// Fill text 
	public void fillText(WebElement element, String keyword) {
		try {
			if(element != null && keyword != "") {
				if(element.getText().isEmpty()) {
					this._js = (JavascriptExecutor) _driver;
					_js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green');", element);
					element.sendKeys(keyword);
					wait(1000);
					takeSnapShot();
				}
				else {
					this._js = (JavascriptExecutor) _driver;
					_js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green');", element);
					element.clear();
					element.sendKeys(keyword);
					wait(1000);
					takeSnapShot();
				}
			}
		}
		catch (WebDriverException e) {
			this._js = (JavascriptExecutor) _driver;
			_js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow');");
			_js.executeScript("if(arguments[0].value != null || arguments[0].value != undefined) "
							+ "{ "
								+ "arguments[0].reset(); "
								+ "arguments[0].value="+keyword+"; "
							+ "} else { "
								+ "arguments[0].value="+keyword+"; "
							+ "}");
			wait(1000);
			takeSnapShot();
		}
	}
	// Take Screen Shot
	public void takeSnapShot() {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) _driver).getScreenshotAs(OutputType.FILE);
		try {
			Calendar c = Calendar.getInstance();
			Date suffix = c.getTime();
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/src/ScreenShots/"+suffix+".png"));
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	// Separated Screen Shot when Error accured
	public void takeSnapShot(String tcerr) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) _driver).getScreenshotAs(OutputType.FILE);
		try {
			Calendar c = Calendar.getInstance();
			Date suffix = c.getTime();
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/src/ScreenShots/"+tcerr+suffix+".png"));
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	// Waits until an element is located By.id
	public WebElement waitUntilElementLocatedByID(String idAttribute) {
		try {
			WebDriverWait wait = new WebDriverWait(_driver, 10);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idAttribute)));
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public WebElement waitUntilElementPresenceById(String id) {
		try {
			WebDriverWait wait = new WebDriverWait(_driver, 10);
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	// Waits until an element is located By.className
	public WebElement waitUntilElementLocatedByClassName(String clsAttribute) {
		try {
			WebDriverWait wait = new WebDriverWait(_driver, 10);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(clsAttribute)));
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public WebElement waitUntilElementPresenceByClassName(String cls) {
		try {
			WebDriverWait wait = new WebDriverWait(_driver, 10);
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(cls)));
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	// Waits until an element is located By.xpath
	public WebElement waitUntilElementLocatedByXPath(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(_driver, 10);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public WebElement waitUntilElementPresenceByXPath(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(_driver, 10);
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	// Implicite wait to handle webdriver timeouts
	public void wait(int mSeconds) {
		try {
			Thread.sleep(mSeconds);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// -- EOF -- //
}
