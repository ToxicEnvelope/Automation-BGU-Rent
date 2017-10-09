package il.co.bgurent.pageobject;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	// FIEDLS
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
	List<WebElement> formElementsList = new ArrayList<WebElement>();
	// Footer //
	WebElement footer;
	WebElement footerContentRight;
	List<WebElement> footerContentLeft = new ArrayList<WebElement>();

	// CONSTRUCTOR
	public LoginPage(WebDriver driver) {
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
		this.formElementsList =
				driver.findElement(By.xpath("//form[@name='login']"))
					         .findElement(By.cssSelector("fieldset"))
							 .findElements(By.className("form-group"));
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
}