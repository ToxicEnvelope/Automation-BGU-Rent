package il.co.bgurent.BGU_Rent_App.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import il.co.bgurent.BGU_Rent_App.core.utils.Mapper;


public class BaseTest {

	
	static WebDriver driver;
	static final String CONF = System.getProperty("user.dir") + "/src/main/java/il/co/bgurent/BGU_Rent_App/core/or/config.properties";
	static final String DATA = System.getProperty("user.dir") + "/src/main/java/il/co/bgurent/BGU_Rent_App/core/or/datafile.properties";

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
	
	@Test
	public void TEST_Title() throws Exception {
		Assert.assertEquals(driver.getTitle(), Mapper.getData("TITLE"));
	}
}
