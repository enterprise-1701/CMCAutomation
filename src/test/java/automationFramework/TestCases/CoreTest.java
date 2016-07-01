package automationFramework.TestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import automationFramework.PageObjects.*;
import automationFramework.Utilities.*;

public class CoreTest {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	private static String email;
	private static String phoneNumber;

	public WebDriver getLabStatus(WebDriver driver) throws Exception{
		StatusPage statusPage = new StatusPage(driver);
		Log.info("QA LAB VERSION: " + statusPage.getVersion(driver));
		Log.info("QA LAB BUILD: " + statusPage.getBuild(driver));
		Log.info("QA LAB MACHINE: " + statusPage.getMachine(driver));
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
	
	public String getEmail(){
		return email;
	}
	
	public String getPhone(){
		return phoneNumber;
	}
	
    public WebDriver createCustomer(WebDriver driver) throws Exception{
		
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
		email = Utils.randomEmailString();
		nPage.enterEmail(driver, email);
		phoneNumber = Utils.randomPhoneNumber();
		nPage.enterPhone(driver, phoneNumber);
		nPage.clickContinue(driver);
		
		NewCustomerPage nPaget = new NewCustomerPage(driver);
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
    
 public WebDriver createCustomer(WebDriver driver, String email) throws Exception{
		
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
		nPage.enterEmail(driver, email);
		phoneNumber = Utils.randomPhoneNumber();
		nPage.enterPhone(driver, phoneNumber);
		nPage.clickContinue(driver);
		
		NewCustomerPage nPaget = new NewCustomerPage(driver);
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