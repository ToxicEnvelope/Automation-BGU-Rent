package il.co.bgurent.BGU_Rent_App.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import il.co.bgurent.BGU_Rent_App.core.utils.UIMap;


public class BaseTest {

	
	static WebDriver driver;
	static final String CONF = System.getProperty("user.dir") + "/src/il/co/bgurent/or/config.properties";
	static final String DATA = System.getProperty("user.dir") + "/src/il/co/bgurent/or/datafile.properties";

	@BeforeClass
	public void startUp() throws Exception {
		new UIMap(CONF);
		driver = UIMap.getDriver("CHROME");
		new UIMap(DATA);
		driver.get(UIMap.getData("URL"));
		driver.manage().timeouts().implicitlyWait(7500, TimeUnit.MILLISECONDS);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		if(driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}
	
	@Test
	public void TEST_Title() throws Exception {
		Assert.assertEquals(driver.getTitle(), UIMap.getData("TITLE"));
	}
}
