package automationFramework.TestCases;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import automationFramework.PageObjects.*;
import automationFramework.Utilities.*;

public class SearchTest {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	private static final String NORECORD = "No records found.";
	private static final String DOB = "17-05-1987";
	private static final String DOB2 = "19-05-2016";
	private static final String CRTYPE = "Individual";
	private static final String CTYPE = "Primary";
	private static final String STATE = "California";
	private static final String EXPIRATION = "01/2019";
	private static final String CARDTYPE = "Active";
	private static final String EMAIL = "FKosYaO6AwJU@gmail.com";
	private static final String EMAIL2 = "rbdownton@yahoo.com";
	private static final String DUPLICATE_EMAIL = "ray2331342@yahoo.com";
	private static final String PHONE = "7670117405";
	private static final String DUPLICATE_PHONE = "8899988888";
	private static final String FNAME = "mike";
	private static final String LNAME = "tyson";
	private static final String DUPLICATE_FNAME = "ray";
	private static final String DUPLICATE_LNAME = "tester";

	
	static WebDriver driver;
	static String browser;
	CoreTest coreTest = new CoreTest();
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws InterruptedException {

		Logging.setLogConsole();
		Logging.setLogFile();
		Log.info("Setup Started");
		Log.info("Current OS: " + WindowsUtils.readStringRegistryValue(Global.OS));
		Log.info("Current Browser: " + browser);
		driver = Utils.openBrowser(browser);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Log.info("Setup Completed");
	}

	
	@Test(priority=1 , enabled=false)
	public void searchCustomerVerifiedTest()throws Exception{
	
		coreTest.signIn(driver);
	    SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterFirstname(driver, Global.FNAME);
		sPage.enterLastname(driver, Global.LNAME);
		sPage.clickSearch(driver);

		/*
		Assert.assertEquals(sPage.getFirstName(driver),  Global.FNAME);
		Log.info("Actual results " +  sPage.getFirstName(driver) + " matches " +  Global.FNAME);
		Assert.assertEquals(sPage.getLastName(driver),  Global.LNAME);
		Log.info("Actual results " +  sPage.getLastName(driver) + " matches " +  Global.LNAME);
		Assert.assertEquals(sPage.getEmail(driver),  Global.EMAIL);
		Log.info("Actual results " +  sPage.getEmail(driver) + " matches " +  Global.EMAIL);
		Assert.assertEquals(sPage.getPhone(driver),  Global.PHONE);
		Log.info("Actual results " +  sPage.getPhone(driver) + " matches " +  Global.PHONE);
		Assert.assertEquals(sPage.getDob(driver),  DOB2);
		Log.info("Actual results " +  sPage.getDob(driver) + " matches " +  DOB2);
		Assert.assertEquals(sPage.getCustomerType(driver),  CRTYPE);
		Log.info("Actual results " +  sPage.getCustomerType(driver) + " matches " +  CRTYPE);
		Assert.assertEquals(sPage.getContactType(driver),  CTYPE);
		Log.info("Actual results " +  sPage.getContactType(driver) + " matches " +  CTYPE);
		Assert.assertEquals(sPage.getAddress(driver).substring(0, 12),  Global.ADDRESS);
		Log.info("Actual results " + sPage.getAddress(driver).substring(0, 12)  + " matches " +  Global.ADDRESS);
		*/
		
		sPage.clickRecord(driver);
		sPage.clickSecurityBox(driver);
		sPage.clickContiune(driver);
		
		/*
		Assert.assertEquals(sPage.getFirstName(driver),  Global.FNAME);
		Log.info("Actual results " +  sPage.getFirstName(driver) + " matches " +  Global.FNAME);
		Assert.assertEquals(sPage.getLastName(driver),  Global.LNAME);
		Log.info("Actual results " +  sPage.getLastName(driver) + " matches " +  Global.LNAME);
		Assert.assertEquals(sPage.getEmail(driver),  Global.EMAIL);
		Log.info("Actual results " +  sPage.getEmail(driver) + " matches " +  Global.EMAIL);
		Assert.assertEquals(sPage.getPhone(driver),  Global.PHONE);
		Log.info("Actual results " +  sPage.getPhone(driver) + " matches " +  Global.PHONE);
		Assert.assertEquals(sPage.getDob(driver),  DOB2);
		Log.info("Actual results " +  sPage.getDob(driver) + " matches " +  DOB2);
		Assert.assertEquals(sPage.getContactTypeTableTwo(driver),  CTYPE);
		Log.info("Actual results " +  sPage.getContactTypeTableTwo(driver) + " matches " +  CTYPE);
		Assert.assertEquals(sPage.getAddress(driver).substring(0, 12),  Global.ADDRESS);
		Log.info("Actual results " + sPage.getAddress(driver).substring(0, 12)  + " matches " +  Global.ADDRESS);
		*/
		
		driver.close();
		    	
	}
	
	
	@Test(priority=2 , enabled=true)
	public void searchCustomerNotVerifiedTest()throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterFirstname(driver, Global.FNAME);
		sPage.enterLastname(driver, Global.LNAME);
		sPage.clickSearch(driver);
		Utils.waitTime(5000);
		sPage.clickRecord(driver);
		sPage.clickNotVerified(driver);	
		Assert.assertTrue(sPage.isRecordPresent(driver), "customer records are not being displayed!");
		driver.close();
		    	
	}
	
	
	@Test(priority=3 , enabled=true)
	public void searchCustomerNoResultsTest()throws Exception{
	
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterFirstname(driver, Global.FNAME2);
		sPage.enterLastname(driver, Global.LNAME2);
		sPage.enterEmail(driver, Global.EMAIL);
		sPage.enterPhone(driver, Global.PHONE2);
		sPage.clickSearch(driver);
		Assert.assertEquals(sPage.getNoRecordFound(driver),  NORECORD);
		Log.info("Actual results " +  sPage.getNoRecordFound(driver) + " matches expected results " +  NORECORD);
		driver.close();
		    	
	}
	
	@Test(priority=4 , enabled=true)
	public void searchCustomerTypeNotSelected()throws Exception{
		
		coreTest.signIn(driver);
		DashboardPage dashPage = new DashboardPage(driver);
		dashPage.clickCustomerTab(driver);
		dashPage.switchToFrame(driver);
		SearchPage sPage = new SearchPage(driver);
		Assert.assertFalse(sPage.isSearchEnabled(driver), "Search button should not be enabled!");
		driver.close();
		    	
	}
	
	@Test(priority=5 , enabled=true)
	public void searchCustomerInvalidEmail() throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterFirstname(driver, Global.FNAME);
		sPage.enterLastname(driver, Global.LNAME);
		sPage.enterEmail(driver, Global.FNAME);
		Assert.assertEquals(sPage.getEmailError(driver), Global.INVALID_EMAIL);
		Assert.assertFalse(sPage.isSearchEnabled(driver), "Search button should not be enabled!");
		driver.close();
	
	}
	
	@Test(priority=6 , enabled=true)
	public void searchCustomerCheckDuplicateTestFname()throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterFirstname(driver, FNAME);
		sPage.clickSearch(driver);
		Utils.waitTime(5000);
		Assert.assertEquals(sPage.getFirstName(driver), FNAME);
		driver.close();
		    	
	}
	
	@Test(priority=7 , enabled=true)
	public void searchCustomerCheckDuplicateTestLname()throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterLastname(driver, LNAME);
		sPage.clickSearch(driver);
		Utils.waitTime(5000);
		Assert.assertEquals(sPage.getLastName(driver), LNAME);
		driver.close();
		    	
	}
	
	@Test(priority=8 , enabled=true)
	public void searchCustomerCheckDuplicateTestFnameLname()throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterFirstname(driver, FNAME);
		sPage.enterLastname(driver, LNAME);
		sPage.clickSearch(driver);
		Utils.waitTime(5000);
		Assert.assertEquals(sPage.getFirstName(driver), FNAME);
		Assert.assertEquals(sPage.getLastName(driver), LNAME);
		driver.close();
		    	
	}
	
	@Test(priority=9 , enabled=true)
	public void searchCustomerCheckDuplicateTestPhone()throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterPhone(driver, DUPLICATE_PHONE);
		sPage.clickSearch(driver);
		Utils.waitTime(5000);
		Assert.assertEquals(sPage.getPhone(driver), DUPLICATE_PHONE);
		driver.close();
		    	
	}
	
	@Test(priority=10 , enabled=true)
	public void searchCustomerCheckDuplicateTestEmail()throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterEmail(driver, DUPLICATE_EMAIL);
		sPage.clickSearch(driver);
		Utils.waitTime(5000);
		Assert.assertEquals(sPage.getEmail(driver), DUPLICATE_EMAIL);
		driver.close();
		    	
	}
	
	@Test(priority=11 , enabled=true)
	public void searchCustomerCheckDuplicateTestEmailPhone()throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterEmail(driver, DUPLICATE_EMAIL);
		sPage.enterPhone(driver, DUPLICATE_PHONE);
		sPage.clickSearch(driver);
		Utils.waitTime(5000);
		Assert.assertEquals(sPage.getPhone(driver), DUPLICATE_PHONE);
		Assert.assertEquals(sPage.getEmail(driver), DUPLICATE_EMAIL);
		driver.close();
		    	
	}
	
	@Test(priority=12 , enabled=true)
	public void searchCustomerCheckDuplicateTestAll()throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.enterFirstname(driver, DUPLICATE_FNAME);
		sPage.enterLastname(driver, DUPLICATE_LNAME);
		sPage.enterEmail(driver, DUPLICATE_EMAIL);
		sPage.enterPhone(driver, DUPLICATE_PHONE);
		sPage.clickSearch(driver);
		Utils.waitTime(5000);
		Assert.assertEquals(sPage.getFirstName(driver), DUPLICATE_FNAME);
		Assert.assertEquals(sPage.getLastName(driver), DUPLICATE_LNAME);
		Assert.assertEquals(sPage.getPhone(driver), DUPLICATE_PHONE);
		Assert.assertEquals(sPage.getEmail(driver), DUPLICATE_EMAIL);
		driver.close();
		    	
	}
	
	

	//private methods 
	private SearchPage getSearchPage() throws Exception{
		
		DashboardPage dashPage = new DashboardPage(driver);
		dashPage.clickCustomerTab(driver);
		dashPage.switchToFrame(driver);
	    SearchPage sPage = new SearchPage(driver);
	    return sPage;	
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}