package il.co.bgurent.utils.pageobject;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

	// FIEDLS
	// Loader
	@FindBy(css="i.welcome-load.loader")
	WebElement mainLoader;
	@FindBy(css="label")
	WebElement loaderLabel;
	// Top nav-bar-right //
	// Login
	@FindBy(xpath="//*/a[@ui-sref='home.login']")
	WebElement loginView;
	// Regiter
	@FindBy(xpath="//*/a[@ui-sref='home.register']")
	WebElement registerView;
	// Top nav-bar //
	// Profile button
	@FindBy(xpath="//*/a[@ng-if='$ctrl.isConnected']")
	WebElement profileBtn;
	// Profile dropdown pannel
	List<WebElement> profilePannel = new ArrayList<WebElement>();
	// Language button
	@FindBy(css="a.dropdown-toggle")
	WebElement langBox;
	// Language dropdown pannel
	List<WebElement> langControl = new ArrayList<WebElement>();
	// Favorite page view
	@FindBy(xpath="//*/a[@ui-sref='home.favorites']")
	WebElement favoritesView;
	// Contact page view
	@FindBy(xpath="//*/a[@ui-sref='home.contact']")
	WebElement contactUsView;
	// About page view
	@FindBy(xpath="//*/a[@ui-sref='home.about']")
	WebElement aboutView;
	// Home page view
	@FindBy(css="a.navbar-brand")
	WebElement mainView;	
	List<WebElement> formElementsList = new ArrayList<WebElement>();
	// Footer //
	@FindBy(css="footer>div.footer-block.frame-width")
	WebElement footer;
	@FindBy(css="right")
	WebElement footerContentRight;
	List<WebElement> footerContentLeft = new ArrayList<WebElement>();

	// CONSTRUCTOR
	public LoginPage(WebDriver driver) {
		super(driver);
	
		this.profilePannel =
				 driver.findElement(By.className("dropdown-menu"))
				 			   .findElements(By.cssSelector("li"));
		this.langControl =
				 driver.findElement(By.cssSelector("ul.dropdown-menu"))
	   				  			    .findElements(By.cssSelector("li"));
		this.formElementsList =
				driver.findElement(By.xpath("//form[@name='login']"))
				         		.findElement(By.cssSelector("fieldset"))
							 		.findElements(By.className("form-group"));
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
