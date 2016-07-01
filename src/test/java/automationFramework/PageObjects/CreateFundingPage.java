package automationFramework.PageObjects;


import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.gargoylesoftware.htmlunit.WebClient;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Utils;

public class CreateFundingPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
	    private static final String PAYMENTTYPE = "//*[@id='fundingSourceForm_paymentType_sel']";
		private static final String NAMEONCARD = ".//*[@id='fundingSourceForm_nameOnCard_txt']";
		private static final String CARDNUMBER = ".//*[@id='fundingSourceForm_cardNumber_txt']";
		private static final String MONTH_EXP = "//*[@id='fundingSourceForm_cardExpiryMM_sel']";
		private static final String YEAR_EXP = "//*[@id='fundingSourceForm_cardExpiryYYYY_sel']";
		
		
		private static final String ISPRIMARY = "//*[@id='fundingSourceForm_isPrimary_chk']";
		private static final String ISRECURRING = "//*[@id='fundingSourceForm_isRecurring_chk']";
		private static final String BILLING_ADDRESS_BOX = "//*[@id='fundingSourceForm_isBillingAddressSame_chk']";
		private static final String SUBMIT = "//*[@id='fundingSourceForm_submit_btn']";
		private static final String CANCEL = "//*[@id='searchCustomer_cancel_btn']";
		private static final String T_NAMEONCARD = "//*[@id='fundingSources_list_tbl']/div/div[1]/table/tbody/tr/td[1]/span";
		private static final String T_CARDTYPE = "//*[@id='fundingSources_list_tbl']/div/div[1]/table/tbody/tr/td[2]";
		private static final String T_CARDNUMBER = ".//*[@id='fundingSources_list_tbl']/div/div/table/tbody/tr/td[3]/span/span";
		private static final String T_CARDEXPIRATION =  "//*[@id='fundingSources_list_tbl']/div/div[1]/table/tbody/tr/td[4]/span/span";										
		private static final String T_CARDSTATUS = "//*[@id='fundingSources_list_tbl']/div/div[1]/table/tbody/tr/td[5]/span/span";											
		private static final String T_BILLING_ADDRESS =  "//*[@id='fundingSources_list_tbl']/div/div[1]/table/tbody/tr/td[8]/span/span";
		private static final String COUNTRY = "//*[@id='fundingSourceForm_countryId_sel']";
		private static final String NEW_BILLINGADDRESS = "//*[@id='fundingSourceForm_address1_txt']";
		private static final String CITY = "//*[@id='fundingSourceForm_city_txt']";
		private static final String STATE = "//*[@id='fundingSourceForm_state_sel']";
		private static final String POSTAL = "//*[@id='fundingSourceForm_postalCode_txt']";
		private static final String T_NEWBILLINGADDRESS = ".//*[@id='addresses_list_tbl']/div/div[1]/table/tbody/tr[1]/td[1]/span";
		private static final String T_NEWCITY = ".//*[@id='addresses_list_tbl']/div/div[1]/table/tbody/tr[1]/td[3]/span";
		private static final String T_NEWSTATE = "//*[@id='addresses_list_tbl']/div/div[1]/table/tbody/tr/td[4]/span";
		private static final String T_NEWPOSTAL = ".//*[@id='addresses_list_tbl']/div/div[1]/table/tbody/tr[1]/td[5]/span";
		private static final String CREATE_CONTACT = ".//*[@id='viewCustomer_createContact_lnk']";
		
		
	public CreateFundingPage(WebDriver driver) {
		super(driver);
	}

	public void selectPaymentType(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(PAYMENTTYPE)));
		mySelect.selectByIndex(1);
	}
	
	public void enterName(WebDriver driver, String name) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NAMEONCARD)).click();
		driver.findElement(By.xpath(NAMEONCARD)).sendKeys(name);
	}
	
	public void enterCC(WebDriver driver, String cc) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CARDNUMBER)).click();
		driver.findElement(By.xpath(CARDNUMBER)).sendKeys(cc);
	}
	
	public void enterNewBillingAddress(WebDriver driver, String newAddress) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEW_BILLINGADDRESS)).click();
		driver.findElement(By.xpath(NEW_BILLINGADDRESS)).sendKeys(newAddress);
	}
	
	public void enterCity(WebDriver driver, String city) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CITY)).sendKeys(city);
	}
	
	public void enterPostalCode(WebDriver driver, String postal) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(POSTAL)).click();
		driver.findElement(By.xpath(POSTAL)).sendKeys(postal);
	}
	
	public void selectMonth(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(MONTH_EXP)));
		mySelect.selectByIndex(1);
	}
	
	public void selectYear(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(YEAR_EXP)));
		mySelect.selectByIndex(5);
	}
	
	public void selectCountry(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(COUNTRY)));
		mySelect.selectByIndex(7);
	}
	
	public void selectState(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(STATE)));
		mySelect.selectByIndex(6);
	}
	
	public void clickIsPrimary(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ISPRIMARY)).click();
	}
	
	public void clickIsRecurring(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ISRECURRING)).click();
	}
	
	public void clickBillingAddress(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(BILLING_ADDRESS_BOX)).click();
	}

	public void clickSubmit(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SUBMIT)).click();
	}
	
	public void clickCancel(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CANCEL)).click();
	}
	
	public String getCCname(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(T_NAMEONCARD)).getText();	
	}
	
	public String getCardType(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(T_CARDTYPE)).getText();	
	}
	
	public String getCardNumber(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(T_CARDNUMBER)).getText();	
	}
	
	public String getCardExpiration(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(T_CARDEXPIRATION)).getText();	
	}
	
	public String getCardStatus(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(T_CARDSTATUS)).getText();	
	}
	
	public String getBillingAddress(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath( T_BILLING_ADDRESS)).getText();	
	}
	
	public String getNewBillingAddress(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath( T_NEWBILLINGADDRESS)).getText();	
	}
	
	public String getNewCity(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath( T_NEWCITY)).getText();	
	}
	
	public String getNewState(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath( T_NEWSTATE)).getText();	
	}
	
	public String getNewPostalCode(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath( T_NEWPOSTAL)).getText();	
	}
	
	public boolean isCreateContactDisplayed(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(CREATE_CONTACT)).isDisplayed();
		}
	
	public boolean isSubmitEnabled(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(SUBMIT)).isEnabled();
		}
	
}