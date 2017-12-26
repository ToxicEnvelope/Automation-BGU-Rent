package il.co.bgurent.BGU_Rent_App.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import il.co.bgurent.BGU_Rent_App.core.pageobjects.LoginPage;
import il.co.bgurent.BGU_Rent_App.core.utils.Mapper;


public class BaseTest {

	
	static WebDriver driver;
	static final String CONF = System.getProperty("user.dir") + "/src/main/java/il/co/bgurent/BGU_Rent_App/core/or/config.properties";
	static final String DATA = System.getProperty("user.dir") + "/src/main/java/il/co/bgurent/BGU_Rent_App/core/or/datafile.properties";
	
	private LoginPage lp;

	@BeforeClass
	public void startUp() throws Exception {
		new Mapper(CONF);
		driver = Mapper.getDriver("CHROME");
		new Mapper(DATA);
		driver.get(Mapper.getData("QA_URL"));
		driver.manage().timeouts().implicitlyWait(7500, TimeUnit.MILLISECONDS);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		if(driver != null) {
			driver.quit();
		}
	}
	
	@Test(priority=0)
	public void TEST_TITLE_AND_FAIL_TO_AUTHENTICATION() throws Exception {
		lp = new LoginPage(driver);
		Assert.assertEquals(driver.getTitle(), Mapper.getData("TITLE_LOGIN_QA"));
		Assert.assertTrue(lp.attemptToAuthenticate(Mapper.getData("INVALID_USER"), Mapper.getData("INVALID_PASSWD")));
		Assert.assertTrue(lp.isHelpBlockMSGDisplayed());
		Assert.assertTrue(lp.isLoaderDisplayed());
		System.gc();
	}
	
	@Test(priority=1)
	public void TEST_TITLE_AND_LOGIN_AUTHENTICATION() throws Exception {
		lp = new LoginPage(driver);
		Assert.assertEquals(driver.getTitle(), Mapper.getData("TITLE_LOGIN_QA"));
		Assert.assertTrue(lp.attemptToAuthenticate(Mapper.getData("VALID_USER"), Mapper.getData("VALID_PASSWD")));
		Assert.assertFalse(lp.isHelpBlockMSGDisplayed());
		Assert.assertTrue(lp.isLoaderDisplayed());
		System.gc();
	}
}
