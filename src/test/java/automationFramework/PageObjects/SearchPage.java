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
import automationFramework.Utilities.Utils;
import org.openqa.selenium.JavascriptExecutor;

public class SearchPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
	private static final String CUSTOMERTYPE = ".//*[@id='searchCustomer_customerType_sel']";	
	private static final String FIRSTNAME = ".//*[@id='searchCustomer_firstname_txt']";	
	private static final String LASTNAME = ".//*[@id='searchCustomer_last_txt']";
	private static final String EMAIL = ".//*[@id='searchCustomer_email_txt']";
	private static final String PHONE = ".//*[@id='searchCustomer_phone_txt']";
	private static final String SEARCH = ".//*[@id='searchCustomer_search_btn']";
	private static final String NORECORD = "html/body/div[1]/div/div/customer/search-customer/fieldset/div/div/div[2]/customer-contacts/p-panel/div/div[2]/p";
	private static final String FIRSTRECORD = "//*[@id='customerContacts_list_tbl']/div/div[1]/table/tbody/tr[1]/td[1]/span";
	private static final String LEGEND = "//*[@id='Create Customer_legend']";
	private static final String FNAMETABLE = ".//*[@id='customerContacts_list_tbl']/div/div[1]/table/tbody/tr[1]/td[1]/span";
	private static final String LNAMETABLE = "//*[@id='customerContacts_list_tbl']/div/div[1]/table/tbody/tr[1]/td[2]/span";
	private static final String EMAILTABLE = "//*[@id='customerContacts_list_tbl']/div/div[1]/table/tbody/tr/td[3]/span";
	private static final String PHONETABLE = "//*[@id='customerContacts_list_tbl']/div/div[1]/table/tbody/tr/td[4]/span/span";
	private static final String ADDRESSTABLE = "//*[@id='customerContacts_list_tbl']/div/div[1]/table/tbody/tr/td[5]/span/span";
	private static final String DOBTABLE = "//*[@id='customerContacts_list_tbl']/div/div[1]/table/tbody/tr/td[6]/span/span";
	private static final String CUSTOMERTABLE = "//*[@id='customerContacts_list_tbl']/div/div[1]/table/tbody/tr/td[7]/span/span";
	private static final String CONTACTTABLE = "//*[@id='customerContacts_list_tbl']/div/div[1]/table/tbody/tr/td[8]/span";
	private static final String SECURITYQBOX = "//*[@id='verificationForm_securityQA_chk']";
	private static final String CONTINUE = "//*[@id='verificationForm_verified_btn']";
	private static final String NOTVERIFIED = "//*[@id='verificationForm_notVerified_btn']";
	private static final String EMAIL_ERROR = "//*[@id='v-email-alert']";
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void clickCustomerType(WebDriver driver, String value) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(CUSTOMERTYPE)));
		mySelect.selectByValue(value);	
	}

	public void enterFirstname(WebDriver driver, String firstname) throws InterruptedException, AWTException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIRSTNAME)));
		driver.findElement(By.xpath(FIRSTNAME)).click();
		driver.findElement(By.xpath(FIRSTNAME)).sendKeys(firstname);
	}
	
	public void enterLastname(WebDriver driver, String lastname) throws InterruptedException, AWTException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LASTNAME)));
		driver.findElement(By.xpath(LASTNAME)).click();
		driver.findElement(By.xpath(LASTNAME)).sendKeys(lastname);
	}

	public void enterEmail(WebDriver driver, String email) throws InterruptedException, AWTException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL)));
		driver.findElement(By.xpath(EMAIL)).click();
		driver.findElement(By.xpath(EMAIL)).sendKeys(email);
		//((JavascriptExecutor) driver).executeScript("arguments[0].value='test@test.com';", EMAIL);
	
	}
	public void enterPhone(WebDriver driver, String phone) throws InterruptedException, AWTException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PHONE)));
		driver.findElement(By.xpath(EMAIL)).click();
		driver.findElement(By.xpath(PHONE)).sendKeys(phone);
	}
	
	public void clickRecord(WebDriver driver) throws InterruptedException, AWTException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIRSTRECORD)));
		driver.findElement(By.xpath(FIRSTRECORD)).click();
	}
	
	public void clickSecurityBox(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SECURITYQBOX)).click();
	}
	
	public void clickNotVerified(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NOTVERIFIED)).click();
	}
	
	public void clickSearch(WebDriver driver) throws InterruptedException, AWTException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH)));
		driver.findElement(By.xpath(SEARCH)).click();
	}
	
	public void clickContiune(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CONTINUE)).click();
	}
	
	public String getNoRecordFound(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(NORECORD)).getText();
	}
	
	public String getFirstName(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(FNAMETABLE)).getText();
	}
	
	public String getLastName(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(LNAMETABLE)).getText();
	}
	
	public String getEmail(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(EMAILTABLE)).getText();
	}
	
	public String getPhone(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(PHONETABLE)).getText();
	}
	
	public String getAddress(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(ADDRESSTABLE)).getText();
	}
	
	public String getDob(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(DOBTABLE)).getText();
	}
	
	public String getCustomerType(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(CUSTOMERTABLE)).getText();
	}
	
	public String getContactType(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(CONTACTTABLE)).getText();
	}
	
	public String getEmailError(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(EMAIL_ERROR)).getText();
	}
	
	public boolean isRecordPresent(WebDriver driver) throws InterruptedException, AWTException{
		try{
		driver.findElement(By.xpath(FIRSTRECORD)).isDisplayed();
		return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
		return false;
		}
	}
	
	public boolean isLegendPresent(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(LEGEND)).isDisplayed();	
		}
	
	public boolean isSearchEnabled(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(SEARCH)).isEnabled();
		}
}