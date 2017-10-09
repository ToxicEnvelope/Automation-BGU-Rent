package il.co.bgurent.pageobject;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	// FIELDS
	WebDriver _driver;
	JavascriptExecutor _js;
	TakesScreenshot snapShot;
	
	// CONSTRUCTOR
	public BasePage(WebDriver driver) {
		try {
			if(driver != null) {
				this._driver = driver;
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
		return snapShot;
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
				this._js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", element);
				element.click();
				wait(2500);
				takeSnapShot();
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// Fill text 
	public void fillText(WebElement element, String keyword) {
		try {
			if(element != null && keyword != "") {
				if(element.getText().isEmpty()) {
					this._js = (JavascriptExecutor) _driver;
					this._js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green;');", element);
					element.sendKeys(keyword);
					wait(2500);
					takeSnapShot();
				}
				else {
					this._js = (JavascriptExecutor) _driver;
					this._js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green;');", element);
					element.clear();
					element.sendKeys(keyword);
					wait(2500);
					takeSnapShot();
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// Take Screen Shot
	public void takeSnapShot() {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) _driver).getScreenshotAs(OutputType.FILE);
		try {
			Calendar c = Calendar.getInstance();
			Date suffix = c.getTime();
			FileUtils.copyFile(src, new File("./ScreenShots/"+suffix+".png"));
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
			FileUtils.copyFile(src, new File("./ScreenShots/"+tcerr+suffix+".png"));
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	// Waits until an element is located By.id
	public boolean waitUntilElementLocatedByID(String idAttribute) {
		try {
			if(idAttribute != null) {
				 WebDriverWait wait = new WebDriverWait(this._driver, 10);				 
				 return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(idAttribute)));
			}
			return false;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	// Waits until an element is located By.className
	public boolean waitUntilElementLocatedByClassName(String clsAttribute) {
		try {
			if(clsAttribute != null) {
				 WebDriverWait wait = new WebDriverWait(this._driver, 10);				 
				 return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(clsAttribute)));
			}
			return false;	
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	// Waits until an element is located By.xpath
	public boolean waitUntilElementLocatedByXPath(String xpath) {
		try {
			if(xpath != null) {
				 WebDriverWait wait = new WebDriverWait(this._driver, 10);				 
				 return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
			}
			return false;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	// Implicite wait to handle webdriver timeouts
	public void wait(int mSeconds) {
		try {
			if(mSeconds < 0) {
				this._driver.manage().timeouts().implicitlyWait(mSeconds, TimeUnit.MILLISECONDS);
			}
			else {
				this._driver.manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// -- EOF -- //
}
