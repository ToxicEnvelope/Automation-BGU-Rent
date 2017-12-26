package il.co.bgurent.BGU_Rent_App.core.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import il.co.bgurent.BGU_Rent_App.core.BasePage;

public class LoginPage extends BasePage {
	
	// PageFactory Pattern
	@FindBy(css="input#email.form-control")
	WebElement _usernameField;
	@FindBy(css="input#password.form-control")
	WebElement _passwordField;
	@FindBy(css="button.btn.btn-primary")
	WebElement _loginBtn;
	//--- Non-Factorial WebElements --//
	WebElement _loader;
	WebElement _helpBlock;
	
	// CONSTRUCTOR
	public LoginPage(WebDriver driver) {
		super(driver);
		identifyElements();
	}
	
	// Element Initializer
	private void identifyElements() {
		try {
			this._usernameField = waitUntilElementLocatedByCSS("input#email.form-control");
			if(_usernameField.isDisplayed()) {
				System.out.println("[usernameField] : " + _usernameField);
			}
			this._passwordField = waitUntilElementLocatedByCSS("input#password.form-control");
			if(_passwordField.isDisplayed()) {
				System.out.println("[passwordField] : " + _passwordField);		
			}
			this._loginBtn = waitUntilElementLocatedByCSS("button.btn.btn-primary");
			if(_loginBtn.isDisplayed()) {
				System.out.println("[loginBtn] : " + _loginBtn);
			}
		}	
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Attempt to authenticate with BUG Rent Login Form
	public boolean attemptToAuthenticate(String user, String passwd) {
		try {
			fillText(_usernameField, user);
			fillText(_passwordField, passwd);
			click(_loginBtn);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Check if the loader is displayed
	public boolean isLoaderDisplayed() {
		try {
			do
			{
				if(!_loader.isDisplayed()) {
					this._loader = waitUntilElementPresenceByCSS("ui-view#wrap loader > i");
				}
				System.out.println("[loader] : " + _loader);
			} while(_loader.isDisplayed());
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Check for help-block message displayed
	public boolean isHelpBlockMSGDisplayed() {
		try {
			this._helpBlock = waitUntilElementPresenceByCSS("div.has-error > div > span");
			if(_helpBlock.isDisplayed()) {
				System.out.println("\n[helpBlock] : " + _helpBlock
								 + "\n[text : " + _helpBlock.getText() + "]");
				return true;
			}
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
