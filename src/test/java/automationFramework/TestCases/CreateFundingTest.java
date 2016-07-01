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

public class CreateFundingTest {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	private static final String NORECORD = "No records found.";
	private static final String DOB = "19-05-2016";
	private static final String CRTYPE = "Individual";
	private static final String CTYPE = "Primary";
	private static final String STATE = "California";
	private static final String EXPIRATION = "01/2020";
	private static final String CARDTYPE = "Active";
	private static final String POSTAL = "92122";
	private String phoneNumber;
	private String email;
	
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

	
	@Test(priority=1 , enabled=true)
	public void createFundingSource() throws Exception{
		
		coreTest.signIn(driver);
		coreTest.createCustomer(driver);
        NewCustomerDisplayPage nPage3 = new NewCustomerDisplayPage(driver);
        nPage3.clickFundingSource(driver);
        CreateFundingPage cPage = new CreateFundingPage(driver);
        cPage.selectPaymentType(driver);
        cPage.enterName(driver, Global.CCNAME );
        cPage.enterCC(driver, Global.CC);
        cPage.selectMonth(driver);
        cPage.selectYear(driver);
        cPage.clickSubmit(driver);
        Utils.waitTime(5000);
        
      	Assert.assertEquals(cPage.getCardType(driver),  Global.CCTYPE);
      	Log.info("Actual results " +  cPage.getCardType(driver) + " matches expected results " +  Global.CCTYPE);
      	Assert.assertEquals(cPage.getCardNumber(driver),  Global.CCMASKED);
      	Log.info("Actual results " +  cPage.getCardNumber(driver) + " matches expected results " +  Global.CCMASKED);
    	Assert.assertEquals(cPage.getCardExpiration(driver),  EXPIRATION);
      	Log.info("Actual results " +  cPage.getCardExpiration(driver) + " matches expected results " +  EXPIRATION);
      	Assert.assertEquals(cPage.getCardStatus(driver),  CARDTYPE);
      	Log.info("Actual results " + cPage.getCardStatus(driver)  + " matches expected results " +  CARDTYPE);
      	Assert.assertEquals(cPage.getBillingAddress(driver).substring(0, 12),  Global.ADDRESS);
		Log.info("Actual results " + nPage3.getAddress(driver).substring(0, 12)  + " matches " +  Global.ADDRESS);
		driver.close();
      	
	}
		
	@Test(priority=2 , enabled=true)
	public void createFundingSourceNewBillingAddress() throws Exception{
		
		coreTest.signIn(driver);
		coreTest.createCustomer(driver);
        NewCustomerDisplayPage nPage3 = new NewCustomerDisplayPage(driver);
        nPage3.clickFundingSource(driver);
        CreateFundingPage cPage = new CreateFundingPage(driver);
        cPage.selectPaymentType(driver);
        cPage.enterName(driver, Global.CCNAME );
        cPage.enterCC(driver, Global.CC);
        cPage.selectMonth(driver);
        cPage.selectYear(driver);
        cPage.clickBillingAddress(driver);
        Utils.waitTime(3000);
        cPage.selectCountry(driver);
        cPage.enterNewBillingAddress(driver, Global.NEWADDRESS);
        cPage.enterCity(driver, Global.NEWCITY);
        cPage.selectState(driver);
        cPage.enterPostalCode(driver, POSTAL);
        cPage.clickSubmit(driver);
        Utils.waitTime(1000);
        Assert.assertEquals(cPage.getCCname(driver),  Global.CCNAME);
      	Log.info("Actual results " + cPage.getCCname(driver)  + " matches expected results " +  Global.CCNAME);
      	Assert.assertEquals(cPage.getCardType(driver),  Global.CCTYPE);
      	Log.info("Actual results " +  cPage.getCardType(driver) + " matches expected results " +  Global.CCTYPE);
      	Assert.assertEquals(cPage.getCardNumber(driver),  Global.CCMASKED);
      	Log.info("Actual results " +  cPage.getCardNumber(driver) + " matches expected results " +  Global.CCMASKED);
    	Assert.assertEquals(cPage.getCardExpiration(driver),  EXPIRATION);
      	Log.info("Actual results " +  cPage.getCardExpiration(driver) + " matches expected results " +  EXPIRATION);
      	Assert.assertEquals(cPage.getCardStatus(driver),  CARDTYPE);
      	Log.info("Actual results " + cPage.getCardStatus(driver)  + " matches expected results " +  CARDTYPE);
      	Assert.assertEquals(cPage.getBillingAddress(driver).substring(0, 10),  Global.NEWADDRESS);
		Log.info("Actual results " + nPage3.getAddress(driver).substring(0, 10)  + " matches " +  Global.NEWADDRESS);
    	Assert.assertEquals(cPage.getNewState(driver),  STATE);
      	Log.info("Actual results " +  cPage.getNewState(driver) + " matches expected results " +  STATE);
      	Assert.assertEquals(cPage.getNewPostalCode(driver),  POSTAL);
      	Log.info("Actual results " +  cPage.getNewPostalCode(driver) + " matches expected results " +  POSTAL);
      	driver.close();
      	
	}
	

