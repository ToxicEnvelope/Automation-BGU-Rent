package il.co.bgurent.pageobject;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends BasePage {

	// FILEDS
	private boolean isPresent = false;
	// Loader
	WebElement mainLoader;
	WebElement loaderLabel;
	// Top nav-bar-right //
	// Login
	WebElement loginView;
	// Regiter
	WebElement registerView;
	// Top nav-bar //
	// Profile button
	WebElement profileBtn;
	// Profile dropdown pannel
	List<WebElement> profilePannel = new ArrayList<WebElement>();
	// Language button
	WebElement langBox;
	// Language dropdown pannel
	List<WebElement> langControl = new ArrayList<WebElement>();
	// Favorite page view
	WebElement favoritesView;
	// Contact page view
	WebElement contactUsView;
	// About page view
	WebElement aboutView;
	// Home page view
	WebElement mainView;										
	// Inner Page top-pannel //
	// Add new apartment button
	WebElement addNewApt;
	// Rent per month field
	WebElement rentPerMonth;
	// Total rooms field
	WebElement totalRooms;
	// Select list neighborhood type
	Select hoodType;
	// Search button
	WebElement searchBtn;
	// Advance search button
	WebElement showAdvance;
	// Main content wrap // 
	// Content wrap
	List<WebElement> contentWrapper = new ArrayList<WebElement>();
	// Footer //
	WebElement footer;
	WebElement footerContentRight;
	List<WebElement> footerContentLeft = new ArrayList<WebElement>();
	
	// CONSTRUCTOR
	public MainPage(WebDriver driver) {
		super(driver);
		this.mainLoader = 
				 driver.findElement(By.cssSelector("i.welcome-load.loader"));
		this.loaderLabel = 
				mainLoader.findElement(By.cssSelector("label"));
		this.loginView = 
				 driver.findElement(By.xpath("//*/a[@ui-sref='home.login']"));
		this.registerView = 
				 driver.findElement(By.xpath("//*/a[@ui-sref='home.register']"));
		this.profileBtn = 
				 driver.findElement(By.xpath("//*/a[@ng-if='$ctrl.isConnected']"));
		this.profilePannel =
				 driver.findElement(By.className("dropdown-menu"))
				 			   .findElements(By.cssSelector("li"));
		this.langBox = 
				 driver.findElement(By.cssSelector("a.dropdown-toggle"));
		this.langControl =
				 driver.findElement(By.cssSelector("ul.dropdown-menu"))
	   				  			    .findElements(By.cssSelector("li"));
		this.favoritesView =
				 driver.findElement(By.xpath("//*/a[@ui-sref='home.favorites']"));
		this.contactUsView = 
				 driver.findElement(By.xpath("//*/a[@ui-sref='home.contact']"));
		this.aboutView = 
				 driver.findElement(By.xpath("//*/a[@ui-sref='home.about']"));
		this.mainView = 
				 driver.findElement(By.cssSelector("a.navbar-brand"));
		this.addNewApt = 
				 driver.findElement(By.xpath("//*/a[@ui-sref='home.addNewApartmet']"));
		this.rentPerMonth = 
				 driver.findElement(By.xpath("//*/a[@ng-model='$ctrl.search.rent']"));
		this.totalRooms = 
				 driver.findElement(By.xpath("//*/a[ng-model='$ctrl.search.rooms']"));
		this.hoodType = 
				 new Select(driver.findElement(By.xpath("//*/a[@ng-model='$ctrl.search.section_id']")));
		this.searchBtn = 
				 driver.findElement(By.xpath("//*/a[ng-model='$ctrl.onSearchClick()']"));
		this.showAdvance = 
				 driver.findElement(By.xpath("//*/a[@ng-model='!$ctrl.showAdvance']"));
		this.contentWrapper = 
				 driver.findElement(By.className("main-content-wrap"))
				 	   					.findElements(By.xpath("//*"));
		this.footer = 
				 driver.findElement(By.cssSelector("footer>div.footer-block.frame-width"));
		this.footerContentRight = 
				 driver.findElement(By.className("right"));
		this.footerContentLeft = 
				 driver.findElement(By.className("left"))
				 	   .findElements(By.cssSelector("a"));
	}
	
	// GETTERS
	public WebElement getMainLoader() {
		return mainLoader;
	}
	public WebElement getLoaderLabel() {
		return loaderLabel;
	}
	public WebElement getLoginView() {
		return loginView;
	}
	public WebElement getRegisterView() {
		return registerView;
	}
	public WebElement getProfileBtn() {
		return profileBtn;
	}
	public List<WebElement> getProfilePannel() {
		return profilePannel;
	}
	public List<WebElement> getLanguageControl() {
		return langControl;
	}
	public WebElement getFavoritesView() {
		return favoritesView;
	}
	public WebElement getContactUsView() {
		return contactUsView;
	}
	public WebElement getAboutView() {
		return aboutView;
	}
	public WebElement getMainView() {
		return mainView;
	}
	public WebElement getAddNewApt() {
		return addNewApt;
	}
	public WebElement getRentPerMonth() {
		return rentPerMonth;
	}
	public WebElement getTotalRooms() {
		return totalRooms;
	}
	public Select getHoodType() {
		return hoodType;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getShowAdvance() {
		return showAdvance;
	}
	public List<WebElement> getContentWrapper() {
		return contentWrapper;
	}
	public WebElement getFooter() {
		return footer;
	}
	public WebElement getFooterContentRight() {
		return footerContentRight;
	}
	public List<WebElement> getFooterContentLeft() {
		return footerContentLeft;
	}
	// PUBLIC METHODS
	public void isLoaderDispayed() {
		Assert.assertTrue(waitUntilElementLocatedByClassName(mainLoader.getAttribute("class")));
		takeSnapShot();
	}
	// Navigate to Login Page View
	public void navToLoginView() {
		try {
			if(loginView.isDisplayed()) {
				click(loginView);
				wait(1500);
			}
			else {
				isPresent = waitUntilElementLocatedByXPath("//*/a[@ui-sref='home.login']");
				if(isPresent) {
					click(loginView);
					wait(1500);
				}
				else {
					takeSnapShot("Login_element_doesn't_exists");
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// Navigate to Register Page View
	public void navToRegisterView() {
		try {
			if(registerView.isDisplayed()) {
				click(registerView);
			}
			else {
				isPresent = waitUntilElementLocatedByXPath("//*/a[@ui-sref='home.register']");
				if(isPresent) {
					click(registerView);
				}
				else {
					takeSnapShot("Register_element_doesn't_exists");
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// Navigate to Main Page
	public void navToMainPage() {
		try {
			if(mainView.isDisplayed()) {
				click(mainView);
				wait(1500);
			}
			else {
				isPresent = waitUntilElementLocatedByXPath("//*/a[@ui-sref='home.main']");
				if(isPresent) {
					click(mainView);
					wait(1500);
				}				
				else {
					takeSnapShot("Home_element_doesn't_exists");
				}
			}
		}
		catch (Exception ex) {
				ex.printStackTrace();
		}
	}
	// Changes Language to Heb
	public void changeLangToHebrew() {
		try {
			if(langBox.isDisplayed()) {
				click(langBox);
				if(langControl != null) {
					WebElement elem = langControl.get(0);
					click(elem);
				}
				else {
					takeSnapShot("Languages_elements_doesn't_exists");
				}
			}
			else {
				takeSnapShot("Could_not_switch_to_HEBREW");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	//Changes Language to Eng
	public void changeLangToEnglish() {
		try {
			if(langBox.isDisplayed()) {
				click(langBox);
				if(langControl != null) {
					WebElement elem = langControl.get(1);
					click(elem);
				}
				else {
					takeSnapShot("Languages_elements_doesn't_exists");
				}
			}
			else {
				takeSnapShot("Could_not_switch_to_ENGLISH");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
