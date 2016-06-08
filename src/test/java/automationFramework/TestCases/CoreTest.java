package automationFramework.TestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import automationFramework.PageObjects.*;
import automationFramework.Utilities.*;

public class CoreTest {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	private String email;
	private String phoneNumber;

	public WebDriver getLabStatus(WebDriver driver) throws Exception{
		StatusPage statusPage = new StatusPage(driver);
		Log.info("QA Lab Version is: " + statusPage.getVersion(driver));
		return driver;
	}
		
	public WebDriver signIn(WebDriver driver) throws Exception{
		SignInPage snPage = new SignInPage(driver);
		snPage.getLandingPage(Global.URL2);
		snPage.enterUsername(driver, Global.USER);
		snPage.enterPasswd(driver, Global.PASSWD);
		snPage.clickSignin(driver);
		return driver;
	}
	
	
    public WebDriver createCustomer(WebDriver driver) throws Exception{
		
		DashboardPage dashPage = new DashboardPage(driver);
		dashPage.getLandingPage(Global.URL1);
		dashPage.clickCustomerTab(driver);
		dashPage.switchToFrame(driver);
		NewCustomerPage nPage = new NewCustomerPage(driver);
		nPage.clickSwitch(driver);
		nPage.clickCreateCustomer(driver);
		nPage.clickCustomerType(driver, Global.CUSTOMERTYPE);
		nPage.enterFirstname(driver, Global.FNAME);
		nPage.enterLastname(driver, Global.LNAME);
		email = Utils.randomEmailString();
		nPage.enterEmail(driver, email);
		phoneNumber = Utils.randomPhoneNumber();
		nPage.enterPhone(driver, phoneNumber);
		nPage.clickContinue(driver);
		
		NewCustomerPageTwo nPaget = new NewCustomerPageTwo(driver);
		nPaget.selectContactType(driver, Global.CONTACTTYPE);
		nPaget.selectCountry(driver);
        nPaget.enterAddress(driver, Global.ADDRESS );
        nPaget.enterCity(driver, Global.CITY);
        nPaget.selectState(driver);
        nPaget.enterPostalCode(driver, Global.POSTAL);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)", "");
        nPaget.selectPhoneType(driver, Global.PHONETYPE);
        nPaget.selectSecurityQ(driver);
        nPaget.enterSecuirtyA(driver, Global.SECURITYA);
        nPaget.enterUserName(driver, Utils.randomUsernameString());
        nPaget.enterPin(driver, Global.PIN);
        nPaget.enterDob(driver, Global.DOB);
        nPaget.clickSubmit(driver);   
        return driver;
	}
	

		
}