	@Test(priority=3 , enabled=true)
	public void createFundingSourceCancel() throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.clickSearch(driver);
		sPage.clickRecord(driver);
		sPage.clickSecurityBox(driver);
		sPage.clickContiune(driver);
		NewCustomerDisplayPage nPage3 = new NewCustomerDisplayPage(driver);
        nPage3.clickFundingSource(driver);
        CreateFundingPage cPage = new CreateFundingPage(driver);
        cPage.selectPaymentType(driver);
        cPage.enterName(driver, Global.CCNAME );
        cPage.enterCC(driver, Global.CC);
        cPage.selectMonth(driver);
        cPage.selectYear(driver);
        cPage.clickCancel(driver);
    	Assert.assertTrue(cPage.isCreateFundingSourceDisplayed(driver), "create funding source link should be displayed!");
    	driver.close();
      	
	}
	
	
	@Test(priority=4 , enabled=true)
	public void createFundingSourceTypeNotSelected() throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.clickSearch(driver);
		sPage.clickRecord(driver);
		sPage.clickSecurityBox(driver);
		sPage.clickContiune(driver);
		NewCustomerDisplayPage nPage3 = new NewCustomerDisplayPage(driver);
        nPage3.clickFundingSource(driver);
        CreateFundingPage cPage = new CreateFundingPage(driver);
        cPage.enterName(driver, Global.CCNAME );
        cPage.enterCC(driver, Global.CC);
        cPage.selectMonth(driver);
        cPage.selectYear(driver);
    	Assert.assertFalse(cPage.isSubmitEnabled(driver), "Submit button should not be enabled!");
    	driver.close();   	
	}
	
	@Test(priority=5 , enabled=true)
	public void createCustomerInvalidEmail() throws Exception{
		
		coreTest.signIn(driver);
		DashboardPage dashPage = new DashboardPage(driver);
		dashPage.getLandingPage(Global.URL1);
		dashPage.clickCustomerTab(driver);
		dashPage.switchToFrame(driver);
		CreateCustomerPage nPage = new CreateCustomerPage(driver);
		nPage.clickSwitch(driver);
		nPage.clickCreateCustomer(driver);
		nPage.clickCustomerType(driver, Global.CUSTOMERTYPE);
		nPage.enterFirstname(driver, Global.FNAME);
		nPage.enterLastname(driver, Global.LNAME);
		nPage.enterEmail(driver, Utils.randomUsernameString());
		Assert.assertFalse(nPage.isContinueEnabled(driver), "Continue button should not be enabled!");
		Assert.assertEquals(nPage.getEmailError(driver),  Global.INVALID_EMAIL);	
		nPage.enterEmail(driver, Utils.randomEmailString());
		nPage.enterPhone(driver, Utils.randomPhoneNumber());
		nPage.clickContinue(driver);
		NewCustomerPage nPaget = new NewCustomerPage(driver);
		nPaget.selectContactType(driver, Global.CONTACTTYPE);
		nPaget.selectCountry(driver);
        nPaget.enterAddress(driver, Global.ADDRESS );
        nPaget.enterCity(driver, Global.CITY);
        nPaget.enterPostalCode(driver, Global.POSTAL);
        nPaget.enterEmail(driver, Utils.randomUsernameString());
        Assert.assertFalse(nPaget.isSubmitEnabled(driver), "Submit button should not be enabled!");
		Assert.assertEquals(nPaget.getEmailError(driver), Global.INVALID_EMAIL );
		driver.close();
        
	}
	
	@Test(priority=6 , enabled=true)
	public void createCustomerFundingInvalidCC() throws Exception{
		
		coreTest.signIn(driver);
		SearchPage sPage = getSearchPage();
		sPage.clickCustomerType(driver, "Individual");
		sPage.clickSearch(driver);
		sPage.clickRecord(driver);
		sPage.clickSecurityBox(driver);
		sPage.clickContiune(driver);
		NewCustomerDisplayPage nPage3 = new NewCustomerDisplayPage(driver);
        nPage3.clickFundingSource(driver);
        CreateFundingPage cPage = new CreateFundingPage(driver);
        cPage.enterName(driver, Global.CCNAME );
        cPage.enterCC(driver, Global.INVALID_CC);
        cPage.selectMonth(driver);
        cPage.selectYear(driver);
    	Assert.assertFalse(cPage.isSubmitEnabled(driver), "Submit button should not be enabled!");
    	driver.close();   
		
	}
	

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